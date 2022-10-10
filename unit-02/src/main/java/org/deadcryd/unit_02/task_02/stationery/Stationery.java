package org.deadcryd.unit_02.task_02.stationery;

public abstract class Stationery {

    protected String name;
    protected int price;

    protected Stationery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
