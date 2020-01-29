package com.shiva.a14recycleviewjsonparsingfrompixabayapi;

public class SingleItemCartView {
    private String creator;
    private String imageUrl;
    private int likes;

    public SingleItemCartView(String creator, String imageUrl, int likes) {
        this.creator = creator;
        this.imageUrl = imageUrl;
        this.likes = likes;
    }

    public String getCreator() {
        return creator;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getLikes() {
        return likes;
    }
}
