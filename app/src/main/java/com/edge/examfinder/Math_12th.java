package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_12th extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"JEE Mains & Advance","BITSAT","INDIAN NAVY B.TECH ENTRY","COMED-K","IPU-CET (B. Tech)","VITEEE","AMU (B. Tech)","All India Engineering Entrance Exam with PCM (MPC)","PET"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_12th);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_12th.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=nm[position];
                if(str.equals("JEE Mains & Advance"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jeeadv.ac.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("BITSAT"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bitsadmission.com/"));
                    startActivity(myIntent);
                }
                else if(str.equals("INDIAN NAVY B.TECH ENTRY"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.joinindiannavy.gov.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("COMED-K"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.comedk.org/"));
                    startActivity(myIntent);
                }
                else if(str.equals("IPU-CET (B. Tech)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nest.lpu.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("VITEEE"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://viteee.vit.ac.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("AMU (B. Tech)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amu.ac.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("All India Engineering Entrance Exam with PCM (MPC)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mpcengineering.com.au/"));
                    startActivity(myIntent);
                }
                else if(str.equals("PET"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://engineering.careers360.com/exams/cg-pet"));
                    startActivity(myIntent);
                }



            }
        });

    }
}
