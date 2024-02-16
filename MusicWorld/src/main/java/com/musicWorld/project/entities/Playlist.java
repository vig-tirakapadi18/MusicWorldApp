package com.musicWorld.project.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	
	@ManyToMany
	List<Song> sList;

	public Playlist() {
		super();
	}

	public Playlist(int id, String name, List<Song> sList) {
		super();
		this.id = id;
		this.name = name;
		this.sList = sList;
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

	public List<Song> getsList() {
		return sList;
	}

	public void setsList(List<Song> sList) {
		this.sList = sList;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", sList=" + sList + "]";
	}
}
