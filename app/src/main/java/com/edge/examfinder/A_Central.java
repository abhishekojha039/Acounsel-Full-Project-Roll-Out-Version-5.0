package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class A_Central extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Architectural Engineer","Architectural Historian/Journalist","Building Researcher","Interior Designer","Section engineer","Branch engineer","Art Director","Building Contractor","Building Inspector","Landscape Architect"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__central);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(A_Central.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Architectural Engineer"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Architectural Historian/Journalist"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Interior Designer"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Section engineer"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Branch engineer"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Art Director"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Building Contractor"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Building Inspector"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
                else if(str.equals("Landscape Architect"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://collegedunia.com/courses/bachelor-of-technology-btech-architecture-engineering"));
                    startActivity(myIntent);
                }
            }
        });

    }
}
