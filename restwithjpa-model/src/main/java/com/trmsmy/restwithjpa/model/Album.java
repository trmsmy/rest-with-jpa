package com.trmsmy.restwithjpa.model;

public class Album {

	private int id;
	private String name;
	private int artistId;

	public int getId() {
		return id;
	}

	public void setId(int albumId) {
		this.id = albumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
}
