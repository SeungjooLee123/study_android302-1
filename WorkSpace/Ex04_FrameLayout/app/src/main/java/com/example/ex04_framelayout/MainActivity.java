package com.example.ex04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1 ;
    ArrayList<ImageView> list = new ArrayList<>();
    int index = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        list.add(  findViewById(R.id.imgv1) );
        list.add(  findViewById(R.id.imgv2) );
        list.add(  findViewById(R.id.imgv3) );

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i<list.size() ; i++){
                    list.get(i).setVisibility(View.GONE);
                }
                list.get(index).setVisibility(View.VISIBLE);
                index ++ ;
                if(list.size() <= index) index = 0;
               // if(imgv3.getVisibility() == View.VISIBLE){
               // }
               // list.get(0).setImageResource(R.drawable.img1);
                // 아이디로 이미지를 찾아서 바꿈.
                // ImageView세개를 중첩시켜놓는다는것은 리소스 낭비.

            }
        });

    }

}