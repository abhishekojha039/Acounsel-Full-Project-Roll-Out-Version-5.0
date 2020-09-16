package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"PAT","All India Hotel management Entrance Exam NCHMCT JEE","Indian Council of Agricultural Research ICAR AIEEA-UG-PG"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Indian Council of Agricultural Research ICAR AIEEA-UG-PG"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://icar.org.in"));
                    startActivity(myIntent);
                }
                else if(str.equals("PAT"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admission.aglasem.com/cg-pat-2019/"));
                    startActivity(myIntent);
                }
                else if(str.equals("All India Hotel management Entrance Exam NCHMCT JEE"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hospitality.careers360.com/exams/nchm-jee"));
                    startActivity(myIntent);
                }
            }

        });

    }
}
