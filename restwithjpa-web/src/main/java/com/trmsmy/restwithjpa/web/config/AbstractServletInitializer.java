package com.trmsmy.restwithjpa.web.config;

import java.text.MessageFormat;

import javax.annotation.Priority;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


@Priority(value = 1)
public abstract class AbstractServletInitializer implements WebApplicationInitializer {

	protected static final String ENV_KEY = "env";
	protected static final String LOG4J_CONFIG_PROP_KEY = "log4j.configurationFile";
	protected static final String DEFAULT_LOG4J_XML_LOCATION = "log4j/{0}.log4j2.xml";
	Logger log;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Configure Log4j Location based on 'env' System property' 
		String log4jConfigLocation = getLog4jConfigLocation();
		if(StringUtils.isNoneBlank(log4jConfigLocation)) {
			System.out.println("Resolved Log4j Config classpath location ===> " + log4jConfigLocation);
			System.setProperty(LOG4J_CONFIG_PROP_KEY, log4jConfigLocation);
		} else {
			System.out.println("Log4j Config location is empty !! ===> " + log4jConfigLocation);
		}

		this.log = LogManager.getLogger();

		// End of Log4j config
		
		initializeContext(servletContext);

		//Lets load REST only when the package names are provided.
		String restAppConfig = getRestAppConfig();
		if(StringUtils.isNotBlank(restAppConfig)) {
			ServletRegistration.Dynamic jerseyServlet = servletContext.addServlet("JerseyServlet", new ServletContainer());
			jerseyServlet.setInitParameter("javax.ws.rs.Application", restAppConfig);
			jerseyServlet.setLoadOnStartup(1);
			jerseyServlet.addMapping("/*");
		}


	}

	protected String getLog4jConfigLocation() {

		String envName = System.getProperty(ENV_KEY);
		String resolvedLog4jXmlLocation = MessageFormat.format(DEFAULT_LOG4J_XML_LOCATION, StringUtils.trim(envName));
		return resolvedLog4jXmlLocation;
	}

    private AnnotationConfigWebApplicationContext initializeContext(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(getSpringConfigs());
		servletContext.addListener(new ContextLoaderListener(context));
		servletContext.setInitParameter("contextConfigLocation", "");

		return context;

    }
    
    public abstract String getRestAppConfig();
    public abstract Class<?>[] getSpringConfigs();

}
