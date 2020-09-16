package com.edge.examfinder;

public class fiirebase {
    String stream;
    String post;
    fiirebase()
    {

    }

    public fiirebase(String stream, String post) {
        this.stream = stream;
        this.post = post;
    }

    public String getStreeam() {
        return stream;
    }

    public void setStreeam(String streeam) {
        this.stream = streeam;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
