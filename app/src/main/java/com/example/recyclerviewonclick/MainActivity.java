package com.example.recyclerviewonclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerViewListener {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringList.add("Farrux");
        stringList.add("Jasur");
        stringList.add("Salom");
        stringList.add("Nima");
        stringList.add("Gaplar");
        stringList.add("Android");
        stringList.add("Kotlin");
        stringList.add("KMM");

        recyclerView = findViewById(R.id.recyclerViewContainer);

        adapter = new RecyclerViewAdapter(stringList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(String text) {
        Toast.makeText(this, text + " bosildi", Toast.LENGTH_SHORT).show();
    }
}