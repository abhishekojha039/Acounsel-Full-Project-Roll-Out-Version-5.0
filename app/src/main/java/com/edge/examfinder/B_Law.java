package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class B_Law extends AppCompatActivity {
   ListView lstvw;
   String nm[]={"LSAT India","CLAT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__law);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(B_Law.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String str=""+nm[position];
                if(str.equals("LSAT India"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lawentrance.com/lsat/"));
                    startActivity(myIntent);
                }
                else if(str.equals("CLAT"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://clatconsortiumofnlu.ac.in/"));
                    startActivity(myIntent);
                }
            }
        });

    }
}
