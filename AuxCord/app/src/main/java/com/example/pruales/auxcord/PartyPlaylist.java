package com.example.pruales.auxcord;

import java.util.ArrayList;

/**
 * Created by pruales on 11/29/17.
 */

public class PartyPlaylist {
    public static ArrayList<String> songs = new ArrayList<>();

    public PartyPlaylist(ArrayList<String> songs) {
        this.songs = songs;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    public void addSong(String song) {
        this.songs.add(song);
    }
}
