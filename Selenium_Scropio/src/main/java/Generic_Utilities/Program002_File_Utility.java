package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

//this method i used to read data from properties file

public class Program002_File_Utility {
	public String getKeyAndValuePair(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Documents\\Properties.properties");
		
		Properties pro = new Properties();
		pro.load(fis);
		
		String Value = pro.getProperty(key);
		return Value;
	}	

}
