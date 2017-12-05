package com.example.pruales.auxcord;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by pruales on 11/29/17.
 */

public class PartyPlaylist {
    public static ArrayList<String> songs = new ArrayList<>();
    public static ArrayList<String> my_picks = new ArrayList<>();

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
