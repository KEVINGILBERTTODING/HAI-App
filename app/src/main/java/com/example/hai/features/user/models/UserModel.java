package com.example.hai.features.user.models;

public class UserModel {

    private Integer user_id;
     private String nrp;
     private String email;
     private String name;
     private Integer bidang_id;
     private String profile_photo;
     private String role;

    public UserModel(Integer user_id, String nrp, String email, String name, Integer bidang_id, String profile_photo, String role) {
        this.user_id = user_id;
        this.nrp = nrp;
        this.email = email;
        this.name = name;
        this.bidang_id = bidang_id;
        this.profile_photo = profile_photo;
        this.role = role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBidang_id() {
        return bidang_id;
    }

    public void setBidang_id(Integer bidang_id) {
        this.bidang_id = bidang_id;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
