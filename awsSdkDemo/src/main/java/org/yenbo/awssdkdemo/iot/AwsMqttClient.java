// FIXME

//package org.yenbo.awssdkdemo.iot;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import org.apache.commons.lang3.StringUtils;
//import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
//import org.eclipse.paho.client.mqttv3.MqttCallback;
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
//import org.eclipse.paho.client.mqttv3.MqttSecurityException;
//import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.yenbo.awssdkdemo.PropertiesSingleton;
//import org.yenbo.commonUtils.KeyReader;
//import org.yenbo.commonUtils.KeyReader.PrivateKeyType;
//
//public class AwsMqttClient {
//
//	private static final Logger log = LoggerFactory.getLogger(AwsMqttClient.class);
//	
//	private String endpoint;
//	private MqttClient client;
//	private MqttConnectOptions connectOptions;
//	
//	public AwsMqttClient() throws Exception {
//		
//		// end point
//		endpoint = String.format("ssl://%s:8883",
//				PropertiesSingleton.getInstance().getParam("iot.endpointAddress"));
//		log.info(endpoint);
//		
//		// create client
//		MemoryPersistence persistence = new MemoryPersistence();
//		
//		client = new MqttClient(endpoint,
//				PropertiesSingleton.getInstance().getParam("iot.thingName"),
//				persistence);
//		
//		// key and certificates
//		KeyReader keyReader = new KeyReader(
//				PropertiesSingleton.getInstance().getParam("iot.certificateFilePath"),
//				PropertiesSingleton.getInstance().getParam("iot.privateKeyFilePath"),
//				PrivateKeyType.RSA);
//		
//		// create connect options
//		connectOptions = new MqttConnectOptions();
//		connectOptions.setCleanSession(true);
//		connectOptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
//		connectOptions.setSocketFactory(keyReader.getSslContext().getSocketFactory());
//		
//		// callback
//		client.setCallback(new MqttCallback() {
//			
//			@Override
//			public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
//
//				log.info("Message arrived. topic: {}, QoS: {}, payload: {}", arg0, arg1.getQos(),
//						new String(arg1.getPayload()));
//			}
//			
//			@Override
//			public void deliveryComplete(IMqttDeliveryToken arg0) {
//
//				log.debug("Deliver complete. topics: {}", Arrays.toString(arg0.getTopics()));
//			}
//			
//			@Override
//			public void connectionLost(Throwable arg0) {
//				log.error(arg0.getMessage(), arg0);
//			}
//		});
//	}
//
//	public void connect() throws MqttSecurityException, MqttException {
//		client.connect(connectOptions);
//	}
//	
//	public void disconnect() throws MqttException {
//		client.disconnect();
//	}
//	
//	public void publish(String topic, String payload) throws MqttPersistenceException, MqttException {
//		
//		if (StringUtils.isBlank(topic)) {
//			throw new IllegalArgumentException("topic is blank");
//		}
//		
//		log.info("Publish: topic={}, payload={}", topic, payload);
//		
//		MqttMessage testMessage = (payload != null) ? new MqttMessage(payload.getBytes()) :
//			new MqttMessage();
//		testMessage.setQos(0);
//		client.publish(topic, testMessage);
//	}
//	
//	public void subscribe(ArrayList<String> topicFilters) throws MqttException {
//		
//		if (topicFilters == null) {
//			throw new IllegalArgumentException("topicFilters is null");
//		}
//		
//		int[] qos = new int[topicFilters.size()];
//		Arrays.fill(qos, 0);
//		
//		log.info("Subscribe: " + topicFilters);
//		
//		client.subscribe(topicFilters.toArray(new String[0]), qos);
//	}
//	
//	public void subscribe(String topicFilter) throws MqttException {
//		
//		if (StringUtils.isBlank(topicFilter)) {
//			throw new IllegalArgumentException("topicFilter is blank");
//		}
//		
//		log.info("Subscribe: " + topicFilter);
//		
//		client.subscribe(topicFilter, 0);
//	}
//}
