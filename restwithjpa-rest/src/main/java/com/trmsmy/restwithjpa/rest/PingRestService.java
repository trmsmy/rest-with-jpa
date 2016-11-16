package com.trmsmy.restwithjpa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
public class PingRestService {

	@GET
	public String ping() {
		return "success";
	}
	
}
