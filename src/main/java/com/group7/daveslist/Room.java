package com.group7.daveslist;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String address;


    @NotNull
    private String city;

    @NotNull
    private String state;



    @NotNull
    private int price;

    private String description;

    private String cable;

    private String privBathroom;

    private String wifi;

    private String rules;

    private boolean rented;

    private String listingType = "private";

    public Room(){
    rented=false;
    }
    public Room(String a, String c, String s, int p){
        this.address = a;
        this.city = c;
        this.state = s;
        this.price = p;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isRented() {  return rented;  }

    public void setRented(boolean rented) { this.rented = rented;  }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public String getPrivBathroom() {
        return privBathroom;
    }

    public void setPrivBathroom(String privBathroom) {
        this.privBathroom = privBathroom;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }


    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }
}
