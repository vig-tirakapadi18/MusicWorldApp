package com.musicWorld.project.controllers;

import org.springframework.ui.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.musicWorld.project.entities.Playlist;
import com.musicWorld.project.entities.Song;
import com.musicWorld.project.services.*;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pService;
	
	@Autowired
	SongsService sService;
	
	@GetMapping("/create-playlist")
	public String createNewPlaylist(Model model) {
		List<Song> songsList = sService.fetchAllSongs();
		model.addAttribute("songsList", songsList);
		return "createPlaylist";
	}
	
	@PostMapping("/add-playlist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
//		System.out.println(playlist);
		pService.addPlaylist(playlist);
		List<Song>  sList = playlist.getsList();
		
		for(Song song: sList) {
			song.getpList().add(playlist);
			sService.updateSong(song);
		}
		
		return "playlistSuccess";
	}
	
	@GetMapping("/view-playlists")
	public String viewPlaylists(Model model) {
		List<Playlist> playlistsList = pService.fetchPlaylists();
//		System.out.println(playlistsList);
		model.addAttribute("playlistsList", playlistsList);
		return "viewPlaylists";
	}
}





