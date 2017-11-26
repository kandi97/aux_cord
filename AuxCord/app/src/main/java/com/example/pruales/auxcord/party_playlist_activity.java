package com.example.pruales.auxcord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by xanth on 11/20/2017.
 */

public class party_playlist_activity extends AppCompatActivity {
    protected void onCreated(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        Intent intent = new Intent();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search1, menu);
        MenuItem searchItem =menu.findItem(R.id.action_search);

        return true;
    }
}
