package com.edge.examfinder;

public class mathRecyclerView {
    private String image;
    private String text;
    private String count;


    public mathRecyclerView(String image, String text,String count) {
        this.image = image;
        this.text = text;
        this.count=count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



}
