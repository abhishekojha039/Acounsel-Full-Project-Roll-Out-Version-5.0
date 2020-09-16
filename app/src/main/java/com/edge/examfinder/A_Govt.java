package com.edge.examfinder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class A_Govt extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Department of Railways","Architecture and Building Development Firms","Department of Post and Telegraph","National Building Organization"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__govt);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(A_Govt.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Department of Railways"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.indianrailways.gov.in/railwayboard/view_section.jsp?lang=0&id=0,4,1244"));
                    startActivity(myIntent);
                }
                else if(str.equals("Architecture and Building Development Firms"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.di.net/articles/the-architect-as-developer/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Department of Post and Telegraph"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ibpsguide.com/indian-post-office-recruitment"));
                    startActivity(myIntent);
                }
                else if(str.equals("National Building Organization"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nbo.nic.in/"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
