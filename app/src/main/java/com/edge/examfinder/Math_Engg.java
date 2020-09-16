package com.edge.examfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Engg extends AppCompatActivity {
   ListView lstvw;
   String nm[]={"ENGINEERING","DEFENCE","FASHION & DESIGN","HUMANITY & SOCIAL SCIENCE","AGRICULTURE & HOTEL MANAGEMENT","LAW","ARCHITECTURE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__engg);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Engg.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("ENGINEERING"))
                {
                    Intent intent=new Intent(Math_Engg.this,Math_12th.class);
                    startActivity(intent);
                }
                else if(str.equals("DEFENCE"))
                {
                     Intent intent=new Intent(Math_Engg.this,Math_Defence.class);
                     startActivity(intent);
                }
                else if(str.equals("FASHION & DESIGN"))
                {
                    Intent intent=new Intent(Math_Engg.this,Math_Fashion.class);
                    startActivity(intent);
                }
                else if(str.equals("HUMANITY & SOCIAL SCIENCE"))
                {
                    Intent intent=new Intent(Math_Engg.this,Math_Human.class);
                    startActivity(intent);
                }
                else if(str.equals("AGRICULTURE & HOTEL MANAGEMENT"))
                {
                    Intent intent=new Intent(Math_Engg.this,Math.class);
                    startActivity(intent);
                }
                else if(str.equals("LAW"))
                {
                    Intent intent=new Intent(Math_Engg.this,Math_Law.class);
                    startActivity(intent);
                }
                else if(str.equals("ARCHITECTURE"))
                {
                    Intent intent=new Intent(Math_Engg.this,A_list.class);
                    startActivity(intent);
                }


            }
        });

    }
}
