package com.example.upimagemysql;

import java.net.IDN;

public class ProductValue {

    String name;
    String discription;
    String image;
    String Id;


    public ProductValue(String name, String discription, String image,String Id) {
        this.name = name;
        this.discription = discription;
        this.image = image;
        this.Id= Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}

