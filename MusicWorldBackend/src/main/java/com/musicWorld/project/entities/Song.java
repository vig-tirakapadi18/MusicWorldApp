package com.musicWorld.project.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String link;
	
	@ManyToMany
	List<Playlist> pList;

	public Song() {
		super();
	}

	public Song(int id, String name, String artist, String genre, String link, List<Playlist> pList) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.pList = pList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Playlist> getpList() {
		return pList;
	}

	public void setpList(List<Playlist> pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link + "]";
		
//		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
//				+ ", pList=" + pList + "]";
		
	}
}
