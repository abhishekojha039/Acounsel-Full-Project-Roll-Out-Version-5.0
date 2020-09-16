package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Human extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Banaras Hindu University","IIT Madras Humanities and Social Sciences Entrance Examination (HSEE)","TISS Bachelors Admission Test (TISS-BAT)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__human);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Human.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Banaras Hindu University"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bhu.ac.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("IIT Madras Humanities and Social Sciences Entrance Examination (HSEE)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upgrad.com/"));
                    startActivity(myIntent);
                }
                else if(str.equals("TISS Bachelors Admission Test (TISS-BAT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admissions.upes.ac.in/"));
                    startActivity(myIntent);

                }
            }
        });

    }
}
