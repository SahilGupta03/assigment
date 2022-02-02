package com.sahil.myassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText email,pass,username;
    Button btnregister;
    TextView gotologin;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email=findViewById(R.id.edEmail);
        pass=findViewById(R.id.edPassword);
        username=findViewById(R.id.edName);
        btnregister=findViewById(R.id.btnRegister);
        gotologin=findViewById(R.id.gotologin);

        preferences=getSharedPreferences("UserInfo",0);


        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailvalue=email.getText().toString();
                String passvalue=pass.getText().toString();
                String usernamevalue=username.getText().toString();
                if (TextUtils.isEmpty(usernamevalue)){
                    Toast.makeText(RegistrationActivity.this, "Please Enter UserName", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(emailvalue)){
                    Toast.makeText(RegistrationActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passvalue)){
                    Toast.makeText(RegistrationActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passvalue.length()<6){
                    Toast.makeText(RegistrationActivity.this, "Password too short", Toast.LENGTH_SHORT).show();

                }
           else {


                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("username",usernamevalue);
                editor.putString("email",emailvalue);
                editor.putString("pass",passvalue);
                editor.apply();
                Toast.makeText(RegistrationActivity.this, "User Register", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                }



            }
        });
    }


}