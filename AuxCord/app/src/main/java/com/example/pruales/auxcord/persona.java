package com.example.pruales.auxcord;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class persona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_persona:
                                Intent personaIntent = new Intent(persona.this, persona.class);
                                startActivity(personaIntent);
                                Log.d("STATE", "go to persona");
                                break;
                            case R.id.action_party_playlist:
                                Log.d("STATE", "go to party playlist");
                                Intent partyPlaylistIntent = new Intent(persona.this, party_playlist.class);
                                startActivity(partyPlaylistIntent);
                                break;
                            case R.id.action_my_picks:
                                Log.d("STATE", "go to my picks");
                                Intent intent = new Intent(persona.this, my_picks.class);
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
}
