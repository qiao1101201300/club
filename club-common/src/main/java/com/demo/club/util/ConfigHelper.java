package com.demo.club.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper {
	private static final Logger log= LoggerFactory.getLogger(ConfigHelper.class);
	private static Properties properties=new Properties();
	
	static{
		log.debug("Loading application.properties");
		
		try {
			InputStream input =new FileInputStream(FileUtils.getFile("application.properties", ""));
//            InputStream input = new FileInputStream("../resources/config.properties");

            properties.load(input);
        } catch (IOException e) {
			log.error("Loading application.properties fails");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		return properties.getProperty(key);
	}

    public static boolean getBoolean( String key ){
		if(properties.getProperty( key ) == null){
			return false;
		}
        return Boolean.valueOf( properties.getProperty( key ) );
    }

    public static String getString(String key ){
        return properties.getProperty(key);
    }

    public static int getInteger( String key ){
		if(properties.getProperty( key ) == null){
			return -19999;
		}
        return Integer.parseInt( properties.getProperty( key ) );
    }
}
