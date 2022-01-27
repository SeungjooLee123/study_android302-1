package com.example.testproject02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContentActivity extends AppCompatActivity {
    BottomNavigationView nav_btm;
    Fragment fragment;
    Intent intent;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        nav_btm = findViewById(R.id.nav_btm);

        //메인프래그먼트 보여주기
        intent = getIntent();
        MemberDTO dto = (MemberDTO) intent.getSerializableExtra("dto");
        fragment = new MainFragment(dto);
        changeFragment(fragment);

        //액션바
        actionBar = getSupportActionBar();
        actionBar.setTitle("프래그먼트 메인");

        //내비게이션 눌렀을 때 프래그먼트 체인지
        nav_btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){
                    actionBar.setTitle("프래그먼트 메인");
                    fragment = new MainFragment(dto);
                    changeFragment(fragment);
                }else if(item.getItemId() == R.id.tab2){
                    actionBar.setTitle("프래그먼트 리스트");
                    fragment = new ListFragment();
                    changeFragment(fragment);
                }else if(item.getItemId() == R.id.tab3){
                    actionBar.setTitle("새로운 액티비티 띄우기");
                    fragment = new NewActFragment(ContentActivity.this);
                    changeFragment(fragment);
                }
                return true;
            }
        });
    }

    //프래그먼트 붙이는 메소드
    public void changeFragment(Fragment f){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
    }
}