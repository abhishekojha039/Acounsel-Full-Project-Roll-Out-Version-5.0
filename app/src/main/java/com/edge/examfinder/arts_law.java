package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class arts_law extends AppCompatActivity {
     ListView lstvw;
     String nm[]={"B.A + L.L.B","BBA + L.L.B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_law);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(arts_law.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("B.A + L.L.B"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-a-ll-b-chp"));
                    startActivity(myIntent);
                }
                else if(str.equals("BBA + L.L.B"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/bba-ll-b-chp"));
                    startActivity(myIntent);
                }

            }
        });
    }
}
