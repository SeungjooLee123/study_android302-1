package com.example.connectionec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class JoinActivity extends AppCompatActivity {
    EditText edt_id , edt_pw , edt_name , edt_addr;
    Button btn_join , btn_cancel ;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_name = findViewById(R.id.edt_name);
        edt_addr = findViewById(R.id.edt_addr);

        btn_join = findViewById(R.id.btn_join);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemberDTO dto = new MemberDTO(
                        Integer.parseInt(edt_id.getText()+""),
                        edt_pw.getText()+"",
                        edt_name.getText()+"",
                        edt_addr.getText()+""
                );

                String json = gson.toJson(dto);
                Toast.makeText(JoinActivity.this    , json, Toast.LENGTH_SHORT).show();
                AskTask task = new AskTask("aaaa.cos" );
                task.addParam("dto",json);
                try {
                   InputStream in = task.execute().get();
                   MemberDTO dtoRecv = gson.fromJson(new InputStreamReader(in) , MemberDTO.class);
                   Toast.makeText(JoinActivity.this, dtoRecv.getAddr(), Toast.LENGTH_SHORT).show();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}