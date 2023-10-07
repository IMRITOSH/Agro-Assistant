package com.agroassist.agroassistant.models;

import java.time.Year;

public class Field {
    private int id;
    private String fieldNumber;
    private int area;
    private String crop;
    private String kind;
    private Year year;

    public Field(int id, String fieldNumber, int area, String crop,
                 String kind, Year year) {
        this.id = id;
        this.fieldNumber = fieldNumber;
        this.area = area;
        this.crop = crop;
        this.kind = kind;
        this.year = year;
    }

    public Field(){}

    public int getId() {
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

    public int getArea() {
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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
