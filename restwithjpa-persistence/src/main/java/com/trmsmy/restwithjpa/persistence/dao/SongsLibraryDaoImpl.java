package com.trmsmy.restwithjpa.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.trmsmy.restwithjpa.model.Album;
import com.trmsmy.restwithjpa.model.Artist;
import com.trmsmy.restwithjpa.model.Playlist;
import com.trmsmy.restwithjpa.model.Track;
import com.trmsmy.restwithjpa.persistence.config.PersistenceConfig;
import com.trmsmy.restwithjpa.persistence.entity.PlaylistEntity;
import com.trmsmy.restwithjpa.persistence.entity.TrackEntity;

@Component
public class SongsLibraryDaoImpl implements SongsLibraryDao {

    @PersistenceContext(unitName = PersistenceConfig.PU_JPA)
	EntityManager em;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Track getTrack(int id) {
		System.out.println("in DAO : Track ID request: " + id );
		TrackEntity entity = em.find(TrackEntity.class, id);
		System.out.println("found the entity " + entity);
		Track t = null;
		
		if (entity != null) {
			t = new Track();
			t.setId(id);
			t.setName(entity.getName());
			t.setDescription(entity.getDescription());
		}

		return t;

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
	public Album getAlbum(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public Artist getArtist(int id) {
		// TODO Auto-generated method stub
		return null;
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

		PlaylistEntity pe = em.find(PlaylistEntity.class, id);
		
		if(pe != null) {
			Playlist p = new Playlist();
			p.setId(pe.getId());
			p.setName(pe.getName());
			
			List<Track> tracks = mapTracks(pe.getTracks());
			
			p.setTracks(tracks);
			return p;
		}
		
		return null;
	}

	private List<Track> mapTracks(List<TrackEntity> tracks) {

		List<Track> list = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(tracks))  {
			for (TrackEntity te : tracks) {
				list.add(mapTrack(te));
			}
		}
		
		return list;
	}

	private Track mapTrack(TrackEntity te) {

		if(te != null) {
			Track t = new Track();
			t.setId(te.getId());
			t.setName(te.getName());
			t.setAlbumId(te.getAlbumId());
			t.setDescription(te.getDescription());
			
			return t;
		}
		
		return null;
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
