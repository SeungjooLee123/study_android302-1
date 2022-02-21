package com.example.project04_lastproject.notice;

import java.util.ArrayList;

public class GroupDTO {
    private  String title  , content;
    private ArrayList<SubDTO> subList ;

    public GroupDTO(String title, String content, ArrayList<SubDTO> subList) {
        this.title = title;
        this.content = content;
        this.subList = subList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<SubDTO> getSubList() {
        return subList;
    }

    public void setSubList(ArrayList<SubDTO> subList) {
        this.subList = subList;
    }
}
