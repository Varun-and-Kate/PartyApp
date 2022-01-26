package com.example.partyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login_page extends AppCompatActivity {
    EditText username_input;
    TextView textName;
    private Button loginButton;
    private Button forgotPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        loginButton = (Button) findViewById(R.id.loginButton);
        forgotPasswordButton = (Button) findViewById(R.id.resetbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPartyList();
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
}