package com.agroassist.agroassistant.models;

import java.util.Date;

public class Field {
    private int id;
    private String fieldNumber;
    private Integer area;
    private String crop;
    private String kind;
    private Date date;

    public Field(int id, String fieldNumber, Integer area, String crop,
                 String kind, Date date) {
        this.id = id;
        this.fieldNumber = fieldNumber;
        this.area = area;
        this.crop = crop;
        this.kind = kind;
        this.date = date;
    }

    public Field() {}

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
