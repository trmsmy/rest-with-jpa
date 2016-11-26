package com.trmsmy.restwithjpa.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "playlist")
public class PlaylistEntity {

	@Id
    @GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
      name="playlist_item",
      joinColumns=@JoinColumn(name="playlist_id", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="track_id", referencedColumnName="id"))
	private List<TrackEntity> tracks;
	
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

	public List<TrackEntity> getTracks() {
		return tracks;
	}

	public void setTracks(List<TrackEntity> list) {
		this.tracks = list;
	}

}
