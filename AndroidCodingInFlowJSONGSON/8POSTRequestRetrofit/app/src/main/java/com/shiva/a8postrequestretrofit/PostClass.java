package com.shiva.a8postrequestretrofit;

public class PostClass {
    private int userId;
    private Integer id;
    private String title;
    private String body;


    public PostClass(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
