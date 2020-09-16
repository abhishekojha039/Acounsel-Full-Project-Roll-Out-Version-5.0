package com.edge.examfinder;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

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

public class notify extends AppCompatActivity implements notification2Adapter.OnIteamClickListner {
    private RecyclerView mRecycler;
    private notification2Adapter mmathAdapter;
    private ArrayList<notificationRecycler> mmathRecyclerViews;
    private RequestQueue mRequestQueue;
    Intent intent;
    SharedPreferences pref;
    int gg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mRecycler = findViewById(R.id.mathRecycler1);
        mRecycler.setHasFixedSize(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mmathRecyclerViews = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        Intent intent=getIntent();
        // Toast.makeText(this, ""+intent.getStringExtra("title"), Toast.LENGTH_SHORT).show();
        pref = getApplicationContext().getSharedPreferences("MyPref1", 0);

       // Toast.makeText(this, ""+intent.getStringExtra("pos"), Toast.LENGTH_SHORT).show();

        parseJson();
      //  Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

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


                               JSONObject hit = jsonArray.getJSONObject(pref.getInt("count", -1));
                                String title = hit.getString("title");
                                String image = hit.getString("image");
                                String url=hit.getString("url");
                                String description=hit.getString("description");

                                mmathRecyclerViews.add(new notificationRecycler(image, title,url,description));



                            mmathAdapter = new notification2Adapter(notify.this, mmathRecyclerViews);
                            mRecycler.setAdapter(mmathAdapter);
                            mmathAdapter.setOnIteamClickListner(notify.this);

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

        notificationRecycler clickedItem = mmathRecyclerViews.get(position);

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickedItem.getUrl().toString()));
        startActivity(myIntent);

    }
}
