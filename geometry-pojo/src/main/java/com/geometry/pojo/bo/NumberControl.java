package com.geometry.pojo.bo;

import java.io.Serializable;
import java.math.BigDecimal;

public class NumberControl implements Serializable {

    private static final long serialVersionUID = -4079422659227556311L;
    private BigDecimal id;
    private String itemcode;
    private String itemname;
    private int numlength;
    private String numrule;
    private int autofill;
    private String prefixion;
    private int maximum;

    public NumberControl() {
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getItemcode() {
        return this.itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return this.itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getNumlength() {
        return this.numlength;
    }

    public void setNumlength(int numlength) {
        this.numlength = numlength;
    }

    public String getNumrule() {
        return this.numrule;
    }

    public void setNumrule(String numrule) {
        this.numrule = numrule;
    }

    public int getAutofill() {
        return this.autofill;
    }

    public void setAutofill(int autofill) {
        this.autofill = autofill;
    }

    public String getPrefixion() {
        return this.prefixion;
    }

    public void setPrefixion(String prefixion) {
        this.prefixion = prefixion;
    }

    public int getMaximum() {
        return this.maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "NumberControl{" +
                "id=" + id +
                ", itemcode='" + itemcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", numlength=" + numlength +
                ", numrule='" + numrule + '\'' +
                ", autofill=" + autofill +
                ", prefixion='" + prefixion + '\'' +
                ", maximum=" + maximum +
                '}';
    }
}