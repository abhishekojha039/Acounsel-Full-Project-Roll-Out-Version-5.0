package com.edge.examfinder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Math_List extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"12th","B.E/B.TECH","MBA","Polytechnic"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math__list);

        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Math_List.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
       lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String str=nm[position];
               if(str.equals("12th"))
               {
                   Intent intent=new Intent(Math_List.this,Math_Engg.class);
                   startActivity(intent);

               }
               else if(str.equals("B.E/B.TECH"))
               {
                   Intent intent=new Intent(Math_List.this,Math_Btech.class);
                   startActivity(intent);

               }
               else if(str.equals("MBA"))
               {
                   Intent intent=new Intent(Math_List.this,Math_Mba_list.class);
                   startActivity(intent);
               }

               else if(str.equals("Polytechnic"))
               {
                   Intent intent=new Intent(Math_List.this,Poly_list.class);
                   startActivity(intent);
               }



           }
       });
    }
}
