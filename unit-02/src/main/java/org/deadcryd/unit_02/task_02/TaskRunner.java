package org.deadcryd.unit_02.task_02;

import java.util.Arrays;
import org.deadcryd.unit_02.task_02.stationery.Stationery;

public class TaskRunner {

    public static void main(String[] args) {
        Stationery[] starterPack = StarterPackGenerator.generate();
        System.out.println(Arrays.toString(starterPack));
    }
}
