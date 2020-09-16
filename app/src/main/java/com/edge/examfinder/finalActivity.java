package com.edge.examfinder;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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

public class finalActivity extends AppCompatActivity implements finalAdapter.OnIteamClickListner {
    private RecyclerView mRecycler;
    private finalAdapter mmathAdapter;
    private ArrayList<finalRecycler> mmathRecyclerViews;
    private RequestQueue mRequestQueue;
    String url,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        mRecycler = findViewById(R.id.mathRecycler1);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mmathRecyclerViews = new ArrayList<>();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        mRequestQueue = Volley.newRequestQueue(this);

      //  Toast.makeText(this, ""+getIntent().getStringExtra("count").toString(), Toast.LENGTH_SHORT).show();
        if(getIntent().getStringExtra("count").toString().equals("exams"))
        {
             url="https://next.json-generator.com/api/json/get/4JgqRpSZY";
             name="exams";
        }
        else if(getIntent().getStringExtra("count").toString().equals("comp"))
        {
            url="https://next.json-generator.com/api/json/get/418boNIWF";
            name="comp";
        }
        parseJson();

    }

    private void parseJson() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        //url = "https://next.json-generator.com/api/json/get/4JgqRpSZY";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray(name);


                                JSONObject hit = jsonArray.getJSONObject(getIntent().getIntExtra("mount",0));
                                String title = hit.getString("title");
                                String image = hit.getString("image");
                                String url=hit.getString("url");
                                String description=hit.getString("description");

                                mmathRecyclerViews.add(new finalRecycler(image, title,url,description));

                            mmathAdapter = new finalAdapter(finalActivity.this, mmathRecyclerViews);
                            mRecycler.setAdapter(mmathAdapter);
                            mmathAdapter.setOnIteamClickListner(finalActivity.this);

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

        finalRecycler clickedItem = mmathRecyclerViews.get(position);

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickedItem.getUrl().toString()));
        startActivity(myIntent);

    }
}
