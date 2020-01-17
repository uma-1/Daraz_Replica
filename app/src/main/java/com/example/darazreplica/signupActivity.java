package com.example.darazreplica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class signupActivity extends AppCompatActivity {
    Button btnNext, btnResend;
    EditText etPhoneno, etsmsCode;
    TextView tvLogin;
    int min = 1;
    int max = 1000;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnNext = findViewById(R.id.btnNext);
        etPhoneno = findViewById(R.id.etPhoneno);
        etsmsCode = findViewById(R.id.etsmsCode);
        tvLogin = findViewById(R.id.tvLogin);
//        btnResend = findViewById(R.id.btnResend);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etPhoneno.getText().toString()))
                {
                    etPhoneno.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(etsmsCode.getText().toString())){
                    etsmsCode.setError("Mandatory Field");
                    return;
                }
                Intent intent = new Intent(signupActivity.this, RegisterActivity.class);

                String No=etPhoneno.getText().toString();
                String sms = etsmsCode.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("PhoneNo", No);
                bundle.putString("SMS", sms);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

//        btnResend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (TextUtils.isEmpty(etPhoneno.getText().toString())) {
//                    etPhoneno.setError("Mandatory Field");
//                    return;
//                }
//                Thread thread = new Thread() {
//                    @Override
//                    public void run() {
//                        try {
//                            sleep(1000);
//                            int I1 = r.nextInt(max - min + 1) + min;
//                            etsmsCode.setText(Integer.toString(I1));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                thread.start();
//            }
//        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(signupActivity.this,loginActivity.class);
            }
        });
    }
}

