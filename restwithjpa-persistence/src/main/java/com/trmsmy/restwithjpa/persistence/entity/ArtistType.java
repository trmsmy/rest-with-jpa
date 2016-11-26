package com.trmsmy.restwithjpa.persistence.entity;

public enum ArtistType {
	MUSIC_DIRECTOR (1),
	SINGER (2),
	LYRICIST (3);
	
	private int code;

	private ArtistType(int id) {
		this.code = id;
	}
	
	public int getCode() {
		return code;
	}
}
