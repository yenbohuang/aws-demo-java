package org.yenbo.awssdkdemo;

public class PropertiesSingleton {

	private static PropertiesSingleton propertyReader;

	private PropertiesReader reader;
	
	private PropertiesSingleton() {
		reader = new PropertiesReader("D:/ws-git/documents/infra/AWS/awsdemo.properties",
				PropertiesReader.FileType.FILE);
	}

	public static final PropertiesSingleton getInstance() {
		
		if (propertyReader == null) {
			propertyReader = new PropertiesSingleton();
		}
		
		return propertyReader;
	}
	
	public String getParam(String key) {
		return reader.getParam(key);
	}
}
