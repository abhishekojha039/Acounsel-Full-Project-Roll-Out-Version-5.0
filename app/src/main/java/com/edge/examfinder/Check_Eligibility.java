package com.edge.examfinder;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Check_Eligibility extends AppCompatActivity {
    Spinner spinner1,spinner2,spinner3;
    String str="";
    ArrayAdapter adapter1,adapter2,adapter3;
    Button submit;
    DatabaseReference myref;
    String uid;
    String stream,post;
    int a1=0;
    FirebaseDatabase rootNode;
    DatabaseReference databaseReference;

    String nm[]={"Maths","Commerce","Arts","Biology"};
    String stream1[]={"UNDER-GRADUATE-COURSES","POST-GRADUATE-COURSES","PHD-COURSES"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__eligibility);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        submit = findViewById(R.id.submit);
        myref= FirebaseDatabase.getInstance().getReference();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);



        ArrayAdapter adapter = new ArrayAdapter(Check_Eligibility.this, android.R.layout.simple_expandable_list_item_1, nm);
        ArrayAdapter adapter1 = new ArrayAdapter(Check_Eligibility.this, android.R.layout.simple_expandable_list_item_1,stream1);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stream=""+nm[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(Check_Eligibility.this, ""+nm[position],Toast.LENGTH_SHORT).show();
                post=""+stream1[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {

                 uid = profile.getUid();

               // Toast.makeText(this, ""+uid+profile.getDisplayName(), Toast.LENGTH_SHORT).show();




                // Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();
            }
            myref.child(uid).removeValue();

        spinner2.setAdapter(adapter1);
        spinner1.setAdapter(adapter);


     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             myref.child(uid).child("Stream").push().setValue(stream);
             myref.child(uid).child("Course").push().setValue(post);
             startActivity(new Intent(Check_Eligibility.this,MainActivity.class));
         }
     });
    }
}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        myref.child(uid).child("Stream").push().setValue(stream);
        myref.child(uid).child("Course").push().setValue(post);
        startActivity(new Intent(Check_Eligibility.this,MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myref.child(uid).child("Stream").push().setValue(stream);
        myref.child(uid).child("Course").push().setValue(post);
        startActivity(new Intent(Check_Eligibility.this,MainActivity.class));
    }
}
