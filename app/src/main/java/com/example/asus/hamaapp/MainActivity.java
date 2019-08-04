package com.example.asus.hamaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 //   private List<hama> hamas;

    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisiasi ID dan pemanggilan dari layout
        list = (RecyclerView) findViewById(R.id.list_item_hama);

        // mengatur jenis layoutnya, bisa vertical kebawah atau horizontal kesamping
        list.setLayoutManager(new LinearLayoutManager(this));

        // kita membuat variabel baru untuk memanggil dari file RecyclerViewAdapter agar bisa mengambil konten darinya
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this);
        list.setAdapter(adapter);


    }
}

