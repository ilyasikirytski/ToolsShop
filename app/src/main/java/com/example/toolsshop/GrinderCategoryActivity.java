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

public class GrinderCategoryActivity extends AppCompatActivity {

    private ListView listViewGrinder;

    private ArrayList<Drill> grinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grinder_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        grinder = new ArrayList<>();
        grinder.add(new Drill(getString(R.string.grinder_interskool_title), getString(R.string.grinder_interskool_info), R.drawable.interskolgrind));
        grinder.add(new Drill(getString(R.string.grinder_makita_title), getString(R.string.grinder_makita_info), R.drawable.makitagrinder));
        grinder.add(new Drill(getString(R.string.grinder_dewalt_title), getString(R.string.grinder_dewalt_info), R.drawable.dewaltgrinder));
        listViewGrinder = findViewById(R.id.listViewGrinder);
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, grinder);
        listViewGrinder.setAdapter(adapter);
        listViewGrinder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
                Drill drill = grinder.get(position);
                Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}