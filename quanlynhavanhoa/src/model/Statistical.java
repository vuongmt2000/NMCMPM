/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Statistical {
    public Statistical() {
        
    }

    public Statistical(Integer id, String name, Integer quantity, String unit, int status, String comment) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.status = status;
        this.comment = comment;
    }
        private Integer id;
        private String name;
        private Integer quantity;
        private String unit;
        private int status;
        private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
        
}
