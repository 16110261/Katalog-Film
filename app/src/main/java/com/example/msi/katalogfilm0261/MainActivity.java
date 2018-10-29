package com.example.msi.katalogfilm0261;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public String API_KEY= "39bf248ec19614946fced34cf7cd4d27";

    private List<ResultsItem> list;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Now Playing");

        list = new ArrayList<>();

        recyclerView = findViewById(R.id.rv_now_playing);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Movie> call = apiService.getMovieNowPlaying(API_KEY);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.body() != null){
                    Log.d("SUKSES","Apakah sukses: "+response.isSuccessful());
                    list = response.body().getResults();
                    Log.d("NOW PLAYING","Berapa banyak data: "+list.size());
                    recyclerView.setAdapter(new RecyleViewAdapter(list, MainActivity.this));
                }else{
                    Log.e("GAGAL","GAGAL mengambil data "+response.isSuccessful());
                }

            }


            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                Log.e("ERRORDATA", t.toString());
            }
        });



    }


}
