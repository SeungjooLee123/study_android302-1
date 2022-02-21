package com.example.project04_lastproject.notice;

public class SubDTO {
    private  String title  , content;

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

    public SubDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
