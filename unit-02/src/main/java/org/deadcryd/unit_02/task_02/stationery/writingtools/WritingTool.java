package org.deadcryd.unit_02.task_02.stationery.writingtools;

import java.util.StringJoiner;
import org.deadcryd.unit_02.task_02.stationery.Stationery;

public abstract class WritingTool extends Stationery {

    protected WritingTool(String name, Integer price) {
        super(name);
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WritingTool.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("price=" + price)
            .toString();
    }
}
