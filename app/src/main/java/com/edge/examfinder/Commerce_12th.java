package com.edge.examfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class Commerce_12th extends AppCompatActivity {
    ListView lstvw;
    String[] nm = {"BA in Humanities & Social Sciences", "BA in Arts (Fine/Visual/Performing)", "Bachelor of Fine Arts (BFA)",
            "BDes in Animation", "BA LLB", "BDes in Design", "BSc in Hospitality & Travel", "BSc in Design", "BHM in Hospitality & Travel",
            "Bachelor of Journalism (BJ)", "Bachelor of Mass Media (BMM)", "BA in Hospitality & Travel", "Diploma in Education (DEd)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce_12th);
        lstvw = findViewById(R.id.lstvw);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview, nm);
        lstvw.setAdapter(adapter);
        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "" + nm[position];
                if (str.equals("BA in Humanities & Social Sciences")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-a-bachelor-of-arts-chp"));
                    startActivity(myIntent);

                }
                else if (str.equals("BA in Arts (Fine/Visual/Performing)")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/arts-fine-visual-performing-chp"));
                    startActivity(myIntent);

                }
                else if (str.equals("Bachelor of Fine Arts (BFA)")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/bfa-bachelor-of-fine-arts-chp"));
                    startActivity(myIntent);
                }
                else if (str.equals("BDes in Animation")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/animation/b-des-in-animation-chp"));
                    startActivity(myIntent);
                }
                else if (str.equals("BA LLB")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/animation/b-des-in-animation-chp"));
                    startActivity(myIntent);
                } else if (str.equals("BDes in Design")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/design/b-sc-in-design-chp"));
                    startActivity(myIntent);
                } else if (str.equals("BSc in Hospitality & Travel")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/hospitality-travel/b-sc-in-hospitality-travel-chp"));
                    startActivity(myIntent);
                }  else if (str.equals("BSc in Design")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/design/b-sc-in-design-chp"));
                    startActivity(myIntent);
                } else if (str.equals("BHM in Hospitality & Travel")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-j-m-c-bachelor-of-journalism-mass-communication-chp"));
                    startActivity(myIntent);
                } else if (str.equals("Bachelor of Journalism (BJ)")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-j-bachelor-of-journalism-chp"));
                    startActivity(myIntent);
                } else if (str.equals("Bachelor of Mass Media (BMM)")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/b-m-m-bachelor-of-mass-media-chp"));
                    startActivity(myIntent);
                }
                    else if (str.equals("BA in Hospitality & Travel")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/hospitality-travel/b-a-in-hospitality-travel-chp"));
                    startActivity(myIntent);
                }
                else if (str.equals("Diploma in Education (DEd)")) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/d-ed-diploma-in-education-chp"));
                    startActivity(myIntent);


                }








            }
        });
    }
}