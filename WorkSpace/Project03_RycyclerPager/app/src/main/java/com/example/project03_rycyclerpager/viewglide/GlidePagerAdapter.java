package com.example.project03_rycyclerpager.viewglide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project03_rycyclerpager.R;

import java.util.ArrayList;

public class GlidePagerAdapter extends RecyclerView.Adapter<GlidePagerAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<AndImgDTO> imgs;
    Context context ;
    public GlidePagerAdapter(LayoutInflater inflater, ArrayList<AndImgDTO> imgs , Context context) {
        this.inflater = inflater;
        this.imgs = imgs;
        this.context = context;
    }

    public GlidePagerAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.pager_item,parent , false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(context)
//                .load(imgs.get(position).getImg_url())
//                .into(holder.pagerImgv);
    }
    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pagerImgv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pagerImgv = itemView.findViewById(R.id.pager_imgv);
        }
    }
}
