package com.example.ex6registragion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText numberSignUp, passwordSignUp, passwordSignUp2;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper = new DBHelper(this);

        numberSignUp = findViewById(R.id.mobileEDSignUp);
        passwordSignUp = findViewById(R.id.passwordSignUp);
        passwordSignUp2 = findViewById(R.id.passwordSignUp2);
    }

    public void signUp2(View view) {
        ContentValues cv = new ContentValues();

        cv.put("Number", numberSignUp.getText().toString());
        cv.put("Password", passwordSignUp2.getText().toString());

        dbHelper.saveDT(cv);


        if (passwordSignUp.getText().toString().equals(passwordSignUp2.getText().toString())){


            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("UserMobile", numberSignUp.getText().toString());
            startActivity(intent);

        }else Toast.makeText(this, "Passwords Doesn't match", Toast.LENGTH_SHORT).show();

    }
}