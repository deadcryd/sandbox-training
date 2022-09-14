package org.deadcryd.unit_01.task_05;

public class TaskRunner {

    public static void main(String[] args) {
        Notepad notepad = new Notepad(5);

        notepad.addRecord(new RecordForNotepad("1"));
        notepad.addRecord(new RecordForNotepad("2"));
        notepad.addRecord(new RecordForNotepad("3"));
        notepad.addRecord(new RecordForNotepad("4"));
        notepad.addRecord(new RecordForNotepad("5"));
        notepad.addRecord(new RecordForNotepad("6"));

        notepad.editRecord(2, "New");

        System.out.print(notepad);
        System.out.println();
    }
}
