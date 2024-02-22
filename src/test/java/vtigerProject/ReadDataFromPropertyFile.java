package vtigerProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		
		//step1:open The Document in Java readable Format
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		                                         // dot(.) Specified Current Project
		//step2:Create object Of Properties Class- java.util
		Properties prop=new Properties();
		
		//step3:Load The Document Into Properties Class
		prop.load(fis);
		
		//step4:Provide The Key And Read The Value
		String Browser=prop.getProperty("browser");
		System.out.println(Browser);
		
		String Username=prop.getProperty("username");
		System.out.println(Username);
		
		String Name=prop.getProperty("name");
		System.out.println(Name); //It Will print Null Because There is No data Into The Property File
	}

}
