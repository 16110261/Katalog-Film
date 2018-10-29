package com.example.msi.katalogfilm0261;

        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder{

    ImageView img_poster;
    TextView tv_title;
    TextView tv_tgl_release;
    TextView tv_vote_count;
    TextView tv_popularity;
    Button btn_detail;


    public ViewHolder(View itemView) {
        super(itemView);

        img_poster = itemView.findViewById(R.id.img_poster);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_tgl_release = itemView.findViewById(R.id.tv_tgl_release);
        tv_vote_count = itemView.findViewById(R.id.tv_vote_count);
        tv_popularity = itemView.findViewById(R.id.tv_popularity);
        btn_detail = itemView.findViewById(R.id.btn_detail);
    }
}
