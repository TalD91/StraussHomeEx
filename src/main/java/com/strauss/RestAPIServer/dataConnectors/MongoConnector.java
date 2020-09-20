package com.strauss.RestAPIServer.dataConnectors;

import com.strauss.RestAPIServer.models.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Connected interface to MongoRepository interface in Spring framework
 */
public interface MongoConnector extends MongoRepository<Device, String> {

}
