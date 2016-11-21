package com.xais.prajwal.json_parse.retrofit;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Prajwal on 2016-11-21.
 */

public class POJO implements Serializable {

    @Expose
    private String name;

    @Expose
    private String price;

    @Expose
    private String description;

    public POJO(String name, String price, String description){
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
