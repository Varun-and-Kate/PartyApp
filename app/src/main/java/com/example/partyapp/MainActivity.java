package com.example.partyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.main_loading);

        RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.mainlayout);
        rlayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                open_login_page1();
            }

        });
    }

    public void open_login_page1() {
        Intent intent = new Intent(this, login_page.class);
        startActivity(intent);

    }
}