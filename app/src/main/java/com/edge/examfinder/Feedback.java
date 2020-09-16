package com.edge.examfinder;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Feedback extends AppCompatActivity {

    EditText text,text1,text2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        text=findViewById(R.id.login_emailid);
        text1=findViewById(R.id.login_name);
        text2=findViewById(R.id.txtvw1);
        btn=findViewById(R.id.loginBtn);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                text1.setText("");
                text2.setText("");
                Toast.makeText(Feedback.this, "Feedback Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
