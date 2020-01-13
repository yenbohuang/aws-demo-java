// FIXME

//package org.yenbo.awssdkdemo.iot;
//
//import java.io.IOException;
//import java.net.URI;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.entity.EntityBuilder;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.yenbo.awssdkdemo.PropertiesSingleton;
//import org.yenbo.commonUtils.KeyReader;
//import org.yenbo.commonUtils.KeyReader.PrivateKeyType;
//
//public class AwsIotHttpsClient {
//
//	private static final Logger log = LoggerFactory.getLogger(AwsIotHttpsClient.class);
//	
//	public AwsIotHttpsClient() {
//	}
//
//	public void publish(String topic, String payload) throws Exception {
//		
//		URI uri = new URIBuilder()
//				.setScheme("https")
//				.setHost(PropertiesSingleton.getInstance().getParam("iot.endpointAddress"))
//				.setPort(8443)
//				.setPath(String.format("/topics/%s", topic))
//				.setParameter("qos", "1")
//				.build();
//		
//		log.info("Publish to: " + uri.toString());
//		log.info("Payload: " + payload);
//		
//		HttpPost httpPost = new HttpPost(uri);
//		httpPost.setEntity(EntityBuilder.create()
//				.setContentEncoding("UTF-8")
//				.setText(payload)
//				.build());
//		
//		ResponseHandler<CloseableHttpResponse> responseHandler = 
//				new ResponseHandler<CloseableHttpResponse>() {
//
//					@Override
//					public CloseableHttpResponse handleResponse(HttpResponse response)
//							throws ClientProtocolException, IOException {
//						
//						log.debug("Response: " + EntityUtils.toString(response.getEntity()));
//						return (CloseableHttpResponse) response;
//					}
//			
//		};
//		
//		KeyReader keyReader = new KeyReader(
//				PropertiesSingleton.getInstance().getParam("iot.certificateFilePath"),
//				PropertiesSingleton.getInstance().getParam("iot.privateKeyFilePath"),
//				PrivateKeyType.RSA);
//		
//		HttpClient client = HttpClientBuilder.create()
//				.setSSLContext(keyReader.getSslContext())
//				.build();
//		
//		client.execute(httpPost, responseHandler);
//	}
//}
