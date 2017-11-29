package com.example.pruales.auxcord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class my_picks extends AppCompatActivity {

    private ArrayList<String> songs;
    private ArrayAdapter<String> songsAdapter;
    private ListView mSongListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_picks);
        mSongListView = (ListView) findViewById(R.id.my_picks_list);
        songs = new ArrayList<>();
        songs.add("Mans Not Hot by Big Shaq");
        songs.add("Gucci Gang by Lil Pump");
        songs.add("Rockstar by Post Malone");

        songsAdapter = new ArrayAdapter<>(this,
                R.layout.my_picks_songs,
                R.id.song_title,
                songs);

        mSongListView.setAdapter(songsAdapter);
    }


    public void addSong(View view) {
        View parent = (View) view.getParent();
        TextView songTextView = (TextView) parent.findViewById(R.id.song_title);
        String song = String.valueOf(songTextView.getText());

        Log.d("Song Picked", song);

        PartyPlaylist.songs.add(song);

        Intent intent = new Intent(this, party_playlist.class);
        startActivity(intent);

    }

}
