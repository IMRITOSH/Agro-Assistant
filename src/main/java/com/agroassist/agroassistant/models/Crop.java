package com.agroassist.agroassistant.models;

import java.util.Date;

public class Crop {

    private int id;
    private String fieldNumber;
    private Integer brutto;
    private Integer tara;
    private Integer netto;
    private Date date;

    public Crop(int id, String fieldNumber, Integer brutto, Integer tara, Integer netto, Date date) {
        this.id = id;
        this.fieldNumber = fieldNumber;
        this.brutto = brutto;
        this.tara = tara;
        this.netto = netto;
        this.date = date;
    }

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

    public Integer getBrutto() {
        return brutto;
    }

    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }

    public Integer getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public Integer getNetto() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto = netto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
