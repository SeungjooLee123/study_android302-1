package com.example.ex01_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    //onCreate라는것은 Activity가 만들어졌을때를 의미를 한다.
    //기본적으로 Activity들은 어떤 위젯을 찾거나 ( xml에 만들어놓은 디자인 ) <=> (java 객체)
    //하는 작업들 , 이벤트 ( ex 버튼을 클릭하거나 또는 사용자가 드래그 , 스크롤 등등의 기능을사용하는것)
    //들의 작업은 모두 oncreate Activity.class(.java)

    //extends AppCompatActivity라는것을 받아옴 ( spuer. < 부모클래스의 메소드를 의미함)
    //setContentView <- .java(소스코드) <-> .xml(레이아웃)
    // 디자인 단 , 자바 단을 연결 시켜주는 코드
    //R == 리소스 .layout.activity_main

    //ex) xml 디자인 -> 버튼을 추가 -> id를 부여하고 id로 찾는다.
    //web) div inputType="button" name,id
    Button btn_naver , btn_call , btn_new;//<- Member , 필드 , 전역변수
    EditText edt_input;
    //EditText edt_input = findViewById(R.id.edt_input);
    // 에러 코드 : setContentView메소드는 어떤 xml파일을 액티비티에서 사용할껀지를 의미하고 연결을 담당하는데.
    //디자인 파일과 자바파일이 연결되기전에 find를 해버리면 디자인에 있는 버튼을 찾을수가없음.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_hello = findViewById(R.id.btn_hello);
        Button btn_input = findViewById(R.id.btn_input);
        btn_naver = findViewById(R.id.btn_naver);
        btn_call = findViewById(R.id.btn_call);
        btn_new = findViewById(R.id.btn_new);
        edt_input = findViewById(R.id.edt_input);

        btn_naver.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_new.setOnClickListener(this);


        //xml에있는 버튼을 id로 찾아서 우리가 사용할 자바 객체에 담아서 초기화 시키기.
        //ex) btn <- find로 연결하고나서 이벤트 걸기. Button.Event
        //ex) btn <- 선언만하고 이벤트 걸기 .         null.Event<-앱이 종료 됨
        btn_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //실제 버튼이 클릭되었을때 이벤트 처리를 하는 부분.
                //Context <= Android는 Class마다(객체) Os에 접근할수있는 범위가 지정이 되어있음.
                //(제어권 , 서비스 이용권)
                //Toast를 만들때는 create a new Toast 붙어있는걸로 만들어야 빨리 만들수있다.
                Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();

            }
        });//<- btn_hello라는 버튼을 클릭했을때의 처리

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "눌러 보기", Toast.LENGTH_SHORT).show();
            }
        });


    }// onCreate <- 위젯을 찾고 초기화하는 모든것들은 일단 onCreate()메소드 안에서 .

    @Override
    public void onClick(View v) {
        //  각각의 버튼은 각각 다른 아이디를 가지고있다.
        // btn_naver가 눌렸을때는 네이버 눌림이라는 토스트 메시지가 나오고
        // btn_call , btn_new 가 각각 눌렸을때도 각각의 기능이 눌렸습니다. 라는 메세지가 나오게 프로그램을
        //수정해보세요. ※ implements받은 현재메소드 안에서만 작업할것.
        //v.getId () 지금 눌려진 버튼의 id를 얻어올수있음.
        if(v.getId() == R.id.btn_naver){
            Toast.makeText(MainActivity.this, "네이버 버튼 눌러짐.", Toast.LENGTH_SHORT).show();
            //암시적 인텐트 ( Os에 있는 기능에 액션이라는(기능) 것을 지정해서 동작을 하게 만드는것 )
            //개발자가 모든 제어권을 가진 아닌 상태가 아니다. ( 소스코드 이외에 기능을 하는 것)
            //ex) 전화 걸기 , 인터넷 , 갤러리 . 카메라 .. 등등 .
            //인텐트를 실행하는 방법중에 하나는 startActivity(intent); <-
            Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("http://m.naver.com"));
            startActivity(intent);
        }else if(v.getId() == R.id.btn_call){
            Toast.makeText(MainActivity.this, "전화 버튼 눌러짐.", Toast.LENGTH_SHORT).show();
            String tel_num ="tel:" + edt_input.getText()+"";
            Toast.makeText(MainActivity.this, tel_num, Toast.LENGTH_SHORT).show();
            //제어권을 가지고 있지않음( 전화 서비스는 안드로이드 OS에서 제공하는 동작)
            //묵시적(암시적) 인텐트.
            Intent intent = new Intent(Intent.ACTION_DIAL ,
                        Uri.parse(tel_num)
                    );
            startActivity(intent);
        }else if(v.getId() == R.id.btn_new){
            Toast.makeText(MainActivity.this, "새창 버튼 눌러짐.", Toast.LENGTH_SHORT).show();
            //명시적 인텐트
            //제어권을 가지고 있음( 우리 소스코드 내부에 있는 액티비티로 이동 )
            //Intent( 현재 액티비티위치.this , 이동할 액티비티.class)
            Intent intent = new Intent(MainActivity.this , SubActivity.class);
            startActivity(intent);
        }
    }
}