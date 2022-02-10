package com.example.project04_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import com.example.project04_lastproject.common.AskTask;
import com.example.project04_lastproject.customer.CustomerMainFragment;
import com.example.project04_lastproject.employees.EmployeeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new EmployeeFragment()).commit();
        //AskTask askTask = new AskTask("aaa.te");
        //askTask.execute();
    }

}