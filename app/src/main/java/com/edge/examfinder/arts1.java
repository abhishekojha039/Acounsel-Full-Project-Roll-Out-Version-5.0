package com.edge.examfinder;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class arts1 extends AppCompatActivity implements mathAdapter.OnIteamClickListner {
    private RecyclerView mRecycler;
    private mathAdapter mmathAdapter;
    private ArrayList<mathRecyclerView> mmathRecyclerViews;
    private RequestQueue  mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts1);
        mRecycler=findViewById(R.id.mathRecycler);
        mRecycler.setHasFixedSize(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mmathRecyclerViews=new ArrayList<>();
        mRequestQueue= Volley.newRequestQueue(this);
        parseJson();

    }

    private void parseJson() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        String url="https://next.json-generator.com/api/json/get/EyxkIAQgK";
        // String url="https://www.json-generator.com/api/json/get/bTXmNDfemq?indent=2";
          // String url="https://jsonblob.com/api/a1399998-d4e4-11ea-bb25-3706c1fdd572";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray("ARTS");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);
                                String title = hit.getString("title");
                                String imageURL = hit.getString("image");
                                String count = hit.getString("count");
                                mmathRecyclerViews.add(new mathRecyclerView(imageURL, title,count));


                            }
                            mmathAdapter=new mathAdapter(arts1.this,mmathRecyclerViews);
                            mRecycler.setAdapter(mmathAdapter);
                            mmathAdapter.setOnIteamClickListner(arts1.this);

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
        mathRecyclerView clickedItem=mmathRecyclerViews.get(position);
        String name=""+clickedItem.getText();
        if(name.equals("PHD-COURSES"))
        {
            Intent intent=new Intent(this,arts3.class);
            Toast.makeText(this, ""+clickedItem.getText(), Toast.LENGTH_SHORT).show();
            intent.putExtra("title",clickedItem.getText());
            intent.putExtra("name","arts");
            startActivity(intent);

        }
        else {
            Intent intent = new Intent(this, arts2.class);

            Toast.makeText(this, "" + clickedItem.getText(), Toast.LENGTH_SHORT).show();
            intent.putExtra("title", clickedItem.getText());
            intent.putExtra("name","arts");
            startActivity(intent);
        }
    }
}