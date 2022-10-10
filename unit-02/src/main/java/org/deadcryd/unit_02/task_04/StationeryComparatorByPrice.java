package org.deadcryd.unit_02.task_04;

import java.util.Comparator;
import org.deadcryd.unit_02.task_02.stationery.Stationery;

public class StationeryComparatorByPrice implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
