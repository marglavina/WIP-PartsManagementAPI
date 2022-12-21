package com.zavrsnirad.cpm.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    @JsonProperty("brand_ID")
    private int brand_ID;

    private String brandName;

    @JsonProperty("brand_ID")
    public int getID() {
        return brand_ID;
    }

    public void setID(int ID) {
        this.brand_ID = ID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "brand_ID=" + brand_ID +
                ", brandName='" + brandName +
                '}';
    }
}
