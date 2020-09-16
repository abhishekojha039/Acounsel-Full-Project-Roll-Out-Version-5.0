package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Fashion extends AppCompatActivity {
  ListView lstvw;
  String nm[]={"National Institute of Design Admissions","All India Entrance Examination for Design (AIEED)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__fashion);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Fashion.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("National Institute of Design Admissions"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admissions.upes.ac.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("All India Entrance Examination for Design (AIEED)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admissions.upes.ac.in/"));
                    startActivity(myIntent);
                }
            }
        });

    }
}
