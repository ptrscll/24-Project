package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getMainInfo(View view){
        Intent mainHelpIntent = new Intent(this, MainInfoActivity.class);
        startActivity(mainHelpIntent);
    }
    public void goToLevels(View view){
        Intent levelMenuIntent = new Intent(this, levelMenuActivity.class);
        startActivity(levelMenuIntent);
    }
    public void goToCasualMenu(View view){
        Intent casualMenuIntent = new Intent(this, casualMenuActivity.class);
        startActivity(casualMenuIntent);
    }
}
