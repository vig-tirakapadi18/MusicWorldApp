package com.musicWorld.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.musicWorld.project.entities.Song;
import com.musicWorld.project.repositories.SongsRepository;

@Service
public class SongsServiceImplementation implements SongsService {
	@Autowired
	SongsRepository sRepo;
	
	public String addSong(Song song) {
		sRepo.save(song);
		return "Song added successfully";
	}
	
	public boolean isSongExists(String name) {
		if(sRepo.findByName(name) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public List<Song> fetchAllSongs() {
		return sRepo.findAll();
	}
	
	public void updateSong(Song song) {
		sRepo.save(song);
	}
}
