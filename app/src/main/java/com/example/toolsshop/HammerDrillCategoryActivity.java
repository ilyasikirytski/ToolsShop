package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HammerDrillCategoryActivity extends AppCompatActivity {

    private ListView listViewHammerDrill;

    private ArrayList<HammerDrill> hammerDrills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hammer_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        hammerDrills = new ArrayList<>();
        hammerDrills.add(new HammerDrill(getString(R.string.hammerDrill_bosch_title), getString(R.string.hammerDrill_bosch_info), R.drawable.bosch));
        hammerDrills.add(new HammerDrill(getString(R.string.hammerDrill_makita_title), getString(R.string.hammerDrill_makita_info), R.drawable.makitaperf));
        hammerDrills.add(new HammerDrill(getString(R.string.hammerDrill_dewalt_title), getString(R.string.hammerDrill_dewalt_info), R.drawable.dewaltperf));
        listViewHammerDrill = findViewById(R.id.listViewHammerDrill);
        ArrayAdapter<HammerDrill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, hammerDrills);
        listViewHammerDrill.setAdapter(adapter);
        listViewHammerDrill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
                HammerDrill hammerDrill = hammerDrills.get(position);
                Intent intent = new Intent(getApplicationContext(), HammerDrillDetailActivity.class);
                intent.putExtra("title", hammerDrill.getTitle());
                intent.putExtra("info", hammerDrill.getInfo());
                intent.putExtra("resId", hammerDrill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}