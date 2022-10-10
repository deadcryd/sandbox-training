package org.deadcryd.unit_02.task_02.stationery.papertools;

import java.util.StringJoiner;
import org.deadcryd.unit_02.task_02.stationery.Stationery;

public abstract class PaperTool extends Stationery {

    protected PaperTool(String name, Integer price) {
        super(name);
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PaperTool.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("price=" + price)
            .toString();
    }
}
