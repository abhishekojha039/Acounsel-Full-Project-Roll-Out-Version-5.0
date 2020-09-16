package com.edge.examfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Poly_list extends AppCompatActivity {
  ListView lstvw;
  String nm[]={"Public Sector","Private Sector"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly_list);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Poly_list.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Public Sector"))
                {
                    Intent intent=new Intent(Poly_list.this,Poly_public.class);
                    startActivity(intent);
                }
                else if(str.equals("Private Sector"))
                {
                    Intent intent=new Intent(Poly_list.this,Poly_private.class);
                    startActivity(intent);
                }
            }
        });
    }
}
