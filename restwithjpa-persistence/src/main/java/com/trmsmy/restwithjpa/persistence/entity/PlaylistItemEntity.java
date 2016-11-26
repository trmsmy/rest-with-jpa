package com.trmsmy.restwithjpa.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

public class PlaylistItemEntity {


	private List<TrackEntity> tracks;

	public List<TrackEntity> getTracks() {
		return this.tracks;
	}

	public void setTracks(List<TrackEntity> tracks) {
		this.tracks = tracks;
	}
	
	
}
