package org.virtusa.zenstays.model;

import java.util.ArrayList;
import java.util.List;

public class PGModel {
    private int pgId;
    private String name;
    private String city;
    private String address;
    private String type;
    private boolean status;
    private float rating;
    private String imgUrl;
    List<String> facilities = new ArrayList<>();

    public PGModel() {
        
    }

    public PGModel(int pgId, String name, String city, String address, float rating) {
        this.pgId = pgId;
        this.name = name;
        this.city = city;
        this.address = address;
        this.rating = rating;
    }

    public int getPgId() {
        return pgId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    @Override
    public String toString() {
        return "PGModel{" +
                "pgId=" + pgId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", rating=" + rating +
                ", img_url='" + imgUrl + '\'' +
                '}';
    }
}
