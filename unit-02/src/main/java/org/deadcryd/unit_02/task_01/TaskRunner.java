package org.deadcryd.unit_02.task_01;

import java.util.List;

public class TaskRunner {

    public static void main(String[] args) {
        List<Stationery> stationeryList = List.of(
            new Stationery("Notebook", 50),
            new Stationery("Pen", 22.5),
            new Stationery("Eraser", 10.5),
            new Stationery("Pencil", 24)
        );
        Employee employee = new Employee("Max");
        employee.setStationeryList(stationeryList);

        var cost = calculateCostStationery(employee);
        System.out.println("Cost stationery for " +
                               employee.getName() + " is " + cost);
    }

    public static double calculateCostStationery(Employee employee) {
        if (employee == null || employee.getStationeryList() == null) {
            return 0;
        }

        double costStationery = 0;
        for (var stationery : employee.getStationeryList()) {
            costStationery += stationery.getCost();
        }

        return costStationery;
    }
}
