package com.trmsmy.restwithjpa.persistence.dao;

import com.trmsmy.restwithjpa.model.Album;
import com.trmsmy.restwithjpa.model.Artist;
import com.trmsmy.restwithjpa.model.Playlist;
import com.trmsmy.restwithjpa.model.Track;

public interface SongsLibraryDao {
	
	Track getTrack(int id);
	Track addTrack(Track t);
	Track updateTrack(Track t);
	void deleteTrack(Track t);
	
	Album getAlbum(int id);
	Album addAlbum(Album a);
	Album updateAlbum(Album a);
	void  deleteAlbum(Album a);
	
	Artist getArtist(int id);
	Artist addArtist(Artist a);
	Artist updateArtist(Artist a);
	void deleteArtist(Artist a);
	
	Playlist getPlaylist(int id);
	Playlist addPlaylist(Playlist p);
	void updatePlaylist(int playlistId, Track t, int pos);
	void deletePlaylist(Playlist p);
}
