package com.app.atividaderecyclerview.presenters;

import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.app.atividaderecyclerview.adapters.PhotoAdapter;
import com.app.atividaderecyclerview.models.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PhotoPresenter implements PhotoPresenterContract.presenter, Response.ErrorListener{

    private List<Photo> photos = new ArrayList<>();
    private PhotoPresenterContract.view activity;
    private String urlBase;

    public PhotoPresenter(PhotoPresenterContract.view activity, String urlBase){
        this.activity = activity;
        this.urlBase = urlBase;
    }

    @Override
    public void getPhotos() {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET,
                urlBase, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponsePhotos(response);
                    }
                }, this);

        queue.add(req);
    }

    public void onResponsePhotos(JSONArray response) {
        photos.clear();

        try {
            for (int i = 0; i < 40; i++){
                photos.add(new Photo(response.getJSONObject(i)));
            }
            RecyclerView.Adapter adapter;
            adapter = new PhotoAdapter(photos);

            activity.buildRecyclerView(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
