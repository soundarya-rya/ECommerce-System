package com.hexaware.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	public static String getConnectionString() {
		String fileName="DB.Properties";
		Properties properties = new Properties();
		FileInputStream fileInputStream =null;
		try {
			fileInputStream= new FileInputStream(fileName);
			properties.load(fileInputStream);
			
			String url = properties.getProperty("db.url");
			String username =properties.getProperty("db.username");
			String password =properties.getProperty("db.password");
			// String connectionString = ('"'+url+'"'+','+'"'+un+'"'+','+'"'+pwd+'"');
			//return connectionString;
			return url + "?" + "user=" + username + "&password=" + password;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            if (fileInputStream != null) {
                try {
                	fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null; 
		}
	}
