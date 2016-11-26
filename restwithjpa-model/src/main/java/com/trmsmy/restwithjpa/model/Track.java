package com.trmsmy.restwithjpa.model;

/**
 * @author trmsmy
 *
 */
public class Track {

	private int id;
	private String name;
	private String description;
	private int albumId;

	public int getId() {
		return id;
	}

	public void setId(int trackId) {
		this.id = trackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String trackName) {
		this.name = trackName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String trackDescription) {
		this.description = trackDescription;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", name=" + name + ", description=" + description + ", albumId=" + albumId + "]";
	}
	
}