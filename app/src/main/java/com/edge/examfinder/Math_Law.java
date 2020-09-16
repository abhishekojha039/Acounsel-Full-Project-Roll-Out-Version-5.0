package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Law extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Common Law Admission Test","All India Law Entrance Test (AILET)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__law);
        ArrayAdapter adapter=new ArrayAdapter(Math_Law.this,R.layout.listview,nm);
        lstvw=findViewById(R.id.lstvw);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Common Law Admission Test"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lawentrance.com/"));
                    startActivity(myIntent);
                }
                else if (str.equals("All India Law Entrance Test (AILET)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lawentrance.com/"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
