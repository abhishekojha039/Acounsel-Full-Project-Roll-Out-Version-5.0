package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class B_Mtech extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Graduate Aptitude Test in Engineering (GATE)","Joint Admission Test for M.Sc. (JAM)","CEED","HSEE by IIT Madras"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_b__mtech);

        lstvw=findViewById(R.id.lstvw);

        ArrayAdapter adapter=new ArrayAdapter(B_Mtech.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Graduate Aptitude Test in Engineering (GATE)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/engineering/gate-exam"));
                    startActivity(myIntent);
                }
                else if(str.equals("Joint Admission Test for M.Sc. (JAM)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jam.iitkgp.ac.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("CEED"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ceed.iitb.ac.in/2020/"));
                    startActivity(myIntent);
                }
                else if(str.equals("HSEE by IIT Madras"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hsee.iitm.ac.in/"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
