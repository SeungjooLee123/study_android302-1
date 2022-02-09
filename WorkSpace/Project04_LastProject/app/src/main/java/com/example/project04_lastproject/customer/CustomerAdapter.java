package com.example.project04_lastproject.customer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project04_lastproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter  extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>{

    Context context;
    LayoutInflater inflater;
    List<CustomerVO> list = new ArrayList<>();
    public CustomerAdapter(Context context, List<CustomerVO> list) {
        this.context = context; // 나중에 Intent나 화면처리 Toast 이벤트 등에서 사용하기 위해서 받아옴.
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater <- 칸마다 보여줄 데이터를 붙이기 위해서 ( Customer_Main_item.xml )
        View itemView = inflater.inflate(R.layout.customer_main_item , parent , false );
        //ViewHolder holder = ;
        return new ViewHolder(itemView);
    }

    // ↑ xml이 연결되고나서 bind 데이터 연결 부
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder , position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cus_img ;
        TextView cus_no , cus_name , cus_phone;
        Button btn_detail , btn_edit , btn_del;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cus_img =  itemView.findViewById(R.id.cus_img);
            cus_no =  itemView.findViewById(R.id.cus_no);
            cus_name =  itemView.findViewById(R.id.cus_name);
            cus_phone =  itemView.findViewById(R.id.cus_phone);
            btn_detail =  itemView.findViewById(R.id.btn_detail);
            btn_edit =  itemView.findViewById(R.id.btn_edit);
            btn_del =  itemView.findViewById(R.id.btn_del);
        }

        public void bind(ViewHolder holder, int i) {
            holder.cus_no.setText(list.get(i).getNo() + "" );
            holder.cus_name.setText(list.get(i).getName() + "" );
            holder.cus_phone.setText(list.get(i).getPhone() + "" );
            //바인딩이 되고나서 처리는 ↑onBindViewHolder 이벤트를 활용해서 처리함.
            holder.btn_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( context , CustomerActivity.class );
                    // intent 이용해서 현재 선택 된 Vo정보를 CustomerActivity에서 받아보기.
                    // 받은 정보를 log이용해서 찍거나 Toast이용해서 찍거나 .
                    //list.get(i) <= vo
                    //ArrayList<String> strs = strs.get(i) == 문자열 또는 NULL
                    //ArrayList<VO> list = list.get(i) == VO 또는 NULL
                    intent.putExtra("vo" , list.get(i) );
                    context.startActivity(intent);
                }
            });

            holder.btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( context , CustomerActivity.class );
                    intent.putExtra("vo" , list.get(i) );
                    intent.putExtra("enable" , true);
                    context.startActivity(intent);
                }
            });


        }
    }
}
