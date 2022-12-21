package com.zavrsnirad.cpm.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Part {

    @Id
    @Column(name = "part_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("part_ID")
    private int part_ID;

    @Column(name ="part_number", unique = true)
    private String partNumber;

    @Column(name ="manuf_date")
    private Date manufDate;

    @Column(name = "part_name")
    private String part_name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_ID")
    private CarModel carModel;

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public int getPart_ID() {
        return part_ID;
    }

    public void setPart_ID(int part_ID) {
        this.part_ID = part_ID;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
    @JsonProperty("manufacturingDate")
    public Date getManufDate() {
        return manufDate;
    }

    @JsonProperty("manufacturingDate")
    public void setManufDate(Date manufDate) {
        this.manufDate = manufDate;
    }
}
