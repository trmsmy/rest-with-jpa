package com.trmsmy.restwithjpa.web.config;

import com.trmsmy.restwithjpa.rest.config.RestConfig;

public class ServletInitializer extends  AbstractServletInitializer {
	
	@Override
	public String getRestAppConfig() {
		return Application.class.getName();
	}

	@Override
	public Class<?>[] getSpringConfigs() {
		return new Class<?>[] { RestConfig.class };
	}

}
