package com.example.project04_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id, edt_pw;
    Button btn_login, btn_join;
    CheckBox chk_auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);
        chk_auto = findViewById(R.id.chk_auto);

        SharedPreferences preferences = getPreferences(LoginActivity.MODE_PRIVATE);
        String id = preferences.getString("id","--");
        String pw = preferences.getString("pw","--");
        Boolean isLogin = preferences.getBoolean("autologin" , false);
        chk_auto.setChecked(isLogin); // 자동로그인을 체크하고나서 앱을 종료해도 그대로 저장된상태를 보여줌.


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edt_id.getText() + "";
                String pw = edt_pw.getText() + "";
                if (id.equals("aaa") && pw.equals("bbbb")) {
                    saveLoginInfo();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "아이디나 비밀번호를 확인바랍니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        if(isLogin){
            edt_id.setText(id);
            edt_pw.setText(pw);
            btn_login.callOnClick(); // OnClick을 강제로 실행함.
        }
    } // onCreate

    public void saveLoginInfo() {
        //체크박스 자동로그인이 체크가 된 상태라면 임시 데이터를 저장함 ( 로그인 정보를 )
        try {
            SharedPreferences preferences  = getPreferences(LoginActivity.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            if (chk_auto.isChecked()) { //로그인 정보를 저장함.
                editor.putBoolean("autologin" , true);
                editor.putString("id", edt_id.getText() + "");
                editor.putString("pw", edt_pw.getText() + "");
            } else {  // 로그인 정보를 삭제함.
                editor.remove("autologin");
                editor.remove("id");
                editor.remove("pw");
                //editor.clear();
            }
            editor.apply();
        } catch (Exception e) {
            Toast.makeText(LoginActivity.this, "자동로그인 정보 저장 실패.", Toast.LENGTH_SHORT).show();
        }
    }

}