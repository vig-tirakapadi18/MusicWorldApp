package com.musicWorld.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicWorld.project.entities.Playlist;
import com.musicWorld.project.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
	@Autowired
	PlaylistRepository pRepo;
	
	public void addPlaylist(Playlist playlist) {
		 pRepo.save(playlist);
	}
	
	public List<Playlist> fetchPlaylists() {
		return pRepo.findAll();
	}
}
