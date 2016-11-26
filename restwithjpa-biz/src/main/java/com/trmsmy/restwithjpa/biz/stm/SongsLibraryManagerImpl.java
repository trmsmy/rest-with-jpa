package com.trmsmy.restwithjpa.biz.stm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trmsmy.restwithjpa.model.Album;
import com.trmsmy.restwithjpa.model.Artist;
import com.trmsmy.restwithjpa.model.Playlist;
import com.trmsmy.restwithjpa.model.Track;
import com.trmsmy.restwithjpa.persistence.dao.SongsLibraryDaoImpl;

@Component
public class SongsLibraryManagerImpl implements SongsLibraryManager {

	@Autowired
	private SongsLibraryDaoImpl dao;
	
	@Override
	public Track getTrack(int id) {
		System.out.println("in BIZ : Track ID request: " + id );
		return dao.getTrack(id);
	}
	
	@Override
	public Track addTrack(Track t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Track updateTrack(Track t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTrack(Track t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Album addAlbum(Album a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album updateAlbum(Album a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAlbum(Album a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Artist addArtist(Artist a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist updateArtist(Artist a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArtist(Artist a) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public Playlist getPlaylist(int id) {
		return dao.getPlaylist(id);
	}
	
	@Override
	public Playlist addPlaylist(Playlist p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePlaylist(int playlistId, Track t, int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePlaylist(Playlist p) {
		// TODO Auto-generated method stub

	}

}
