package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class B_Mba extends AppCompatActivity {
 ListView lstvw;
 String nm[]={"Common Admission Test (CAT)","Common Management Admission Test (CMAT)","Xavier Aptitude Test (XAT)","The Indian Institute of Foreign Trade (IIFT)","Symbiosis National Aptitude (SNAP)","Management Aptitude Test (MAT)","Maharashtra Common Entrance Test (MH-CET)","IBSAT","ATMA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__mba);
        lstvw=findViewById(R.id.lstvw);
        ArrayAdapter adapter=new ArrayAdapter(B_Mba.this,R.layout.listview,nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=""+nm[position];
                if(str.equals("Common Admission Test (CAT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://iimcat.ac.in/per/g01/pub/756/ASM/WebPortal/1/index.html?756@@1@@1"));
                    startActivity(myIntent);
                }
                else if(str.equals("Common Management Admission Test (CMAT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://iimcat.ac.in/per/g01/pub/756/ASM/WebPortal/1/index.html?756@@1@@1"));
                    startActivity(myIntent);
                }
                else if(str.equals("Xavier Aptitude Test (XAT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.xatonline.in/per/g21/pub/2076/ASM/WebPortal/1/index.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("The Indian Institute of Foreign Trade (IIFT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tedu.iift.ac.in/iift/index.php"));
                    startActivity(myIntent);
                }
                else if(str.equals("Symbiosis National Aptitude (SNAP)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.snaptest.org/"));
                    startActivity(myIntent);
                }
                else if(str.equals("Management Aptitude Test (MAT)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aima.in/testing-services/mat/mat.html"));
                    startActivity(myIntent);
                }
                else if(str.equals("Maharashtra Common Entrance Test (MH-CET)"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cetcell.mahacet.org/"));
                    startActivity(myIntent);
                }
                else  if (str.equals("IBSAT"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/mba/ibsat-exam"));
                    startActivity(myIntent);
                }
                else if(str.equals("ATMA"))
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.atmaaims.com/?AspxAutoDetectCookieSupport=1"));
                    startActivity(myIntent);
                }
            }
        });

    }
}
