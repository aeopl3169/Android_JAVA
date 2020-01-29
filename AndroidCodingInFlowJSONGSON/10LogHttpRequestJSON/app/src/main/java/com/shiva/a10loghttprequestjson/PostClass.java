package com.shiva.a10loghttprequestjson;

import com.google.gson.annotations.SerializedName;

public class PostClass {
    private int userId;
    private Integer id;
    @SerializedName("title")
    private String titl;
    @SerializedName("body")
    private String text;

    public PostClass(int userId, String titl, String text) {
        this.userId = userId;
        this.titl = titl;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitl() {
        return titl;
    }

    public String getText() {
        return text;
    }
}
