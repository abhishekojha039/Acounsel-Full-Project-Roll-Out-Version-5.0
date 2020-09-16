
package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class B_defence extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"AFCAT","UPSC CDS","Indian Army University Entry Scheme"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_defence);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(B_defence.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("AFCAT"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://afcat.cdac.in/AFCAT/"));
                    startActivity(myIntent);
                }
                else if(str.equals("UPSC CDS"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upsc.gov.in/examinations/Combined%20Defence%20Services%20Examination%20%28I%29%2C%202019"));
                    startActivity(myIntent);
                }
                else if(str.equals("Indian Army University Entry Scheme"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wisdomjobs.com/govtjobs/indian-army-university-entry-scheme"));
                    startActivity(myIntent);
                }
            }
        });

    }
}
