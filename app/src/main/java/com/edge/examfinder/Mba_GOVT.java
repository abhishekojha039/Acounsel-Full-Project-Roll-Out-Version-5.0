package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Mba_GOVT extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"personnel officer in  bank","Marketing Officer in bank","General Manager Posts at various Psus and Banks"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba__govt);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Mba_GOVT.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("personnel officer in  bank"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://scoop.eduncle.com/ibps-hr-specialist-officer"));
                    startActivity(myIntent);
                }
                else if(str.equals("Marketing Officer in bank"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oliveboard.in/blog/marketing-officer-in-a-bank-job-description-and-responsibilities/"));
                    startActivity(myIntent);
                }
                else if(str.equals("General Manager Posts at various Psus and Banks"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://india.recruit.net/search-consultant-opening-for-retired-gm-dgm-agm-of-psu-or-bank-jobs"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
