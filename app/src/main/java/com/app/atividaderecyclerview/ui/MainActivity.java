package com.app.atividaderecyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.atividaderecyclerview.R;
import com.app.atividaderecyclerview.presenters.PhotoPresenter;
import com.app.atividaderecyclerview.presenters.PhotoPresenterContract;

public class MainActivity extends AppCompatActivity implements PhotoPresenterContract.view{

    PhotoPresenterContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PhotoPresenter(this, "https://jsonplaceholder.typicode.com/photos");
        Button btnGetData = findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getPhotos();
            }
        });
        Button btnCleanList = findViewById(R.id.btnCleanList);
        btnCleanList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanRecyclerView();
            }
        });
    }

    @Override
    public void buildRecyclerView(RecyclerView.Adapter adapter) {
        RecyclerView rv = findViewById(R.id.recyclerViewPhotos);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public void cleanRecyclerView() {
        RecyclerView rv = findViewById(R.id.recyclerViewPhotos);
        rv.setAdapter(null);
    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }
}