package com.example.project01_background;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main:";
    Button btn_alert;
    static ProgressBar pg_bar;
    static boolean isDown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_alert = findViewById(R.id.btn_alert);
        pg_bar = findViewById(R.id.pg_bar);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ArertDialog  <= AlertDialog.Buider (만들수있는 객체로 설정을 해두고 <- 를 이용해서 만듬 )
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("안내 ");

                builder.setIcon(android.R.drawable.ic_dialog_alert);

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //예를 눌렀을때 처리
                        // 컴포넌트 끼리 데이터를 이동하거나 컴포넌트를 실행하는 객체?
                        // setter <- getter ?
                        //if(pg_bar.getProgress()==100 || pg_bar.getProgress()==0){ // 처음 실행인지를 알수있는 Frag
                        //}
                        Log.d(TAG, "onClick: " + which);
                        Intent intent = new Intent(MainActivity.this , FileDownLoadService.class);
                        intent.putExtra("key" , "작업을 시작합니다.");
                        startService(intent);
                        //1.ProgressBar객체를 다른 클래스에서 바로 ( Instence화 x )
                        //접근이 가능하게 만들면됨
                        //2.for문을 이용한 i값을 progressbar.setProgress이용해서 채워주는 처리.
                        ////3.파일 다운로드가 시작되면 다시 예를 눌러도 안되게끔 처리. ---추후
                        //pg_bar.setProgress(20);
                    }
                });

                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setMessage("Service를 이용해서 파일을 다운로드!");
                AlertDialog dialog = builder.create();// builder.create < reutrn AlertDialog
                dialog.show();
            }
        });
    }
}