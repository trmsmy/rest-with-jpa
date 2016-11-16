package com.trmsmy.restwithjpa.web.config;

public class Application extends AbstractRestApplication {
	public Application() {
		super();
	}

	@Override
	public String[] getRestPackages() {
		return new String[] { "com.trmsmy.restwithjpa.rest" };
	}
}