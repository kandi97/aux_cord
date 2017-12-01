package com.example.pruales.auxcord;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_persona:
                                Intent personaIntent = new Intent(my_picks.this, persona.class);
                                startActivity(personaIntent);
                                Log.d("STATE", "go to persona");
                                break;
                            case R.id.action_party_playlist:
                                Log.d("STATE", "go to party playlist");
                                Intent partyPlaylistIntent = new Intent(my_picks.this, party_playlist.class);
                                startActivity(partyPlaylistIntent);
                                break;
                            case R.id.action_my_picks:
                                Log.d("STATE", "go to my picks");
                                Intent intent = new Intent(my_picks.this, my_picks.class);
                                startActivity(intent);
                                break;
                        }
                        return false;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int res_id= item.getItemId();
        if (res_id==R.id.toolbar_item2){
            Log.d("STATE", "settings");
        }
        return true;

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
