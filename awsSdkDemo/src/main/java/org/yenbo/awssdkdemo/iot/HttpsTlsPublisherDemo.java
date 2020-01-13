// FIXME

//package org.yenbo.awssdkdemo.iot;
//
//import java.time.ZonedDateTime;
//import java.util.ArrayList;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.yenbo.awssdkdemo.PropertiesSingleton;
//
//public class HttpsTlsPublisherDemo {
//
//	private static final Logger log = LoggerFactory.getLogger(HttpsTlsPublisherDemo.class);
//	
//	public static void main(String[] args) {
//	
//		readProperties();
//		
//		AwsIotHttpsClient httpsClient = new AwsIotHttpsClient();
//		
//		try {
//			
//			AwsMqttClient mqttClient = new AwsMqttClient();
//			mqttClient.connect();
//			
//			ArrayList<String> topicFilters = new ArrayList<>();
//			topicFilters.add("test/topic");
//			topicFilters.add(TopicNames.getShadowUpdateAccepted());
//			topicFilters.add(TopicNames.getShadowUpdateDelta());
//			topicFilters.add(TopicNames.getShadowUpdateRejected());
//			
//			
//			mqttClient.subscribe(topicFilters);
//			
//			for (int i = 0; i < 5; i++) {
//			
//				httpsClient.publish("test/topic", ZonedDateTime.now().toString());
//				httpsClient.publish(TopicNames.getShadowUpdate(), ShadowJsonFactory.getShadowJson());
//			
//				Thread.sleep(2000);
//				log.debug("Sleep complete");
//			}
//			
//			mqttClient.disconnect();
//			
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//		}
//	}
//	
//	private static void readProperties() {
//		PropertiesSingleton.getInstance().getParam("iot.endpointAddress");
//		PropertiesSingleton.getInstance().getParam("iot.certificateFilePath");
//		PropertiesSingleton.getInstance().getParam("iot.thingName");
//		PropertiesSingleton.getInstance().getParam("iot.privateKeyFilePath");
//	}
//}
