package com.musicWorld.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicWorld.project.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
