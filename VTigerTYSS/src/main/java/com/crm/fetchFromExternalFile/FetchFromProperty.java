package com.crm.fetchFromExternalFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchFromProperty {
	
	public String fetchFromProperty(String key) {
		FileInputStream inputFile = null;
		String value = null;
		try {
			inputFile = new FileInputStream(IPathConstants.loginFilePathProperty);
			Properties pfile = new Properties();
			pfile.load(inputFile);
			value = pfile.getProperty(key);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				inputFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
}
