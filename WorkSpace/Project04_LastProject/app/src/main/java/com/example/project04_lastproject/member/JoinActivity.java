package com.example.project04_lastproject.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.project04_lastproject.R;

public class JoinActivity extends AppCompatActivity {
    ImageView img_profile;
    EditText edt_id , edt_name , edt_pw ;
    RadioButton rdo_man , rdo_woman;
    Button btn_join , btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");


        img_profile = findViewById(R.id.img_profile);
        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_pw = findViewById(R.id.edt_pw);
        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_woman);
        btn_join = findViewById(R.id.btn_join);
        btn_cancel = findViewById(R.id.btn_cancel);

        if (email != null){
            edt_id.setText(email);
            edt_id.setEnabled(false);
        }




    }
}