package com.edge.examfinder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class B_Bank extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"SBI PO Exams","IBPS PO/Management Trainee Exams","IBPS Clerk Exams","National Bank for Agriculture & Rural Development (NABARD)","RBI Grade A and Grade B Exams","ICICI PO Exams"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__bank);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(B_Bank.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("SBI PO Exams"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.careerpower.in/sbi-po-coaching.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("IBPS PO/Management Trainee Exams"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eduvidya.com/Entrance-Exam/IBPS-PO-Management-Trainee-"));
                    startActivity(myIntent);
                }
                else if(str.equals("IBPS Clerk Exams"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.careerpower.in/ibps-clerk.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("National Bank for Agriculture & Rural Development (NABARD)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nabard.org/"));
                    startActivity(myIntent);
                }
                else if(str.equals("RBI Grade A and Grade B Exams"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ibtindia.com/rbi-grade-b-recruitment-2019"));
                    startActivity(myIntent);
                }
                else if(str.equals("ICICI PO Exams"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicicareers.com/website/"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
