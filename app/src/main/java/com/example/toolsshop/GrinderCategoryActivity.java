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

    private ArrayList<Grinder> grinders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grinder_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        grinders = new ArrayList<>();
        grinders.add(new Grinder(getString(R.string.grinder_interskool_title), getString(R.string.grinder_interskool_info), R.drawable.interskolgrind));
        grinders.add(new Grinder(getString(R.string.grinder_makita_title), getString(R.string.grinder_makita_info), R.drawable.makitagrinder));
        grinders.add(new Grinder(getString(R.string.grinder_dewalt_title), getString(R.string.grinder_dewalt_info), R.drawable.dewaltgrinder));
        listViewGrinder = findViewById(R.id.listViewGrinder);
        ArrayAdapter<Grinder> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, grinders);
        listViewGrinder.setAdapter(adapter);
        listViewGrinder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
                Grinder grinder = grinders.get(position);
                Intent intent = new Intent(getApplicationContext(), GrinderDetailActivity.class);
                intent.putExtra("title", grinder.getTitle());
                intent.putExtra("info", grinder.getInfo());
                intent.putExtra("resId", grinder.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}