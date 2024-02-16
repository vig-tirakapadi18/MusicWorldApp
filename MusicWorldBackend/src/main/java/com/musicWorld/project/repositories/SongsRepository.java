package com.musicWorld.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicWorld.project.entities.Song;

public interface SongsRepository extends JpaRepository<Song, Integer> {
	public Song findByName(String name);
}
