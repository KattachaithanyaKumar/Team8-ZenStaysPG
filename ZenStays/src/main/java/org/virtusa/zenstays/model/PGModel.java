package org.virtusa.zenstays.model;

public class PGModel {
    private int pgId;
    private String name;
    private String city;
    private String address;
    private String type;
    private boolean status;
    private float rating;
    private String imgUrl;

    public PGModel() {
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
