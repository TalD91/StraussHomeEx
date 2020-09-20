var db = connect('admin:admin@localhost:27017/admin');
db.devices.insert({'_id': 'IL-001','lastHeartbeat': 1600621667, 'deviceLongitude': 34.7817131, 'deviceLatitude': 32.0854162,'deviceHeight': 0,'enabled': true, 'connected': true});
db.devices.insert({'_id': 'IL-002','lastHeartbeat': 1600622046, 'deviceLongitude': 34.8101149, 'deviceLatitude': 31.963571,'deviceHeight': 50,'enabled': false, 'connected': false});
db.devices.insert({'_id': 'IL-003','lastHeartbeat': 1600622107, 'deviceLongitude': 35.2250786, 'deviceLatitude': 31.778345,'deviceHeight': 757,'enabled': true, 'connected': false});
db.devices.insert({'_id': 'IL-004','lastHeartbeat': 1600622139, 'deviceLongitude': 34.998386, 'deviceLatitude': 32.819122,'deviceHeight': 98,'enabled': true, 'connected': true});

var allDevices = db.devices.find();
while (allDevices.hasNext()) {
    printjson(allDevices.next());
}
