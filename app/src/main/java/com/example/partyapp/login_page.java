package com.example.partyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    EditText username, password;
    Button loginButton;
    Button signupbutton;
    Button forgotPasswordButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        username = (EditText) findViewById(R.id.username_input);
        password = (EditText) findViewById(R.id.password1);
        loginButton = (Button) findViewById(R.id.loginButton);
        signupbutton = (Button) findViewById(R.id.signupbut);
        forgotPasswordButton = (Button) findViewById(R.id.resetbutton);
        DB = new DBHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login_page.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(login_page.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        openPartyList();
                    } else {
                        Toast.makeText(login_page.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPassword();
            }
        });

    }

    public void openPartyList() {
        Intent intent = new Intent(this, party_list_page.class);
        startActivity(intent);
    }

    public void openForgotPassword() {
        Intent intent = new Intent(this, forgot_password.class);
        startActivity(intent);
    }

    public void openSignup(){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}