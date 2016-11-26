package com.trmsmy.restwithjpa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.trmsmy.restwithjpa.biz.stm.SongsLibraryManager;
import com.trmsmy.restwithjpa.model.Playlist;
import com.trmsmy.restwithjpa.model.Track;

@Path("/rest")
public class SongsLibraryRestService {

	@Autowired
	private SongsLibraryManager slm;
	
	
	@GET
	@Path("track")
	public Response ping(@QueryParam(value  = "id")int id) {
		System.out.println("Track ID request: " + id );
		Track track = slm.getTrack(id);
		return Response.ok(track).build();
	}

	@GET
	@Path("playlist")
	public Playlist getPlaylist(@QueryParam(value  = "id")int id) {
		System.out.println("Playlist ID request: " + id );
		Playlist p = slm.getPlaylist(id);
		return p;
	}
	
}
