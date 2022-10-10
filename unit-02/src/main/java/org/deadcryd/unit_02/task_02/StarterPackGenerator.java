package org.deadcryd.unit_02.task_02;

import org.deadcryd.unit_02.task_02.stationery.Stationery;
import org.deadcryd.unit_02.task_02.stationery.papertools.Notebook;
import org.deadcryd.unit_02.task_02.stationery.papertools.Notepad;
import org.deadcryd.unit_02.task_02.stationery.writingtools.Pen;
import org.deadcryd.unit_02.task_02.stationery.writingtools.Pencil;

public class StarterPackGenerator {

    private StarterPackGenerator() {}

    public static Stationery[] generate() {
        Stationery[] starterPack = new Stationery[4];
        starterPack[0] = new Pen("Wow pen", 10);
        starterPack[1] = new Notebook("Notebook", 32);
        starterPack[2] = new Notepad("Simple notepad", 6);
        starterPack[3] = new Pencil("Big pencil", 345);
        return starterPack;
    }
}
