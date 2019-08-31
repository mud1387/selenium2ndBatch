package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import browserType.browserType;
public class config implements propertyReader {

	static Properties pro;
	
	public config() {
		
		File file= new File(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
		try {
			FileInputStream fis= new FileInputStream(file);
			pro= new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getUrl() {
		
		return pro.getProperty("url");
	}
	
	public String getChromePath() {
		
		System.out.println(pro.getProperty("chromePath"));
		return pro.getProperty("chromePath");
	}
	
	public String getUsername() {
		
		return pro.getProperty("username");
	}
	
	public String getPassword() {
		
		return pro.getProperty("password");
	}
	
	public String getHomePageTitle() {
		
		return pro.getProperty("homePageTitle");
	}

	public browserType getBrowser() {
		// TODO Auto-generated method stub
		return browserType.valueOf(pro.getProperty("browser"));
	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(pro.getProperty("implicitwait"));
	}

		
	
}
