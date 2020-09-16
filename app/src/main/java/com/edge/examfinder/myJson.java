package com.edge.examfinder;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
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
import java.util.List;

public class myJson extends AppCompatActivity implements myAdapter.OnIteamClickListner{
 RecyclerView recyclerView;
 List<recycler> stream;
 private static String JSON_URL;
 myAdapter adapter;
 String jsonVariable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_json);
        recyclerView=findViewById(R.id.recycle);
        stream=new ArrayList<>();
        Intent intent=getIntent();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
         //Toast.makeText(this, intent.getStringExtra("title1")+intent.getStringExtra("title")+intent.getStringExtra("title2"), Toast.LENGTH_SHORT).show();
         jsonVariable=intent.getStringExtra("title").toString();
       // Toast.makeText(this, ""+jsonVariable, Toast.LENGTH_SHORT).show();
           if(intent.getStringExtra("name").equals("maths"))
           {
             //JSON_URL="https://next.json-generator.com/api/json/get/4yirtpQxK";
               JSON_URL="https://next.json-generator.com/api/json/get/E1PJcOJGF";
           }
           else if(intent.getStringExtra("name").equals("arts"))
           {
               JSON_URL="https://next.json-generator.com/api/json/get/VylB4h8eY";
           }
           else if(intent.getStringExtra("name").equals("biology"))
           {
               JSON_URL="https://next.json-generator.com/api/json/get/Eklf9UD7K";
               //Toast.makeText(this, "bio"+jsonVariable, Toast.LENGTH_SHORT).show();
           }
           else if(intent.getStringExtra("name").equals("commerce"))
           {
               JSON_URL="https://next.json-generator.com/api/json/get/41hNQzPmt";
              // Toast.makeText(this, "bio"+jsonVariable, Toast.LENGTH_SHORT).show();
           }

        extractList();

    }

    private void extractList() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        RequestQueue queue= Volley.newRequestQueue(this);
       // String url="https://next.json-generator.com/api/json/get/NJqJp4ZgF"; 
       // String url="https://next.json-generator.com/api/json/get/4yirtpQxK";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray(jsonVariable);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject streamObject = jsonArray.getJSONObject(i);
                                recycler recycler1=new recycler();
                                recycler1.setStream(streamObject.getString("STREAM").toString());
                                recycler1.setEligibility(streamObject.getString("ELIGIBILITY_REQUIRED").toString());
                                recycler1.setSelection(streamObject.getString("SELECTION_AREAS").toString());
                               // recycler1.setArea(streamObject.getString("SELECTION").toString());
                                recycler1.setJob(streamObject.getString("JOB_EXPECTANCY").toString());
                                recycler1.setPackage1(streamObject.getString("PACKAGE").toString());
                                recycler1.setDuration(streamObject.getString("DURATION").toString());
                                recycler1.setExamination(streamObject.getString("EXAMINATION DATE").toString());
                                recycler1.setUrl(streamObject.getString("URL").toString());
                                recycler1.setNote(streamObject.getString("NOTE").toString());
                                stream.add(recycler1);


                            }
                           recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            adapter=new myAdapter(getApplicationContext(),stream);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnIteamClickListner(myJson.this);

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
        queue.add(request);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(this,myJson.class);
        recycler clickedItem=stream.get(position);
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickedItem.getUrl().toString()));
        startActivity(myIntent);
    }
}