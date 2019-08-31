package config;

import browserType.browserType;

public interface propertyReader {

	public String getUrl();
	public String getChromePath();
	public String getUsername();
	public String getPassword();
	public String getHomePageTitle();
	public browserType getBrowser();
	public int getImplicitWait();
	
}
