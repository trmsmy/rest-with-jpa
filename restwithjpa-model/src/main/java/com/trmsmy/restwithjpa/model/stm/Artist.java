package com.trmsmy.restwithjpa.model.stm;

public class Artist {

	private int id;
	private String name;
	private ArtistType type;

	public int getId() {
		return id;
	}

	public void setId(int artistId) {
		this.id = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArtistType getType() {
		return type;
	}

	public void setType(ArtistType type) {
		this.type = type;
	}
}
