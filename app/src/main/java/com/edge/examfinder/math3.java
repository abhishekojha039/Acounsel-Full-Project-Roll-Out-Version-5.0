package com.edge.examfinder;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class math3 extends AppCompatActivity implements math3Adapter.OnIteamClickListner{
    private RecyclerView mRecycler;
    private math3Adapter mmathAdapter;
    private ArrayList<mathRecyclerView> mmathRecyclerViews;
    private RequestQueue  mRequestQueue;
    private  String jsonVariable;
    private  String json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math3);
        mRecycler=findViewById(R.id.mathRecycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mmathRecyclerViews=new ArrayList<>();
        mRequestQueue= Volley.newRequestQueue(this);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        Intent intent=getIntent();
        //  Toast.makeText(this, "math3"+intent.getStringExtra("title"), Toast.LENGTH_SHORT).show();
        jsonVariable=intent.getStringExtra("title").toString();

        parseJson();


    }

    private void parseJson() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        String url="https://next.json-generator.com/api/json/get/NJBhmPX-Y";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray(jsonVariable);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);
                                String title = hit.getString("title");
                                String imageURL = hit.getString("image");
                                String count = hit.getString("count");
                                mmathRecyclerViews.add(new mathRecyclerView(imageURL, title,count));


                            }
                            mmathAdapter=new math3Adapter(math3.this,mmathRecyclerViews);
                            mRecycler.setAdapter(mmathAdapter);
                            mmathAdapter.setOnIteamClickListner(math3.this);

                        }
                        catch (JSONException e)
                        {
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
        Intent intent=new Intent(this,myJson.class);
        mathRecyclerView clickedItem=mmathRecyclerViews.get(position);
        intent.putExtra("title",clickedItem.getText());
        intent.putExtra("name","maths");
        startActivity(intent);
    }
}