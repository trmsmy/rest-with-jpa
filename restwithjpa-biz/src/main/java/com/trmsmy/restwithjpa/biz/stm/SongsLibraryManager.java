package com.trmsmy.restwithjpa.biz.stm;

import com.trmsmy.restwithjpa.model.Album;
import com.trmsmy.restwithjpa.model.Artist;
import com.trmsmy.restwithjpa.model.Playlist;
import com.trmsmy.restwithjpa.model.Track;

public interface SongsLibraryManager {

	Track getTrack(int id);
	Track addTrack(Track t);
	Track updateTrack(Track t);
	void deleteTrack(Track t);
	
	Album addAlbum(Album a);
	Album updateAlbum(Album a);
	void  deleteAlbum(Album a);
	
	Artist addArtist(Artist a);
	Artist updateArtist(Artist a);
	void deleteArtist(Artist a);
	
	Playlist getPlaylist(int id);
	Playlist addPlaylist(Playlist p);
	void updatePlaylist(int playlistId, Track t, int pos);
	void deletePlaylist(Playlist p);
	
}
