package com.example.darazreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darazreplica.bll.LoginBll;
import com.example.darazreplica.strictmode.StrictModeClass;

public class loginActivity extends AppCompatActivity {
    private EditText Email, Password;
    private Button btnLogin;
    private TextView tvCreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvCreateAccount=findViewById(R.id.tvCreateAccount);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        btnLogin=findViewById(R.id.btnLogin);

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login(){
        String email=Email.getText().toString();
        String password =Password.getText().toString();

        LoginBll loginBll =new LoginBll();

        StrictModeClass.StrictMode();
        if (loginBll.checkUser(email, password) == true) {
            Toast.makeText(this, "login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(loginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (loginBll.checkUser(email, password) == false){
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            Email.requestFocus();
        }
    }
}
