package com.trmsmy.restwithjpa.persistence.dao;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SongsLibraryDaoIntegTest extends BaseDaoIntegTest {
	
	@Autowired
	SongsLibraryDao dao;
	
	@Test
	public void testFetchTrack() throws Exception {
		System.out.println("track test ");
		
		Assert.assertTrue(dao.getTrack(1).getName().equals("name 1"));
	}

	@Test
	public void testFetchPlaylist() throws Exception {
		System.out.println("playlist test ");
		
		Assert.assertTrue(dao.getPlaylist(1).getName().equals("playlist name"));
		Assert.assertTrue(CollectionUtils.size(dao.getPlaylist(1).getTracks()) > 0);
	}
}
