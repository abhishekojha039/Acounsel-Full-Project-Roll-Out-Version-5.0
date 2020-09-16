package com.edge.examfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class myNotification extends AppCompatActivity implements notificationAdapter.OnIteamClickListner {
    private RecyclerView mRecycler;
    private notificationAdapter mmathAdapter;
    private ArrayList<mathRecyclerView> mmathRecyclerViews;
    private RequestQueue mRequestQueue;
    SharedPreferences pref;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);
        mRecycler = findViewById(R.id.mathRecycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mmathRecyclerViews = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("count",0);
        editor.commit();

    }



    private void parseJson() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        String url = "https://next.json-generator.com/api/json/get/NkhEWREgY";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray("news");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);
                                String title = hit.getString("title");
                                String imageURL = hit.getString("image");
                                String count = hit.getString("count");
                                mmathRecyclerViews.add(new mathRecyclerView(imageURL, title,count));


                            }
                            mmathAdapter = new notificationAdapter(myNotification.this, mmathRecyclerViews);
                            mRecycler.setAdapter(mmathAdapter);
                            mmathAdapter.setOnIteamClickListner(myNotification.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {

        mathRecyclerView clickedItem = mmathRecyclerViews.get(position);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref1", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("count",position);
        editor.commit();
        Intent intent = new Intent(this, notify.class);
        startActivity(intent);
    }
}