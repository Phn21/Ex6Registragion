package com.example.ex6registragion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    EditText number1, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        number1 = findViewById(R.id.mobileEDMain);
        password1 = findViewById(R.id.passwordEDMain);


    }

    public void signIn(View view) {
        String password = dbHelper.retv(number1.getText().toString());

        if (password1.getText().toString().equals(password)){
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            intent.putExtra("UserMobile", number1.getText().toString());
            startActivity(intent);
        }else Toast.makeText(this, "Incorrect Number or Password", Toast.LENGTH_SHORT).show();
    }

    public void signUp(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}