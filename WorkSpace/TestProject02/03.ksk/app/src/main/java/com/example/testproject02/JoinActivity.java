package com.example.testproject02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {
    EditText edit_joinId, edit_joinPw, edit_joinName, edit_joinBirth;
    Button btn_submit, btn_reset;
    String joinId, joinPw, joinName, joinBirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        edit_joinId = findViewById(R.id.edit_joinId);
        edit_joinPw = findViewById(R.id.edit_joinPw);
        edit_joinName = findViewById(R.id.edit_joinName);
        edit_joinBirth = findViewById(R.id.edit_joinBirth);

        btn_submit = findViewById(R.id.btn_submit);
        btn_reset = findViewById(R.id.btn_reset);

        //submit 버튼 눌렀을 때 입력받은 id, pw값 넘겨주기
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinId = edit_joinId.getText().toString().replace(" ", "");
                joinPw = edit_joinPw.getText().toString().replace(" ", "");
                joinName = edit_joinName.getText().toString().replace(" ", "");
                joinBirth = edit_joinBirth.getText().toString().replace(" ", "");
                if(!joinId.equals("") && !joinPw.equals("") && !joinName.equals("") && !joinBirth.equals("")){
                    if(joinId.equals("Admin")){
                        Toast.makeText(getApplicationContext(), "이미 가입된 회원입니다.", Toast.LENGTH_SHORT).show();
                        edit_joinId.setText("");
                        edit_joinPw.setText("");
                    }else{
                        //Toast.makeText(getApplicationContext(), "회원 가입 성공!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                        MemberDTO dto = new MemberDTO(joinId, joinPw, joinName, joinBirth);
                        intent.putExtra("dto", dto);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "모두 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //reset 버튼 누르면 메인 페이지로 이동
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}