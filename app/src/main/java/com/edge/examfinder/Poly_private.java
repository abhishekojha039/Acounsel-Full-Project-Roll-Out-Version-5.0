package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Poly_private extends AppCompatActivity {
    ListView lstvw;
    String nm[]={"Airlines - Indigo, Spicejet, Jet Airways, etc.","Construction Firms – Unitech, DLF, Jaypee Associated, GMR Infra, Mitas, etc.","Communication Firms – Bharti Airtel, Reliance Communications, Idea Cellular, etc.",
            "Computer Engineering Firms – TCS, HCL, Wipro, Polaris, etc.","Automobiles – Maruti Suzuki, Toyota, TATA Motors, Mahindra, Bajaj Auto, etc.","Electrical / Power Firms – Tata Power, BSES, Seimens, L&T, etc.","Mechanical Engg Firms – Hindustan Unilever, ACC Ltd, Voltas, etc."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly_private);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(Poly_private.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Airlines - Indigo, Spicejet, Jet Airways, etc."))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.skytest.in/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Construction Firms – Unitech, DLF, Jaypee Associated, GMR Infra, Mitas, etc"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jagranjosh.com/careers/after-polytechnic-courses-1528887111-1"));
                    startActivity(myIntent);
                }
                else if(str.equals("Communication Firms – Bharti Airtel, Reliance Communications, Idea Cellular, etc"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.collegedekho.com/articles/list-of-polytechnic-courses/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Computer Engineering Firms – TCS, HCL, Wipro, Polaris, etc"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://entrance-exam.net/forum/general-discussion/placement-papers-companies-like-tcs-wipro-cts-etc-499399.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("Automobiles – Maruti Suzuki, Toyota, TATA Motors, Mahindra, Bajaj Auto, etc."))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://economictimes.indiatimes.com/auto-companies-like-maruti-hyundai-tata-motors-toyota-and-mahindra-to-set-up-recall-code-for-defective-cars/articleshow/14397813.cms?from=mdr"));
                    startActivity(myIntent);
                }
                else if(str.equals("Electrical / Power Firms – Tata Power, BSES, Seimens, L&T, etc."))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tatapower.com/careers/fresher.aspx"));
                    startActivity(myIntent);
                }
                else if(str.equals("Mechanical Engg Firms – Hindustan Unilever, ACC Ltd, Voltas, etc."))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.careers360.com/question-job-opportunities-in-polytechnic"));
                    startActivity(myIntent);

                }
            }
        });
    }
}
