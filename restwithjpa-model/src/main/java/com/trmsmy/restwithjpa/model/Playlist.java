package com.trmsmy.restwithjpa.model;

import java.util.List;

public class Playlist {

	private int id;
	private String name;
	private List<Track> tracks;

	public int getId() {
		return id;
	}

	public void setId(int playlistId) {
		this.id = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
