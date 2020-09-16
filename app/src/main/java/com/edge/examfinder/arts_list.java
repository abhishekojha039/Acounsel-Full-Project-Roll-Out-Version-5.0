package com.edge.examfinder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class arts_list extends AppCompatActivity {
    String nm[]={"Bachelor’s Degree Courses","Technical Courses",
    "Law Courses","Management Courses","Fashion Design / Design Courses"};
    ListView lstvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_list);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Bachelor’s Degree Courses"))
                {
                    Intent intent=new Intent(arts_list.this,arts_bach.class);
                    startActivity(intent);
                }
              else  if(str.equals("Technical Courses"))
                {
                    Intent intent=new Intent(arts_list.this,arts_tech.class);
                    startActivity(intent);
                }
              else  if(str.equals("Law Courses"))
                {
                    Intent intent=new Intent(arts_list.this,arts_law.class);
                    startActivity(intent);
                }
              else  if(str.equals("Management Courses"))
                {
                    Intent intent=new Intent(arts_list.this,arts_man.class);
                    startActivity(intent);
                }
              else  if(str.equals("Fashion Design / Design Courses"))
                {
                    Intent intent=new Intent(arts_list.this,arts_fashion.class);
                    startActivity(intent);
                }



            }
        });
    }
}
