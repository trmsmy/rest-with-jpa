package com.trmsmy.restwithjpa.web.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public abstract class AbstractRestApplication extends ResourceConfig {

	static final java.util.logging.Logger jerseyLogger = java.util.logging.Logger
			.getLogger("com.trmsmy.restwithjpa.jersey.large");

	public AbstractRestApplication() {

		// Use X-Jersey-Tracing-Accept http header to enable trace logging
		// Use X-Jersey-Tracing-Threshold http header to set log level for trace
		property(ServerProperties.TRACING, "ON_DEMAND");

		packages(getRestPackages());

		if (getRestClasses() != null) {
			registerClasses(getRestClasses());
		}

		// register(new RestExceptionListener());
		register(new LoggingFilter(jerseyLogger, 200));

		// Comment this out trying to get the app to install correctly
		// register(new LoggingFilter(jerseyLargeLogger, true));

		// file upload
		// register(MultiPartFeature.class);


	}

	/**
	 * Return a list of java packages to scan for REST resources. This is now
	 * done using a Spring-based scan, so the package names can contain
	 * wildcards such as "com.trmsmy.*.rest" or even
	 * 
	 * @return
	 */
	public String[] getRestPackages() {
		return null;
	}

	/**
	 * Returns an explicit list of REST resource classes to register without
	 * scanning
	 * 
	 * @return
	 */
	public Class<?>[] getRestClasses() {
		return null;
	}

}
