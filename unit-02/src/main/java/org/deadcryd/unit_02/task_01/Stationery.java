package org.deadcryd.unit_02.task_01;

import java.util.Objects;
import java.util.StringJoiner;

public class Stationery {

    private String name;
    private double cost;

    public Stationery(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Stationery.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("cost=" + cost)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stationery that = (Stationery) o;
        return Double.compare(that.cost, cost) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
