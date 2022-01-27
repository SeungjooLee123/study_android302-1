package com.example.testproject02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {
    EditText writer, title, dto_writer, dto_title;
    Button btn_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        writer = findViewById(R.id.writer);
        title = findViewById(R.id.title);

        dto_writer = findViewById(R.id.dto_writer);
        dto_title = findViewById(R.id.dto_title);

        btn_close = findViewById(R.id.btn_close);

        //넘어온 데이터를 edit에 set 하기
        Intent intent = getIntent();
        writer.setText(intent.getStringExtra("writer"));
        title.setText(intent.getStringExtra("title"));
        VoteDTO dto = (VoteDTO) intent.getSerializableExtra("dto");
        dto_writer.setText(dto.getDto_writer());
        dto_title.setText(dto.getDto_title());

        //버튼 눌렀을 때 액티비티 종료하기
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}