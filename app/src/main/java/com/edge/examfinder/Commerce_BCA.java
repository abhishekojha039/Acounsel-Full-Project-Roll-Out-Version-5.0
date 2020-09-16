package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_BCA extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"BU-MAT","SET","GSAT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce__bc);
        lstvw = findViewById(R.id.lstvw);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview, nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "" + nm[position];
                if (str.equals("BU-MAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/university/bharati-vidyapeeth/bumat-exam"));
                    startActivity(myIntent);

                } else if (str.equals("SET")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/bba/set-exam"));
                    startActivity(myIntent);

                } else if (str.equals("GSAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/science/gsat-exam"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
