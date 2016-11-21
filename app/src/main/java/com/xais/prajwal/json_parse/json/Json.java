package com.xais.prajwal.json_parse.json;

/**
 * Created by Prajwal on 2016-11-20.
 */

public class Json {

    private String name;

    private String price;

    private String description;

    public Json(String name, String price, String description){
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
