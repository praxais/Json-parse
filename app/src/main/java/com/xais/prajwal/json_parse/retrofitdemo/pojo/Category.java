package com.xais.prajwal.json_parse.retrofitdemo.pojo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class Category implements Serializable {

    @Expose
    private String username;

    @Expose
    private int slots;

    @Expose
    private String booked_date;

    @Expose
    private String booked_time;

    @Expose
    private int duration;

    @Expose
    private int cost;

    public Category(String username, int slots, String booked_date, String booked_time, int duration, int cost) {
        this.setUsername(username);
        this.setSlots(slots);
        this.setBooked_date(booked_date);
        this.setBooked_time(booked_time);
        this.setDuration(duration);
        this.setCost(cost);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(String booked_date) {
        this.booked_date = booked_date;
    }

    public String getBooked_time() {
        return booked_time;
    }

    public void setBooked_time(String booked_time) {
        this.booked_time = booked_time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
