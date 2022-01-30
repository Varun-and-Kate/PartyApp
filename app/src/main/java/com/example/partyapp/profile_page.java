package com.example.partyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class profile_page extends AppCompatActivity {
    FirebaseAuth auth;
    Button btnLogout;
    TextView userName, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        btnLogout = findViewById(R.id.sign_out_btn);
        userEmail = findViewById(R.id.user_email);
        userName = findViewById(R.id.user_name);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if(account != null){

            //get user data here from google
            String name = account.getDisplayName();
            String email = account.getEmail();

            //set these data to textView
            userName.setText(name);
            userEmail.setText(email);

        }

        auth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signOut();
                startActivity(new Intent(profile_page.this, login_page.class));
                finish();
            }
        });
    }
}