package com.example.testproject02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        listView = viewGroup.findViewById(R.id.listview);
        ArrayList<ListDTO> list = new ArrayList<>();
        for(int i=1; i<=31; i++){
            if(i%2==0){
                list.add(new ListDTO(R.drawable.ima5, R.drawable.bell_color,"제목"+i, "작가명"+i, "1월"+i+"일"));
            }else if(i%2 == 1){
                list.add(new ListDTO(R.drawable.ima5, R.drawable.bell,"제목"+i, "작가명"+i, "12월"+i+"일"));
            }
        }
        ListAdapter adapter = new ListAdapter(getContext(), list);
        listView.setAdapter(adapter);

        return viewGroup;
    }
}