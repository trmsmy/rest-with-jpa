package com.trmsmy.restwithjpa.model.stm;

import java.util.List;

public class Playlist {

	private int id;
	private List<Track> tracks;

	public int getId() {
		return id;
	}

	public void setId(int playlistId) {
		this.id = playlistId;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
