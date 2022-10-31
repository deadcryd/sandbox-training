package org.deadcryd.unit_01.task_05;

public class RecordForNotepad {

    private String value;

    public RecordForNotepad(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
