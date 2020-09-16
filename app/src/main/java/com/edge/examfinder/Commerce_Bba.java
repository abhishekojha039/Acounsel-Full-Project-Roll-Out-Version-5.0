package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_Bba extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"CLAT","LSAT","ACLAT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce__bba);
        lstvw = findViewById(R.id.lstvw);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview, nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "" + nm[position];
                if (str.equals("CLAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/law/clat-exam"));
                    startActivity(myIntent);

                } else if (str.equals("LSAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/law/lsat-india-exam"));
                    startActivity(myIntent);

                } else if (str.equals("ACLAT")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/university/alliance-university/aclat-exam"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
