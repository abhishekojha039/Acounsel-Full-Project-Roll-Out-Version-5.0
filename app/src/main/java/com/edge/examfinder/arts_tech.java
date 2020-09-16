package com.edge.examfinder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class arts_tech extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"BCA – Bachelor of Computer Application","B.Arch – Bachelor of Architecture"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_tech);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(arts_tech.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("BCA – Bachelor of Computer Application"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/bca-bachelor-of-computer-applications-chp"));
                    startActivity(myIntent);
                }
                else if(str.equals("B.Arch – Bachelor of Architecture"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-arch-bachelor-of-architecture-chp"));
                    startActivity(myIntent);
                }

            }
        });
    }
}
