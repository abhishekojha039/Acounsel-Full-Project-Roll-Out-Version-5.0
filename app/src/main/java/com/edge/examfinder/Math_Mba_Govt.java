package com.edge.examfinder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Math_Mba_Govt extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"personnel officer in  bank","Marketing Officer in bank","General Manager Posts at various Psus and Banks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__mba__govt);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Mba_Govt.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("personnel officer in  bank"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ibtindia.com/ibps-so-hr-personnel-officer"));
                    startActivity(myIntent);
                }
                else if(str.equals("Marketing Officer in bank"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://scoop.eduncle.com/ibps-marketing-officer"));
                    startActivity(myIntent);
                }
                else if(str.equals("General Manager Posts at various Psus and Banks"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jagranjosh.com/articles-jobs-in-psus-1305796596-1"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
