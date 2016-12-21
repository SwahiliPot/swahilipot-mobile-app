package com.events.hub.swahilipot.swahilipothub;

/**
 * Created by Kevin Barassa on 01-Dec-16.
 */

import java.util.ArrayList;

public class Member {
    private String title, thumbnailUrl,reg;
    private int bounties;
    private ArrayList<String> genre;

    public Member() {
    }

    public Member(String name, String thumbnailUrl, int bounties, String reg,
                  ArrayList<String> genre) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.bounties = bounties;
        this.reg = reg;
        this.genre = genre;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getBounties() {
        return bounties;
    }

    public void setBounties(int bounties) {
        this.bounties = bounties;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

}