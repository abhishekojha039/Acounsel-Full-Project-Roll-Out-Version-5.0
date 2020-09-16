package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_CA extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"ICAI","ICSI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce__c);
        lstvw = findViewById(R.id.lstvw);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview, nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "" + nm[position];
                if (str.equals("ICAI")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/college/the-institute-of-chartered-accountants-of-india-delhi/icai-exam"));
                    startActivity(myIntent);

                } else if (str.equals("ICSI")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/college/institute-of-company-secretaries-of-india-icsi/icsi-exam"));
                    startActivity(myIntent);

                }
            }
        });
    }
}
