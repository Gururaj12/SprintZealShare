package com.sprintzeal.sprint.sprintzeal;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTestForMyList extends AppCompatActivity {
    // Tag used to cancel the request
    String tag_json_obj = "json_obj_req";

    String url = "https://lms.sprintzeal.com/mobile/users/mycourse?email=gururajbijjaragi@gmail.com";
    ProgressDialog pDialog;

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;
    List<ApiModel> GetDataAdapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test_for_my_list);
        recyclerView = findViewById(R.id.recycler_v);

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        GetDataAdapter1 = new ArrayList<>();

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);


    }



    public void fetchStoreItems(){
            JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
SON_PARSE_DATA_AFTER_WEBCALL(response);


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
        }

public void SON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        for (int i=0;i<array.length();i++){
            ApiModel GetDataAdapter2 = new ApiModel();
            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

              //  GetDataAdapter2.setImageTitleNamee(json.getString(JSON_IMAGE_TITLE_NAME));

                GetDataAdapter2.setImage(json.getString("Course_thumbnail"));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

   // recyclerViewadapter = new RecyclerViewAdapter(GetDataAdapter1, this);

    recyclerView.setAdapter(recyclerViewadapter);
        }

}


