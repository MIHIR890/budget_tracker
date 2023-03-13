package com.example.budgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText etuname, etpswd , etrepwd;
    Button signupbtn , signinbtn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etuname = findViewById(R.id.etuname);
        etpswd = findViewById(R.id.etpswd);
        etrepwd = findViewById(R.id.etrepwd);
        signupbtn = findViewById(R.id.signupbtn);
        signinbtn = findViewById(R.id.signinbtn);
        DB = new DBHelper(this);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etuname.getText().toString();
                String pass = etpswd.getText().toString();
                String repass = etrepwd.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SignUpActivity.this,"Please fill all feilds",Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean insert = DB.insertData(user,pass);
                        if(insert==true){
                            Toast.makeText(SignUpActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();

                        }

                    }
                }

            }
        });

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this , MainActivity.class);
                startActivity(intent);

            }
        });
    }
}