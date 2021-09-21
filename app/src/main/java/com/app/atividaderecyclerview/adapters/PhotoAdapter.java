package com.app.atividaderecyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atividaderecyclerview.R;
import com.app.atividaderecyclerview.models.Photo;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>{

    private List<Photo> data;

    public PhotoAdapter(List<Photo> data){
        this.data = data;
    }

    // Cria efetivamente a view do Recycler
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            this.view = itemView;
        }
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
        Photo photoItem = data.get(position);

        TextView tv = holder.view.findViewById(R.id.tvItemTitle);
        tv.setText(photoItem.getTitle());
        tv = holder.view.findViewById(R.id.tvPhotoId);
        tv.setText(Integer.toString(photoItem.getId()));
        tv = holder.view.findViewById(R.id.tvAlbumId);
        tv.setText(Integer.toString(photoItem.getAlbumId()));
        tv = holder.view.findViewById(R.id.tvURL);
        tv.setText(photoItem.getUrl());
        ImageView ivPhoto = holder.view.findViewById(R.id.ivPhoto);

        Picasso.get().load(photoItem.getUrl()).into(ivPhoto);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
