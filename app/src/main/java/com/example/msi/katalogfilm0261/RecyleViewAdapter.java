package com.example.msi.katalogfilm0261;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ResultsItem> results;
    private Context context;

    public RecyleViewAdapter(List<ResultsItem> results, Context context) {
        this.results = results;
        this.context = context;
    }

    public List<ResultsItem> getResults() {
        return results;
    }

    public void setResults(List<ResultsItem> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_title.setText(getResults().get(position).getTitle());

        System.out.println("tgl release: "+results.get(position).getReleaseDate());

        holder.tv_tgl_release.setText(getResults().get(position).getReleaseDate());
        holder.tv_vote_count.setText(String.valueOf(getResults().get(position).getVoteCount()));
        holder.tv_popularity.setText(String.valueOf(getResults().get(position).getPopularity()));

        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185/"+getResults().get(position).getPosterPath())
                .override(350,550)
                .into(holder.img_poster);

        holder.btn_detail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("JUDUL",getResults().get(position).getTitle());
                intent.putExtra("RELEASE",getResults().get(position).getReleaseDate());
                intent.putExtra("GAMBAR","http://image.tmdb.org/t/p/w185/"+getResults().get(position).getPosterPath());
                intent.putExtra("DESKRIPSI", getResults().get(position).getOverview());
                context.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getResults().size();
    }
}
