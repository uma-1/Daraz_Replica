package com.example.darazreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.darazreplica.Url.Url;
import com.example.darazreplica.api.UserApi;
import com.example.darazreplica.model.User;
import com.example.darazreplica.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword;
    Button btnSignup;
    CheckBox checkBox;
    boolean ischecked =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignup=findViewById(R.id.btnSignup);
        checkBox=findViewById(R.id.checkbox);

        final Bundle bundle=getIntent().getExtras();

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ischecked=true;
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText().toString()))
                {
                    etName.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(etPassword.getText().toString())){
                    etPassword.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(etEmail.getText().toString())){
                    etEmail.setError("Mandatory Field");
                    return;
                }
                else if (ischecked = false){
                    checkBox.setError("Mandatory Field");
                    return;
                }

                String Name=etName.getText().toString();
                String Email=etEmail.getText().toString();
                String Password=etPassword.getText().toString();
                String Phoneno=bundle.getString("PhoneNo");
                String Sms=bundle.getString("SMS");

                User user=new User(Name,Email,Password,Sms,Phoneno);
                signUp(user);

            }
        });

    }
    private void signUp(User user){
        UserApi userAPI = Url.getInstance().create(UserApi.class);

        Call<SignUpResponse> signUpCall = userAPI.registerUser(user);

        signUpCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
