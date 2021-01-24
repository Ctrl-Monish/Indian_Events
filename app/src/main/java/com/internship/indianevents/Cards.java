package com.internship.indianevents;

public class Cards {
    private String title;
    private String year;
    private int image;

    public Cards(String year, String title, int image) {
        this.year = year;
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
