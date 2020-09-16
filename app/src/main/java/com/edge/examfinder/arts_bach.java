package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class arts_bach extends AppCompatActivity {
    String nm[]={"B.A in History","B.A in Geography","B.A in Political Science",
    "B.A in Public Administration","B.A in English Literature","B.A in Economics"};
    ListView lstvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_bach);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(arts_bach.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("B.A in History"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apnaahangout.com/ba-history/"));
                    startActivity(myIntent);
                }
                else if(str.equals("B.A in Geography"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-arts-ba-geography"));
                    startActivity(myIntent);
                }
                else if(str.equals("B.A in Political Science"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://targetstudy.com/courses/ba-political-science.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("B.A in Public Administration"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://padm.metu.edu.tr/information"));
                    startActivity(myIntent);
                }
                else if(str.equals("B.A in English Literature"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-arts-ba-english-literature"));
                    startActivity(myIntent);
                }
                else if(str.equals("B.A in Economics"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://targetstudy.com/courses/ba-economics.html"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
