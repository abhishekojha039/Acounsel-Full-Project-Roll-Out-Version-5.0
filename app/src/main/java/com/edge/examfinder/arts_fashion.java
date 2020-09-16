package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class arts_fashion extends AppCompatActivity {
     ListView lstvw;
     String nm[]={"Bachelor of Textile Design","Bachelor of Design (Accessory)","Bachelor of Fashion Communication",
     "Bachelor of Interior Designing","Bachelor of Product Design","Furniture and Interior Design course"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_fashion);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Bachelor of Textile Design"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-arts-ba-textile-design"));
                    startActivity(myIntent);
                }
                else  if(str.equals("Bachelor of Design (Accessory)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-des-bachelor-of-design-chp"));
                    startActivity(myIntent);
                }
                else  if(str.equals("Bachelor of Fashion Communication"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://targetstudy.com/courses/bdes-fashion-communication.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("Bachelor of Interior Designing"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://targetstudy.com/courses/bdes-fashion-communication.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("Bachelor of Product Design"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://targetstudy.com/courses/ba-interior-design.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("Furniture and Interior Design course"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/design/furniture-design-chp"));
                    startActivity(myIntent);
                }



            }
        });
    }
}
