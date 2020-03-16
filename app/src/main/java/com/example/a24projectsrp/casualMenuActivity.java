package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class casualMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casual_menu);
    }
    public void goToEasyMode(View view){
        Intent easyModeIntent = new Intent(this, easyModeActivity.class);
        startActivity(easyModeIntent);
    }
    public void goToBasicGame(View view){
        Intent basicGameIntent = new Intent(this, basicGameActivity.class);
        startActivity(basicGameIntent);
    }
    public void goToHardMode(View view){
        Intent hardModeIntent = new Intent(this, hardModeActivity.class);
        startActivity(hardModeIntent);
    }
}
