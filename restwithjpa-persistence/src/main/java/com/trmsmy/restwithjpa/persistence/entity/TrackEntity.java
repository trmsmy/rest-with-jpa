package com.trmsmy.restwithjpa.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class TrackEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="album_id")
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
}