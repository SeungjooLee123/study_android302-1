package com.example.connectionec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//1.Manifest 확인 ( clearTrafic , Permission , Lib.. 등) <- 기존에 되었던 소스가있으면 복붙.
    // Permission ( 사용 권한을 부여 받는 것 ,별도로 코드가 필요한경우가있고 아닌경우가있음)
    // (ex . 인터넷은 그냥 Manifest에 기재만해도 사용이가능. 카메라,저장소 등은 사용자 동의)
    // clearTraffic = http , https 로 요청을 할수있게 처리.
//2.Gradle . (라이브러리 추가) -> sync now 통해서 연결해주기.
//3.※ AskTask를 사용해서 Eclipse까지 접근 ( WAS ) Mapping을 통해서.!
// service <- 비동기 처리 . ( 메인쓰레드 액티비티 ) <- 멈추지 않고 어떤 동작을 하기 위해서.
  TextView tv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_data = findViewById(R.id.tv_data);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edt_mapping);

                AskTask task = new AskTask(editText.getText() + ".cos" );
                task.execute();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setText(String data){

        tv_data.setText(data);
    }
}