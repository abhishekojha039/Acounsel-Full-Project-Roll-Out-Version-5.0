package com.edge.examfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_Mba_list extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Marketing","Government Sector"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__mba_list);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_Mba_list.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Government Sector"))
                {
                    Intent intent=new Intent(Math_Mba_list.this,Mba_GOVT.class);
                    startActivity(intent);
                }
                else if(str.equals("Marketing"))
                {
                    Intent intent=new Intent(Math_Mba_list.this,Mba_Mark.class);
                    startActivity(intent);
                }
            }
        });
    }
}
