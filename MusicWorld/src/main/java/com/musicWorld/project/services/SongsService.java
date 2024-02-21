package com.musicWorld.project.services;

import java.util.List;

import com.musicWorld.project.entities.Song;

public interface SongsService {
	public String addSong(Song song);
	public boolean isSongExists(String name);
	public List<Song> fetchAllSongs();
	public void updateSong(Song song);
}
