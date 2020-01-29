package com.shiva.a9putpatchdeleteretrofit;

import com.google.gson.annotations.SerializedName;

public class PostClass {
    private int userId;
    private Integer id;
    private String title;
    @SerializedName("body")
    private String text;

    public PostClass(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}