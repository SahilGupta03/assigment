package com.sahil.myassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,pass;
    Button btnlogin;
    TextView click;

    public static final String fileName="login";
    public static final String email1="email";
    public static final String Password="pass";


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        click=findViewById(R.id.gotoregister);


        preferences=getSharedPreferences("UserInfo",0);



//        preferences=getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        if (preferences.contains(email1)){
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

        email=findViewById(R.id.vdEmail);
        pass=findViewById(R.id.vdPassword);
        btnlogin=findViewById(R.id.btnLogin);




        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailvalue=email.getText().toString();
                String passvalue=pass.getText().toString();

                String registeremail=preferences.getString("email","");
                String registerPass=preferences.getString("pass","");
//                SharedPreferences preferences =getSharedPreferences(LoginActivity.PREFS_NAME,0);
//                boolean hasLoggedIn=preferences.getBoolean("hasLoggedIn",true);
//                if (hasLoggedIn){
//
//                    Intent intent =new Intent(LoginActivity.this,MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//                else
                if (TextUtils.isEmpty(emailvalue)){
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
               else if (TextUtils.isEmpty(passvalue)){
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }else if (emailvalue.equals(registeremail) && passvalue.equals(registerPass)){
                    Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, "LoggedIn Successfully", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });





    }
}