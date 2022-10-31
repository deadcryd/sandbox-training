package org.deadcryd.unit_01.task_05;

/**
 * @author mak.astakhov
 * @version 1.0
 * */
public class Notepad {

    private final RecordForNotepad[] records;

    private int lastRecordIndex;

    public Notepad(int notepadSize) {
        this.records = new RecordForNotepad[notepadSize];
        this.lastRecordIndex = -1;
    }

    /**
     * @param record вставляемая запись
     * */
    public void addRecord(RecordForNotepad record) {
        if (lastRecordIndex + 1 >= records.length) {
            return;
        }
        records[++lastRecordIndex] = record;
    }

    /**
     * @param recordIndex позиция редактируемой записи в блокноте
     * @param value новое значение для записи
     * */
    public void editRecord(int recordIndex, String value) {
        if (recordIndex < 0 || recordIndex > lastRecordIndex) {
            return;
        }
        records[recordIndex].setValue(value);
    }

    /**
     * @return содержимое блокнота
     * */
    public RecordForNotepad[] getRecords() {
        return records;
    }

    /**
     * @return индекс последней записи в блокноте
     * */
    public int getLastRecordIndex() {
        return lastRecordIndex;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("notepad : [\n");
        for (int i = 0; i <= lastRecordIndex; i++) {
            builder
                .append(String.format(" %d : ", i))
                .append(String.format("\"%s\"%n", records[i]));
        }
        builder.append("]");

        return builder.toString();
    }
}
