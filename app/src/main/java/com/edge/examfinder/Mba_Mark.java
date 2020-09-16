package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Mba_Mark extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Chartered Financial Analyst (CFA)","Financial Risk Manager (FRM) Exam","Certified Information Systems Auditor (CISA)","Certification in Risk Management Assurance (CRMA)","Certified in Production and Inventory Management (CPIM)","Project Management Professional (PMP)","Second MBA from an international business school"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba__mark);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Mba_Mark.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Chartered Financial Analyst (CFA)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cfainstitute.org/programs/cfa"));
                    startActivity(myIntent);
                }
                else if(str.equals("Financial Risk Manager (FRM) Exam"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.schweser.com/frm/blog/become-a-financial-risk-manager/how-to-become-a-certified-frm"));
                    startActivity(myIntent);
                }
                else if(str.equals("Certified Information Systems Auditor (CISA)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.isaca.org/Certification/CISA-Certified-Information-Systems-Auditor/Pages/default.aspx"));
                    startActivity(myIntent);
                }
                else if(str.equals("Certification in Risk Management Assurance (CRMA)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youracclaim.com/org/theiia/badge/certification-in-risk-management-assurance-crma"));
                    startActivity(myIntent);
                }
                else if(str.equals("Certified in Production and Inventory Management (CPIM)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apics.org/credentials-education/credentials/cpim"));
                    startActivity(myIntent);
                }
                else if(str.equals("Project Management Professional (PMP)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pmi.org/certifications/types/project-management-pmp"));
                    startActivity(myIntent);
                }
                else if(str.equals("Second MBA from an international business school"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mbacrystalball.com/blog/2017/02/15/second-mba-abroad-after-iim-isb/"));
                    startActivity(myIntent);
                }
            }
        });
    }
}
