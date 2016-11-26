package com.trmsmy.restwithjpa.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class AlbumEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
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
