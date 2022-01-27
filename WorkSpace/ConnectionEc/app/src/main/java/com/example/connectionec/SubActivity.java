package com.example.connectionec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SubActivity extends AppCompatActivity {
    EditText edt_data;
    Button btn_send;
    TextView tv_recv;
    ArrayList<String> params = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edt_data = findViewById(R.id.edt_data);
        btn_send = findViewById(R.id.btn_send);
        tv_recv = findViewById(R.id.tv_recv);


        //btn_send를 클릭했을때 abc.cos 라는 매핑을 요청하고 결과를 TextView에 보여주기.
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = changeInt( edt_data.getText() +"");
                if(size <= 0){
                    Toast.makeText(SubActivity.this, "잘못 입력 했습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (int i=0 ; i<size; i++){
                    params.add("pavalues"+i);
                }


                AskTask task = new AskTask("vvv.cos" );
                try {
                     task.execute().get();
                    //tv_recv.setText(data);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //excute를 실행하면 비동기 작업으로 ( Main Thread , AsynckTask는 따로 작업 )
                //서버랑 연동이 무조건 되고 나서 아래 코드가 실행되어야 할때 ( 결과가 무조건 필요할때 )

            }
        });

    }

    public int changeInt(String data){
        try{
           return Integer.parseInt(data);
        }catch (Exception e){
            return 0;
        }
    }
}