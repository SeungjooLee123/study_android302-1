package com.example.project04_lastproject.employees;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project04_lastproject.R;
import com.example.project04_lastproject.common.AskTask;
import com.example.project04_lastproject.common.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class EmployeeFragment extends Fragment {
    RecyclerView emp_rcv;
    Gson gson = new Gson();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup itemView = (ViewGroup) inflater.inflate(R.layout.fragment_employee, container, false);
        emp_rcv = itemView.findViewById(R.id.emp_rcv);
        AskTask task = new AskTask("list.hr");
        InputStream in = CommonMethod.excuteGet(task);
        List<EmployeeVO> list = gson.fromJson(new InputStreamReader(in) ,
                new TypeToken<List<EmployeeVO>>(){}.getType());
        EmployeeAdapter adapter = new EmployeeAdapter(list,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );
        emp_rcv.setAdapter(adapter);
        emp_rcv.setLayoutManager(manager);
        //1.어싱크 이용해서 List(목록데이터 먼저 가져오기 )
        //2.Adapter , 2.emp_item.xml , 2.전체목록 조회하기.
        return itemView ;
    }
}