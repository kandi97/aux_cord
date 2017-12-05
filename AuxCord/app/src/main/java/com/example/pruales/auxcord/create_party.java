package com.example.pruales.auxcord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class create_party extends android.support.v7.app.AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createparty);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("create party");
//        ab.setSubtitle("Home");

        // Spinner element
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        // Spinner click listener
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories1 = new ArrayList<String>();
        categories1.add("Persona");
        categories1.add("Party");
        categories1.add("Rap");
        categories1.add("Classic");
        categories1.add("Trap");
        categories1.add("Country");

        List<String> categories2 = new ArrayList<String>();
        categories2.add("Initial Playlist");
        categories2.add("Party");
        categories2.add("Rap");
        categories2.add("Classic");
        categories2.add("Trap");
        categories2.add("Country");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_persona:
                                Intent personaIntent = new Intent(create_party.this, persona.class);
                                startActivity(personaIntent);
                                Log.d("STATE", "go to persona");
                                break;
                            case R.id.action_party_playlist:
                                Log.d("STATE", "go to party playlist");
                                Intent partyPlaylistIntent = new Intent(create_party.this, party_playlist.class);
                                startActivity(partyPlaylistIntent);
                                break;
                            case R.id.action_my_picks:
                                Log.d("STATE", "go to my picks");
                                Intent intent = new Intent(create_party.this, my_picks.class);
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void startParty(View view) {
        PartyPlaylist.songs.clear();
        Intent intent = new Intent(this, party_playlist.class);
        startActivity(intent);
    }


}
