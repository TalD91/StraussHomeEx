package com.strauss.RestAPIServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strauss.RestAPIServer.dataConnectors.MongoConnector;
import com.strauss.RestAPIServer.models.Device;
import com.strauss.RestAPIServer.models.ServerConfiguration;
import com.strauss.RestAPIServer.models.UserResponse;
import com.strauss.RestAPIServer.models.WeatherDetails;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
public class RestAPIController {

    private final String resourceDir = System.getProperty("user.dir")+"/src/main/resources/";
    private ServerConfiguration serverConfiguration;

    @Autowired
    private MongoConnector dataConnector;

    @Autowired
    private WebClient.Builder webClientBuilder;

	public RestAPIController() throws IOException {
        readPropertiesJSONFile();
	}

    /**
     * Reads the json properties and convert to java object with jackson
     * @throws IOException
     */
	private void readPropertiesJSONFile() throws IOException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    File jsonConfigurationFile = new File(resourceDir+"generalConfiguration.json");
        serverConfiguration = objectMapper.readValue(jsonConfigurationFile,ServerConfiguration.class);
    }

    /**
     * Gets the weather -
     * By using the id in the document in MongoDB
     * From the document gets the Latitude and Longitude
     * Then sends the coordinations to the API
     * @param id - takes id as input to search the DB
     * @return
     */
    private UserResponse getWeatherById(String id) {
        try {
            // Get the Information for the database - in our case - mongoDB
            Device deviceDetails = dataConnector.findById(id).get();
            // do the actual rest API
            String params = String.format("?lang=en&lat=%s&lon=%s", deviceDetails.getDeviceLatitude(), deviceDetails.getDeviceLongitude());
            String rawJSONResponse = webClientBuilder.build()
                    .get()
                    .uri(serverConfiguration.getWeatherUrl() + params)
                    .accept(MediaType.APPLICATION_JSON)
                    .header(serverConfiguration.getWeatherHeaderRapidHostName(), serverConfiguration.getWeatherHeaderRapidHostKey())
                    .header(serverConfiguration.getWeatherHeaderRapidKeyName(), serverConfiguration.getWeatherHeaderRapidKey())
                    .retrieve().bodyToMono(String.class).block();

            JSONObject parsedData = parseObjectFromData(rawJSONResponse);
            WeatherDetails weatherDetails = new WeatherDetails();
            weatherDetails.setTimezone((String) parsedData.get("timezone"));
            weatherDetails.setCountryCode((String) parsedData.get("country_code"));
            weatherDetails.setCityName((String) parsedData.get("city_name"));
            weatherDetails.setSnow((int) parsedData.get("snow"));
            weatherDetails.setTemp((double) parsedData.get("temp"));
            UserResponse response = new UserResponse(id, deviceDetails, true, weatherDetails);
            return response;
        }
        catch (NoSuchElementException noElementException) {
            UserResponse response = new UserResponse(id,null,false,null);
            response.setErrorMessage("Error! No element with such ID exists");
            return response;
        }

    }

    /**
     * parses the object according to our needs from the API
     * @param rawJSONString - raw string from the API
     * @return JSONObject with all attributes
     */
    private JSONObject parseObjectFromData(String rawJSONString) {
        JSONObject jsonFromWeatherAPI = (JSONObject) JSONValue.parse(rawJSONString);
        JSONArray dataArray = (JSONArray) jsonFromWeatherAPI.get("data");
        return (JSONObject) dataArray.get(0);
    }
    @GetMapping("/getweather")
    public UserResponse getweather(@RequestParam(value = "id") String id) {
        return getWeatherById(id);
    }
}
