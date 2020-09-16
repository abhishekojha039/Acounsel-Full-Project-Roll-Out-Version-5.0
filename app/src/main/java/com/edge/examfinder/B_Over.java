package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class B_Over extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Graduate Management Admission Test (GMAT)","Graduate Record Examinations (GRE)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__over);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(B_Over.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Graduate Management Admission Test (GMAT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studyabroad.shiksha.com/exams/gmat"));
                    startActivity(myIntent);                }
                else if(str.equals("Graduate Record Examinations (GRE)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studyabroad.shiksha.com/exams/gre"));
                    startActivity(myIntent);
                }

            }
        });

    }
}
