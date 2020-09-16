package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_Bcom extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"BHU-UET","GLAET","GATA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce__bcom);
        lstvw = findViewById(R.id.lstvw);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview, nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "" + nm[position];
                if (str.equals("BHU-UET")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/university/bhu-banaras-hindu-university/bhu-uet-exam"));
                    startActivity(myIntent);

                } else if (str.equals("GLAET")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/university/gla-university/glaet-exam"));
                    startActivity(myIntent);

                } else if (str.equals("GATA")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/university/gd-goenka-university/goenkan-aptitude-test-for-admission-gata-exam"));
                    startActivity(myIntent);
                }
            }
            });

            }
}
