package com.example.project04_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project04_lastproject.common.AskTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AskTask askTask = new AskTask("aaa.te");
        askTask.execute();
    }
}