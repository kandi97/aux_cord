package com.example.pruales.auxcord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.support.design.widget.BottomNavigationView;
import android.support.annotation.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class party_playlist extends AppCompatActivity {

    private ArrayAdapter<String> songsAdapter;
    private ListView mSongListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_playlist);
        mSongListView = (ListView) findViewById(R.id.party_playlist);


        songsAdapter = new ArrayAdapter<>(this,
                R.layout.party_playlist_songs,
                R.id.song_title,
                PartyPlaylist.songs);

        mSongListView.setAdapter(songsAdapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_persona:
                                Log.d("STATE", "go to persona");
                                break;
                            case R.id.action_party_playlist:
                                Log.d("STATE", "go to party playlist");
                                Intent partyPlaylistIntent = new Intent(party_playlist.this, party_playlist.class);
                                startActivity(partyPlaylistIntent);
                                break;
                            case R.id.action_my_picks:
                                Log.d("STATE", "go to my picks");
                                Intent intent = new Intent(party_playlist.this, my_picks.class);
                                startActivity(intent);
                                break;
                        }
                        return false;
                    }
                });

    }


    public void buttonPressed(View view) {
        Log.d("STATE", view.toString());
    }
}
