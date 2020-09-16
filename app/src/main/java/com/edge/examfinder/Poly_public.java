package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Poly_public extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Railways","Indian Army","GAIL – Gas Authority of India Limited","ONGC – Oil & Natural Gas Corporation","DRDO – Defence Research and Development Organization",
            "BHEL – Bharat Heavy Electricals Limited","NTPC – National Thermal Power Corporation","BSNL – Bharat Sanchar Nigam Limited","NSSO – National Sample Survey Organization"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly_public);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Poly_public.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Railways"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freshersworld.com/rrb-indian-railway-recruitment-jobs/4444116"));
                    startActivity(myIntent);
                }
                else if(str.equals("GAIL – Gas Authority of India Limited"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                    startActivity(myIntent);
                }
                else if(str.equals("ONGC – Oil & Natural Gas Corporation"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gailonline.com/CR-ApplyingGail.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("DRDO – Defence Research and Development Organization"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.drdo.gov.in/home"));
                    startActivity(myIntent);
                }
                else if(str.equals("BHEL – Bharat Heavy Electricals Limited"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fresherslive.com/bhel-bharat-heavy-electricals-limited-recruitment"));
                    startActivity(myIntent);
                }
                else if(str.equals("NTPC – National Thermal Power Corporation"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ntpccareers.net/"));
                    startActivity(myIntent);
                }
                else if(str.equals("BSNL – Bharat Sanchar Nigam Limited"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freshersworld.com/bsnl-job-openings/444429"));
                    startActivity(myIntent);
                }
                else if(str.equals("NSSO – National Sample Survey Organization"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://currentaffairs.gktoday.in/tags/national-sample-survey-office-nsso"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
