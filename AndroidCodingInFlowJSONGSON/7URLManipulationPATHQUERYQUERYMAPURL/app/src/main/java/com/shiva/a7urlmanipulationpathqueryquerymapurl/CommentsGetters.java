package com.shiva.a7urlmanipulationpathqueryquerymapurl;

import com.google.gson.annotations.SerializedName;

public class CommentsGetters {
    @SerializedName("postId")
    private String userId;
    private int id;
    private String name;
    private String email;
    @SerializedName("body")
    private String text;

    public String getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
