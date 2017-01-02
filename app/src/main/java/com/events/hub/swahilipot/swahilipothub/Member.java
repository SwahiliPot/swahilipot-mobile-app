package com.events.hub.swahilipot.swahilipothub;

/**
 * Created by Kevin Barassa on 01-Dec-16.
 */

public class Member {
    private String name, avatar, reg, category, email, gender, status, createdAt, bio, web;
    private int bounties;

    //Member constructor
    public Member() {
    }

    public Member(String name, String avatar, int bounties, String reg,
                  String category, String email, String gender, String status,
                  String createdAt, String bio, String web) {
        this.name = name;
        this.avatar = avatar;
        this.bounties = bounties;
        this.reg = reg;
        this.category = category;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.createdAt = createdAt;
        this.bio = bio;
        this.web = web;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }


}