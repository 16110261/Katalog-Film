package com.example.msi.katalogfilm0261;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("Detail Movie");

        ImageView ivGambar = findViewById(R.id.img_poster);
        TextView tvTittle = findViewById(R.id.tv_title);
        TextView tvReleae = findViewById(R.id.tv_tgl_release);
        TextView tvDetail = findViewById(R.id.tv_detail);

        String strTvDetail = getIntent().getStringExtra("DESKRIPSI");
        String urlGambar = getIntent().getStringExtra("GAMBAR");
        String judul = getIntent().getStringExtra("JUDUL");
        String tanggal = getIntent().getStringExtra("RELEASE");

        System.out.println("Overview: "+strTvDetail);

        tvDetail.setText(strTvDetail);
        tvTittle.setText(judul);
        tvReleae.setText(tanggal);
        Glide.with(this)
                .load(urlGambar)
                .override(350,550)
                .into(ivGambar);
    }
}
