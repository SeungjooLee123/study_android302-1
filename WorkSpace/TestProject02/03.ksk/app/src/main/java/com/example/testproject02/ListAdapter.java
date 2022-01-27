package com.example.testproject02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context context;
    ArrayList<ListDTO> list;
    LayoutInflater inflater;

    public ListAdapter(Context context, ArrayList<ListDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        listViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new listViewHolder();
            viewHolder.imgv1 = convertView.findViewById(R.id.list_imgv1);
            viewHolder.imgv2 = convertView.findViewById(R.id.list_imgv2);
            viewHolder.tv1 = convertView.findViewById(R.id.list_tv1);
            viewHolder.tv2 = convertView.findViewById(R.id.list_tv2);
            viewHolder.tv3 = convertView.findViewById(R.id.list_tv3);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (listViewHolder) convertView.getTag();
        }

        viewHolder.imgv1.setImageResource(list.get(position).getImgv1());
        viewHolder.imgv2.setImageResource(list.get(position).getImgv2());
        viewHolder.tv1.setText(list.get(position).getTv1());
        viewHolder.tv2.setText(list.get(position).getTv2());
        viewHolder.tv3.setText(list.get(position).getTv3());

        return convertView;
    }

    //뷰홀더
    public class listViewHolder{
        public ImageView imgv1, imgv2;
        public TextView tv1, tv2, tv3;
    }
}
