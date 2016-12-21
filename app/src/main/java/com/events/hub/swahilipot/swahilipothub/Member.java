package com.events.hub.swahilipot.swahilipothub;

/**
 * Created by Kevin Barassa on 01-Dec-16.
 */

import java.util.ArrayList;

public class Member {
    private String name, avatar,reg;
    private int bounties;
    private ArrayList<String> genre;

    public Member() {
    }

    public Member(String name, String avatar, int bounties, String reg,
                  ArrayList<String> genre) {
        this.name = name;
        this.avatar = avatar;
        this.bounties = bounties;
        this.reg = reg;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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