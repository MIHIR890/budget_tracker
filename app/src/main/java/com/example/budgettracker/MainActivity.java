package com.example.budgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText etpid , etuid;
    Button login;
    TextView tv;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =  findViewById(R.id.tv);
        login = findViewById(R.id.login);
        etpid = findViewById(R.id.etpid);
        etuid = findViewById(R.id.etuid);
        DB = new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etuid.getText().toString();
                String pass = etpid.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this,"Please fill all feilds",Toast.LENGTH_LONG).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                        startActivity(intent);
                    }
                        else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                       }





                }

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,SignUpActivity.class);

                startActivity(intent2);
            }
        });
    }


}