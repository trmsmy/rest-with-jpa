package com.trmsmy.restwithjpa.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class ArtistEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
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
