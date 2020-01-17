package com.example.darazreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInUpActivity extends AppCompatActivity {
    Button btnSignIn,btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);

        btnSignIn=findViewById(R.id.btnSignin);
        btnCreateAccount=findViewById(R.id.btnCreateAccount);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInUpActivity.this,loginActivity.class));
            }
        });

        this.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInUpActivity.this,signupActivity.class));
            }
        });

    }
}
