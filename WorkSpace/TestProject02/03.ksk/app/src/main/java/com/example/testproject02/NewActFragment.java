package com.example.testproject02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActFragment extends Fragment {
    Activity activity;
    EditText edit_writer, edit_title;
    Button btn_submit;

    public NewActFragment(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_new_act, container, false);
        edit_writer = viewGroup.findViewById(R.id.edit_writer);
        edit_title = viewGroup.findViewById(R.id.edit_title);

        btn_submit = viewGroup.findViewById(R.id.btn_submit);

        //투표 버튼 눌렀을 때
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String writer = edit_writer.getText().toString().replace(" ", "");
                String title = edit_title.getText().toString().replace(" ", "");
                if(writer != "" && title != ""){
                    VoteDTO dto = new VoteDTO(writer, title);
                    Intent intent = new Intent(activity, NewActivity.class);
                    intent.putExtra("writer", writer);
                    intent.putExtra("title", title);
                    intent.putExtra("dto", dto);
                    startActivity(intent);
                }else{
                    Toast.makeText(activity, "모두 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return viewGroup;
    }
}