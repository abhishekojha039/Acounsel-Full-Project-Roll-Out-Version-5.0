package com.edge.examfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Maths_MBA extends AppCompatActivity {
     ListView lstvw;
     String nm[]={"Chartered Financial Analyst (CFA)","Financial Risk Manager (FRM) Exam","Certified Information Systems Auditor (CISA)","Certification in Risk Management Assurance (CRMA)","Certified in Production and Inventory Management (CPIM)","Project Management Professional (PMP)","Second MBA from an international business school"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__mb);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Maths_MBA.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Chartered Financial Analyst (CFA)"))
                {

                }
                else if(str.equals("Financial Risk Manager (FRM) Exam"))
                {

                }
                else if(str.equals("Certified Information Systems Auditor (CISA)"))
                {

                }
                else if(str.equals("Certification in Risk Management Assurance (CRMA)"))
                {

                }
                else if (str.equals("Certified in Production and Inventory Management (CPIM)"))
                {

                }
                else if(str.equals("Project Management Professional (PMP)"))
                {

                }
                else if(str.equals("Second MBA from an international business school"))
                {

                }
            }
        });
    }
}
