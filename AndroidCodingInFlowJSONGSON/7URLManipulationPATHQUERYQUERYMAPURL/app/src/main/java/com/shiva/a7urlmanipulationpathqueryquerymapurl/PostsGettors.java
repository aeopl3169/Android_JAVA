package com.shiva.a7urlmanipulationpathqueryquerymapurl;

import com.google.gson.annotations.SerializedName;

public class PostsGettors {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
