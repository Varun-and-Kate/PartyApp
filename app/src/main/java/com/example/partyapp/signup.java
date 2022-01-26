package com.example.partyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class signup extends AppCompatActivity {
    private Button button;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        back = (ImageButton) findViewById(R.id.backarrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_login_page2();
            }
        });

        button = (Button) findViewById(R.id.signup_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_login_page2();
            }
        });
    }

    public void open_login_page2(){
        Intent intent = new Intent(this, login_page.class);
        startActivity(intent);
    }
}