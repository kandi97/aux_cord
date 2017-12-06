package com.example.pruales.auxcord;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class persona extends AppCompatActivity {


    private RelativeLayout persona;
    private PieChart mChart;

    private float[] yData= {15, 25, 10, 35, 15};//
    private String[] xData= {"Rap", "Country", "Pop", "EDM", "Jazz"};//

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
        persona= (RelativeLayout) findViewById(R.id.persona);//
        mChart= new PieChart(this);//
        persona.addView(mChart, 1000, 1000);


        mChart.setUsePercentValues(true);
//        mChart.setDescription();

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.TRANSPARENT);
        mChart.setHoleRadius(8); //7
        mChart.setTransparentCircleRadius(10); //10

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setY(600);
        mChart.setX(200);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if(e== null)
                    return;

                Toast.makeText(persona.this, xData[(int) e.getX()]+ " = "+ e.getY()+ "%", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });


        addData();

    }

    private void addData(){
        List<PieEntry> yVals1= new ArrayList<PieEntry>();


        for(int i=0; i<yData.length; i++)
            yVals1.add(new PieEntry(yData[i], i));

        List<String> xVals= new ArrayList<String>();

        for (int i=0; i<xData.length; i++)
            xVals.add(xData[i]);


        PieDataSet dataSet= new PieDataSet(yVals1, "Music stats at the party");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        ArrayList<Integer> colors= new ArrayList<Integer>();

        for(int c: ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for(int c: ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for(int c: ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for(int c: ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for(int c: ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);

        mChart.highlightValues(null);



        mChart.invalidate();
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
}