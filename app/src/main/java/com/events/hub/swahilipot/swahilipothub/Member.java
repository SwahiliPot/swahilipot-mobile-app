package com.events.hub.swahilipot.swahilipothub;

/**
 * Created by Kevin Barassa on 01-Dec-16.
 */

public class Member {
    private String name, avatar,reg;
    private int bounties;
    private String category;

    public Member() {
    }

    public Member(String name, String avatar, int bounties, String reg,
                  String category) {
        this.name = name;
        this.avatar = avatar;
        this.bounties = bounties;
        this.reg = reg;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}