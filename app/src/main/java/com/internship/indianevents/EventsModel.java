package com.internship.indianevents;

public class EventsModel {
    String date,purl,text;

    public EventsModel() {
    }

    public EventsModel(String date, String purl, String text) {
        this.date = date;
        this.purl = purl;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
