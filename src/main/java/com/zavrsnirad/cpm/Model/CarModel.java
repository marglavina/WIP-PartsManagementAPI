package com.zavrsnirad.cpm.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_Id")
    @JsonProperty("model_ID")
    private int model_ID;

    @Column(name = "model_name", unique = true)
    private String modelName;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable = false, unique = true)
    private CarBrand carBrand;

    @JsonProperty("model_ID")
    public int getID() {
        return model_ID;
    }

    public void setID(int ID) {
        this.model_ID = ID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "model_ID=" + model_ID +
                ", modelName='" + modelName + '\'' +
                ", carBrand=" + carBrand +
                '}';
    }
}
