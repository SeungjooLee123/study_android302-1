package com.example.project03_rycyclerpager.viewglide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.example.project03_rycyclerpager.R;
import com.example.project03_rycyclerpager.common.AskTask;
import com.example.project03_rycyclerpager.viewpagerdb.PagerDbAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GlidePagerActivity extends AppCompatActivity {
    // 위젯을 xml에 추가 => 반드시 find
    ViewPager2 pager2;
    DotsIndicator indicator;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_pager);

        pager2 = findViewById(R.id.pager2);
        indicator = findViewById(R.id.dots_indicator);

        // Viewpager2에 Adapter 만들기 ( ImageView 하나만 있으면 됨 .xml )
        //      == extends RecyclerView.Adapter<VH> ( Nasted Class ViewHolder 만들기 )

        //      == count이용해서 10개 넣어보고 모양 나오는지 먼저 보기.
        //      == ArrayList<E> 만들어서 넣어보고 모양 나오는지 먼저 보기.
        //      == 미들웨어에서 디비에 있는 데이터를 넣어서 가지고와서 보기.
        // Viewpager2에 Adapter 연결 하기.

        // indicator viewpaer2에 연결 하기.
        ArrayList<AndImgDTO> list = null ;
        // ====== Adapter에서 Glide이용해서 이미지 각각 다르게 보이게 하기.
        AskTask task = new AskTask("daf.amg");
        try {
            InputStream in = task.execute().get();
            if(in != null){
                list = gson.fromJson(
                        new InputStreamReader(in),
                        new TypeToken<List<AndImgDTO>>(){}.getType()
                );

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        GlidePagerAdapter adapter = new GlidePagerAdapter(inflater );
        pager2.setAdapter(adapter);
        indicator.setViewPager2(pager2);

    }
}