package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class basicGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_game);
        Intent baseGameIntent = getIntent();
        Random rand = new Random();
        Button num1 = (Button)findViewById(R.id.btnNum1);
        num1.setText(Integer.toString(rand.nextInt(13) + 1));
        Button num2 = (Button)findViewById(R.id.btnNum2);
        num2.setText(Integer.toString(rand.nextInt(13) + 1));
        Button num3 = (Button)findViewById(R.id.btnNum3);
        num3.setText(Integer.toString(rand.nextInt(13) + 1));
        Button num4 = (Button)findViewById(R.id.btnNum4);
        num4.setText(Integer.toString(rand.nextInt(13) + 1));
    }
}
