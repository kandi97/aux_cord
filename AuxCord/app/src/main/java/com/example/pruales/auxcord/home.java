package com.example.pruales.auxcord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        android.support.v7.app.ActionBar ab = getSupportActionBar();
//        ab.setTitle("Aux cord");
//        ab.setSubtitle("Home");
    }

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

//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.search1, menu);
//        MenuItem searchItem =menu.findItem(R.id.action_search);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(false);
//
//        return true;
//    }

    public void buttonPressed(View view) {
        switch(view.getId()) {
            case R.id.join1:
                Log.d("STATE", "joining party 1");
                Intent intent = new Intent(this, party_playlist.class);
                startActivity(intent);
                break;
            case R.id.join2:
                Log.d("STATE", "joining party 2");
                break;
            case R.id.join3:
                Log.d("STATE", "joining party 3");
                break;
            case R.id.join4:
                Log.d("STATE", "joining party 4");
                break;
            case R.id.join5:
                Log.d("STATE", "joining party 5");
                break;
            case R.id.start_party:
                Intent startPartyIntent = new Intent(this, create_party.class);
                startActivity(startPartyIntent);
                break;
            default:
                Log.d("STATE", "uncaught id");
                break;
        }

    }
}
