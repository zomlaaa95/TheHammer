package com.example.kiki.thehammer.model;

import java.util.Date;

/**
 * Created by Lazar on 6/4/2017.
 */

public class Bid {

    private int id;
    public double price;
    public Date dateTime;
    public Auction auction;
    public User user;

    public Bid(int id, double price, Date dateTime, Auction auction, User user) {
        this.id = id;
        this.price = price;
        this.dateTime = dateTime;
        this.auction = auction;
        this.user = user;
    }

    public Bid(int id, double price, Date dateTime, User user){
        this.id = id;
        this.price = price;
        this.dateTime = dateTime;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
