package com.edge.examfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_List extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"12th","B.com","BBA/LLB","BMS","BCA","Chartered Accoutant(Ca)/Company Secretary(CS)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce__list);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("12th"))
                {
                    Intent intent=new Intent(Commerce_List.this,Commerce_12th.class);
                    startActivity(intent);
                }
                if(str.equals("B.com"))
                {
                    Intent intent=new Intent(Commerce_List.this,Commerce_Bcom.class);
                    startActivity(intent);
                }
                if(str.equals("BBA/LLB"))
                {
                    Intent intent=new Intent(Commerce_List.this,Commerce_Bba.class);
                    startActivity(intent);
                }
                if(str.equals("BMS"))
                {
                    Intent intent=new Intent(Commerce_List.this,Commerce_Bms.class);
                    startActivity(intent);
                }
                if(str.equals("BCA"))
                {
                    Intent intent=new Intent(Commerce_List.this,Commerce_BCA.class);
                    startActivity(intent);
                }
                if(str.equals("Chartered Accoutant(Ca)/Company Secretary(CS)"))
                {
                    Intent intent=new Intent(Commerce_List.this,Commerce_CA.class);
                    startActivity(intent);
                }


            }
        });

    }
}
