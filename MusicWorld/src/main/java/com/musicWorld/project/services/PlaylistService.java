package com.musicWorld.project.services;

import java.util.List;

import com.musicWorld.project.entities.Playlist;

public interface PlaylistService {
	public void addPlaylist(Playlist playlist);
	
	public List<Playlist> fetchPlaylists();
}
