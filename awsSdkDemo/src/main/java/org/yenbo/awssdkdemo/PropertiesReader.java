package org.yenbo.awssdkdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {

	public enum FileType {
		JAR,
		FILE
	}
	
	private static final Logger log = LoggerFactory.getLogger(PropertiesReader.class);
	
	private String filename;
	private FileType fileType;
	private HashMap<String, String> paramMap = new HashMap<>();
	
	public PropertiesReader(String filename, FileType fileType) {
		
		if (StringUtils.isBlank(filename)) {
			throw new IllegalArgumentException("filename is blank");
		}
		
		if (fileType == null) {
			throw new IllegalArgumentException("fileType is null");
		}
		
		this.filename = filename;
		this.fileType = fileType;
	}

	public String getFilename() {
		return filename;
	}
	
	public FileType getFileType() {
		return fileType;
	}
	
	private String readKey(String key, InputStream inputStream) throws IOException  {
		
		String value = null;
		Properties prop = new Properties();
		prop.load(inputStream);
		value = prop.getProperty(key);
		paramMap.put(key, value);
		
		if (log.isDebugEnabled()) {
			log.debug("Read from {}: {}={}", filename, key, value);
		}
		
		return value;
	}
	
	public String getParam(String key) {
		
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("key is blank");
		}
		
		String value = null;
		
		if (paramMap.containsKey(key)) {
			
			value = paramMap.get(key);
			
		} else {
			
			switch(fileType) {
			case JAR:
				try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
						filename)) {
					value = readKey(key, inputStream);
				} catch (IOException e) {
					throw new ContextedRuntimeException(e);
				}
				
				break;
				
			case FILE:
				
				try (FileInputStream inputStream = new FileInputStream(filename)) {
					value = readKey(key, inputStream);
				} catch (IOException e) {
					throw new ContextedRuntimeException(e);
				}
				
				break;
				
			default:
				throw new ContextedRuntimeException("unknown FileType");
			}
		}
		
		return value;
	}
}
