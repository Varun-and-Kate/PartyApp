package com.example.partyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    Button button;
    ImageButton back;
    EditText username, password, repassword;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.confpassword);
        DB = new DBHelper(this);

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
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(signup.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                open_login_page2();

                            } else{
                                Toast.makeText(signup.this, "Resistration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(signup.this, "User already exists please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(signup.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void open_login_page2(){
        Intent intent = new Intent(this, login_page.class);
        startActivity(intent);
    }
}