package com.example.pruales.auxcord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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
                                Intent personaIntent = new Intent(party_playlist.this, persona.class);
                                startActivity(personaIntent);
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
    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int res_id= item.getItemId();
        if (res_id==R.id.toolbar_item1){
            Intent intent= new Intent(this, home.class);
            startActivity(intent);

        } else if (res_id==R.id.toolbar_item3){
            Intent intent2= new Intent(this,MainActivity.class);
            startActivity(intent2);
        }
        return true;

    }


    public void buttonPressed(View view) {
        Log.d("STATE", view.toString());
    }
}
