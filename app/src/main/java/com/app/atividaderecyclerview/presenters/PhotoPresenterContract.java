package com.app.atividaderecyclerview.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface PhotoPresenterContract {

    interface view {
        public void buildRecyclerView(RecyclerView.Adapter adapter);
        public void cleanRecyclerView();
        public Context getContext();
    }

    interface presenter {
        public void getPhotos();
    }
}
