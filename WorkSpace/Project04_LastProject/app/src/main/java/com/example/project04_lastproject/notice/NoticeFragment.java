package com.example.project04_lastproject.notice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.project04_lastproject.R;
import com.example.project04_lastproject.common.AskTask;
import com.example.project04_lastproject.common.CommonMethod;
import com.example.project04_lastproject.employees.EmployeeAdapter;
import com.example.project04_lastproject.employees.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NoticeFragment extends Fragment {
    ExpandableListView noti_expd;
    ArrayList<GroupDTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup itemView = (ViewGroup) inflater.inflate(R.layout.fragment_notice, container, false);
        noti_expd = itemView.findViewById(R.id.noti_expd);
        for (int i = 0 ; i<10 ; i ++ ){
            ArrayList<SubDTO> listsub = new ArrayList<>();
            for( int j = 0 ; j<i ; j++){
                listsub.add(new SubDTO("자식 글 제목 " , "자식 글 내용"));
            }
            list.add(new GroupDTO("글 제목 " + i , "글 내용 " + i , listsub));
        }
        ExpdAdapter adapter = new ExpdAdapter(list,inflater);
        noti_expd.setAdapter(adapter);
        return itemView;
    }
}