package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Defence extends AppCompatActivity {
    ListView  lstvw;
    String nm[]={"Indian Maritime University Common Entrance Test","Indian Navy B.Tech Entry Scheme","Indian Navy Sailors Recruitment","Indian Army Technical Entry Scheme (TES)","National Defence Academy and Naval Academy Examination (I)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__defence);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Defence.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Indian Maritime University Common Entrance Test"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.joinindiannavy.gov.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Indian Navy B.Tech Entry Scheme"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.joinindiannavy.gov.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Indian Navy Sailors Recruitment"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.joinindiannavy.gov.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Indian Army Technical Entry Scheme (TES)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.joinindiannavy.gov.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("National Defence Academy and Naval Academy Examination (I)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.joinindiannavy.gov.in/"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
