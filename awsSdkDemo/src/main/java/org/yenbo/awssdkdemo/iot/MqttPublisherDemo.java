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
//public class MqttPublisherDemo {
//
//	private static final Logger log = LoggerFactory.getLogger(MqttPublisherDemo.class);
//	
//	public static void main(String[] args) {
//		
//		readProperties();
//		
//		try {
//			AwsMqttClient client = new AwsMqttClient();
//			client.connect();
//			log.debug("Connected");
//			
//			ArrayList<String> topicFilters = new ArrayList<>();
//			topicFilters.add("topic/test");
//			topicFilters.add(TopicNames.getShadowUpdateAccepted());
//			topicFilters.add(TopicNames.getShadowUpdateRejected());
//			topicFilters.add(TopicNames.getShadowUpdateDelta());
//			topicFilters.add(TopicNames.getShadowGetAccepted());
//			topicFilters.add(TopicNames.getShadowGetRejected());
//			
//			client.subscribe(topicFilters);
//			
//			for (int i = 0; i < 5; i++) {
//				
//				client.publish("topic/test", ZonedDateTime.now().toString());
//				client.publish(TopicNames.getShadowGet(), null);
//				client.publish(TopicNames.getShadowUpdate(), ShadowJsonFactory.getShadowJson());
//				
//				Thread.sleep(2000);
//				log.debug("Sleep complete");
//			}
//			
//			client.disconnect();
//			log.debug("Disconnected");
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
