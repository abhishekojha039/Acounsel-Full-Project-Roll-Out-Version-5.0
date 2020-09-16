package com.edge.examfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Btech extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"DEFENCE","MBA","FOR OVERSEAS UNIVERSITIES","MTECH, ME, MA","LAW ENTRANCE EXAM","GOVERNMENT EXAMS","BANKING"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__btech);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Btech.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("DEFENCE"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_defence.class);
                    startActivity(intent);
                }
                else if(str.equals("MBA"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_Mba.class);
                    startActivity(intent);
                }
                else if(str.equals("FOR OVERSEAS UNIVERSITIES"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_Over.class);
                    startActivity(intent);
                }
                else if(str.equals("MTECH, ME, MA"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_Mtech.class);
                    startActivity(intent);
                }
                else if(str.equals("LAW ENTRANCE EXAM"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_Law.class);
                    startActivity(intent);
                }
                else if(str.equals("GOVERNMENT EXAMS"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_Govt.class);
                    startActivity(intent);
                }
                else if(str.equals("BANKING"))
                {
                    Intent intent=new Intent(Math_Btech.this,B_Bank.class);
                    startActivity(intent);
                }
            }
        });
    }
}
