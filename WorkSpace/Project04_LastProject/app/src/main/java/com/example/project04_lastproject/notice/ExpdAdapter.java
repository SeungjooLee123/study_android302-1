package com.example.project04_lastproject.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.project04_lastproject.R;
import com.example.project04_lastproject.employees.EmployeeAdapter;

import java.security.acl.Group;
import java.util.ArrayList;

public class ExpdAdapter extends BaseExpandableListAdapter {
    //기존 리사이클러뷰,리스트뷰,그리드뷰 등 기본 베이스 어댑터 또는 리사이클러뷰 어댑터 x  2
     ArrayList<GroupDTO> list;
     LayoutInflater inflater;

    public ExpdAdapter(ArrayList<GroupDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override    //부모(그룹)의 갯수를 지정
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getSubList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //ArrayList(0DTO).Sublist(0). SUBDTO <= return
        return list.get(groupPosition).getSubList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override // getView <=
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder viewHolder ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.group_item , parent , false);
            viewHolder = new GroupViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (GroupViewHolder) convertView.getTag();
        }
        viewHolder.bind(viewHolder , groupPosition);
        //converView<= itemView를 만들고나서 여기에 Tag속성을 이용해서 Class를 저장 시켜둠.
        //이미 view가 만들어진 상태라면 다시 ViewHolder를 만드는게아니라 만들어진것을 재활용할수있게처리함.
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SubViewHolder viewHolder ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.child_item , parent , false);
            viewHolder = new SubViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (SubViewHolder) convertView.getTag();
        }
        viewHolder.bind(viewHolder , groupPosition , childPosition);
        //converView<= itemView를 만들고나서 여기에 Tag속성을 이용해서 Class를 저장 시켜둠.
        //이미 view가 만들어진 상태라면 다시 ViewHolder를 만드는게아니라 만들어진것을 재활용할수있게처리함.
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public class GroupViewHolder {
        TextView tv_title , tv_content;

        public GroupViewHolder(@NonNull View itemView) {
            this.tv_title = itemView.findViewById(R.id.grp_tvtitle);
            this.tv_content = itemView.findViewById(R.id.grp_tvcontent);
        }
        public void bind(@NonNull ExpdAdapter.GroupViewHolder holder, int i){
            holder.tv_content.setText(list.get(i).getContent());
            holder.tv_title.setText(list.get(i).getTitle());
        }
    }
    public class SubViewHolder {
        TextView tv_title , tv_content;

        public SubViewHolder(@NonNull View itemView) {
            this.tv_title = itemView.findViewById(R.id.sub_tvtitle);
            this.tv_content = itemView.findViewById(R.id.sub_tvcontent);
        }
        public void bind(@NonNull ExpdAdapter.SubViewHolder holder, int i , int j){
            holder.tv_content.setText(list.get(i).getSubList().get(j).getContent());
            holder.tv_title.setText(list.get(i).getSubList().get(j).getTitle());
        }
    }


}
