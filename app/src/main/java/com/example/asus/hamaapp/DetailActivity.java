package com.example.asus.hamaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    // deklarasi dan inisiasi variabel umum/global
    ImageView imggambar;
    TextView txtdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // pemanggilan ID dari layout activity_detail.xml
        imggambar = (ImageView) findViewById(R.id.imgdetail);
        txtdetail = (TextView) findViewById(R.id.txtdetail);

        // intent ini fungsinya adalah untuk menerima data dari RecyclerViewAdapter
        Intent terimadata = getIntent();
        String nm = terimadata.getStringExtra("Nama");
        getSupportActionBar().setTitle(nm);
        imggambar.setImageResource(terimadata.getIntExtra("IMG", 1)); //angka satu itu menandakan bahwasannya nilai dari si integer (gak harus angka 1)
        txtdetail.setText(terimadata.getStringExtra("DET"));

        // berfungsi untuk menampilkan icon back (kembali) di pojok kiri atas
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
