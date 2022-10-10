package org.deadcryd.unit_02.task_04;

import java.util.Arrays;
import org.deadcryd.unit_02.task_02.StarterPackGenerator;
import org.deadcryd.unit_02.task_02.stationery.Stationery;

public class TaskRunner {

    public static void main(String[] args) {
        print(StarterPackGenerator.generate());
        print(sortByPrice(StarterPackGenerator.generate()));
        print(sortByName(StarterPackGenerator.generate()));
        print(sortByPriceAndName(StarterPackGenerator.generate()));
    }

    public static Stationery[] sortByPrice(Stationery[] stationeries) {
        Arrays.sort(stationeries, new StationeryComparatorByPrice());
        return stationeries;
    }

    public static Stationery[] sortByName(Stationery[] stationeries) {
        Arrays.sort(stationeries, new StationeryComparatorByName());
        return stationeries;
    }

    public static Stationery[] sortByPriceAndName(Stationery[] stationeries) {
        Arrays.sort(stationeries, new StationeryComparatorByPrice()
            .thenComparing(new StationeryComparatorByName()));
        return stationeries;
    }

    public static void print(Stationery[] stationeries) {
        System.out.println(Arrays.toString(stationeries));
    }
}
