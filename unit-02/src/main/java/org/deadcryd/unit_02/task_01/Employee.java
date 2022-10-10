package org.deadcryd.unit_02.task_01;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Employee {

    private String name;
    private List<Stationery> stationeryList;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stationery> getStationeryList() {
        return stationeryList;
    }

    public void setStationeryList(List<Stationery> stationeryList) {
        this.stationeryList = stationeryList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("stationeryList=" + stationeryList)
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
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(stationeryList,
                                                                     employee.stationeryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stationeryList);
    }
}
