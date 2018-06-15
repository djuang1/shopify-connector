package org.mule.modules.shopify.config;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.HttpBasicAuth;
import org.mule.api.annotations.rest.BasicAuthPassword;
import org.mule.api.annotations.rest.BasicAuthUsername;

@HttpBasicAuth( headerName="Authorization", friendlyName = "HttpBasicAuth")
public class ConnectorConfig{
	
	@Configurable
	@BasicAuthUsername
	private String username;

	@Configurable
	@BasicAuthPassword
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}