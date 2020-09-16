package com.edge.examfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private EditText email,pass;
    private TextView signin;
    private Button btnreg;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email=findViewById(R.id.email_reg);
        mAuth=FirebaseAuth.getInstance();
        mDialog=new ProgressDialog(this);
        pass=findViewById(R.id.password_reg);
        signin=findViewById(R.id.signin_reg);
        btnreg=findViewById(R.id.login_reg);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=email.getText().toString().trim();
                String mPass=pass.getText().toString().trim();
                if(TextUtils.isEmpty(mEmail))
                {
                    email.setError("Required Field..");
                    return;
                }
                if(TextUtils.isEmpty(mPass))
                {
                    email.setError("Required Field..");
                    return;
                }
                mDialog.setMessage("Processing");
                mDialog.show();
                mAuth.createUserWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            //Toast.makeText(signup.this, "Successful", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                           // Toast.makeText(signup.this, "Failed..", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}