package com.example.testproject02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainFragment extends Fragment {
    MemberDTO dto;
    private EditText con_id, con_name, con_birth;

    public MainFragment(MemberDTO dto) {
        this.dto = dto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        con_id = viewGroup.findViewById(R.id.con_id);
        con_name = viewGroup.findViewById(R.id.con_name);
        con_birth = viewGroup.findViewById(R.id.con_birth);

        con_id.setText(dto.getId());
        con_name.setText(dto.getName());
        con_birth.setText(dto.getBirth());
        return viewGroup;
    }
}