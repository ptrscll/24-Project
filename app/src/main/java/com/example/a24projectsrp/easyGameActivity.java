package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class easyGameActivity extends AppCompatActivity {
    //wrong activity, can't delete it though
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent easyGameIntent = getIntent();
    }
}
