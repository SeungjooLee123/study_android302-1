package com.example.testproject02;

import java.io.Serializable;

public class VoteDTO implements Serializable {
    private String dto_writer, dto_title;

    public VoteDTO(String dto_writer, String dto_title) {
        this.dto_writer = dto_writer;
        this.dto_title = dto_title;
    }

    public String getDto_writer() {
        return dto_writer;
    }

    public void setDto_writer(String dto_writer) {
        this.dto_writer = dto_writer;
    }

    public String getDto_title() {
        return dto_title;
    }

    public void setDto_title(String dto_title) {
        this.dto_title = dto_title;
    }
}
