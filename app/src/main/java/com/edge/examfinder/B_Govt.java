package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class B_Govt extends AppCompatActivity {
    ListView lstvw;
     String nm[]={"Civil Services Examination (CSE)","UPSC IES","Indian Engineering Services Exam","Indian Economic Service Examination (IES)","Indian Statistical Service Examination (ISS)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__govt);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(B_Govt.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Civil Services Examination (CSE)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upsc.gov.in/examinations/Civil%20Services%20%28Preliminary%29%20Examination%2C%202019"));
                    startActivity(myIntent);
                }
                else if(str.equals("UPSC IES"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upsc.gov.in/examinations/Engineering%20Services%20%28Preliminary%29%20Examination%2C%202020"));
                    startActivity(myIntent);
                }
                else if(str.equals("Indian Engineering Services Exam"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/exams/ies-exam"));
                    startActivity(myIntent);
                }
                else if(str.equals("Indian Statistical Service Examination (ISS)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upsc.gov.in/examinations/Indian%20Economic%20Service%20and%20Indian%20Statistical%20Service%20Examination%2C%202019"));
                    startActivity(myIntent);
                }

            }
        });

    }
}
