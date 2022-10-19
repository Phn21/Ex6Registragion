package com.example.ex6registragion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView userNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        userNum = findViewById(R.id.userNumber);

        String userNumber = getIntent().getStringExtra("UserMobile");

        userNum.setText(userNumber);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void logOut(MenuItem item) {
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);
    }
}