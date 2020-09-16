package com.edge.examfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private Button btnLogin;
    private TextView signUp;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);

        btnLogin=findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        mDialog=new ProgressDialog(this);
        signUp=findViewById(R.id.signup);


        btnLogin.setOnClickListener(new View.OnClickListener() {
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
                mAuth.signInWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                          //  Toast.makeText(login.this, "Successful", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                        else
                        {
                           // Toast.makeText(login.this, "Failed..", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                    }
                });
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signup.class));
            }
        });
    }
}
