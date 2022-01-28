package com.example.testproject02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edit_id, edit_pw;
    Button btn_login, btn_join;
    CheckBox checkBox;
    String id, pw, name, birth;
    Intent intent;
    MemberDTO dto ;
    MemberDTO adminDto = new MemberDTO("admin", "admin", "관리자","없음");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_id = findViewById(R.id.edit_id);
        edit_pw = findViewById(R.id.edit_pw);

        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);

        checkBox = findViewById(R.id.checkbox);


        //회원가입에서 넘어온 id와 pw 처리
        intent = getIntent();
        if(intent.getSerializableExtra("dto") != null){
            dto = (MemberDTO) intent.getSerializableExtra("dto");
            id = dto.getId();
            pw = dto.getPw();
            name = dto.getName();
            birth = dto.getBirth();
            edit_id.setText(id);
            edit_pw.setText(pw);
            checkBox.setChecked(true);
        };

        //로그인 처리
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edit_id.getText().toString().replace(" ", "");
                pw = edit_pw.getText().toString().replace(" ", "");;
                if(id.equals("")&& pw.equals("")){
                    Toast.makeText(getApplicationContext(), "모두 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // && ||
                // and or
                // 모든 조건 , 하나만
                //

                    if( (adminDto.getId().equals("Admin") && adminDto.getPw().equals("Admin")) ||
                            dto != null && id.equals(dto.getId()) && pw.equals(dto.getPw())
                    ){

                        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                        intent = new Intent(LoginActivity.this, ContentActivity.class);
                        intent.putExtra("dto", dto);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "회원가입을 해주세요", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        //회원가입 화면으로 이동
        btn_join = findViewById(R.id.btn_join);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });


    }
}