package com.sahil.myassigment;

public class User {
    String name,prize;
    int imageId;

    public User() {
    }

    public User(String name, String prize, int imageId) {
        this.name = name;
        this.prize = prize;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
