package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_Bms extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"DUJAT","IPMAT","NPAT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce__bms);
        lstvw = findViewById(R.id.lstvw);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview, nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "" + nm[position];
                if (str.equals("DUJAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mbauniverse.com/bba/du-jat"));
                    startActivity(myIntent);

                } else if (str.equals("IPMAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mbauniverse.com/bba/ipmat"));
                    startActivity(myIntent);

                } else if (str.equals("NPAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mbauniverse.com/bba/npat"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
