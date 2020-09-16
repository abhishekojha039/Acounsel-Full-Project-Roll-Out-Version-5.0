package com.edge.examfinder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class arts_man extends AppCompatActivity {
    ListView lstvw;
     String nm[]={"BBA (Bachelor of Business Administration)","BMS (Bachelor of Management Studies",
     "Integrated BBA + MBA program (5 years duration)","BHM (Bachelor of Hotel Management)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_man);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("BBA (Bachelor of Business Administration)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/bba-bachelor-of-business-administration-chp"));
                    startActivity(myIntent);
                }
              else  if(str.equals("BMS (Bachelor of Management Studies"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-management-studies-bms"));
                    startActivity(myIntent);
                }
              else  if(str.equals("Integrated BBA + MBA program (5 years duration)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.doonbusinessschool.com/programs/management-courses-at-doon-business-school/bba-mba-5-year-integrated.html"));
                    startActivity(myIntent);
                }
               else if(str.equals("BHM (Bachelor of Hotel Management)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-hotel-management-bhm"));
                    startActivity(myIntent);
                }



            }
        });

    }
}
