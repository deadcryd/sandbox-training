package org.deadcryd.unit_03;

import static org.assertj.core.api.Assertions.assertThat;

import org.deadcryd.unit_01.task_05.Notepad;
import org.deadcryd.unit_01.task_05.RecordForNotepad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotepadTest {

    private Notepad notepad;
    private RecordForNotepad record;

    @BeforeEach
    void init() {
        notepad = new Notepad(1);
        record = new RecordForNotepad("TEST_DATA");
    }

    @Test
    @DisplayName("В пустом блокноте нет записей")
    void recordsNotepadHasNoEntries() {
        notepad = new Notepad(0);

        assertThat(notepad.getRecords()).isEmpty();
    }

    @Test
    @DisplayName("Записи в чистом блокноте = null")
    void recordsInBlankNotepadIsNull() {
        notepad = new Notepad(1);
        RecordForNotepad[] records = notepad.getRecords();

        Assertions.assertAll(
            () -> assertThat(records).hasSize(1),
            () -> assertThat(records[0]).isNull()
        );
    }

    @Test
    @DisplayName("Если блокноте нет места запись не будет добавлена")
    void noSpaceInNotebookRecordWillNotNeAdded() {
        notepad = new Notepad(0);
        int indexBeforeAdding = notepad.getLastRecordIndex();

        notepad.addRecord(record);

        assertThat(notepad.getLastRecordIndex()).isEqualTo(indexBeforeAdding);
    }

    @Test
    @DisplayName("Новую запись можно найти по последнему индексу")
    void newRecordCanBeFoundByLastIndex() {
        notepad = new Notepad(1);
        notepad.addRecord(record);

        RecordForNotepad actualRecord = notepad.getRecords()[notepad.getLastRecordIndex()];

        assertThat(actualRecord).isEqualTo(record);
    }

    @Test
    @DisplayName("Изменение записи")
    void changingRecord() {
        notepad = new Notepad(1);
        notepad.addRecord(record);
        String newValue = "NEW_VALUE";

        notepad.editRecord(notepad.getLastRecordIndex(), newValue);
        RecordForNotepad actualRecord = notepad.getRecords()[notepad.getLastRecordIndex()];

        assertThat(actualRecord.getValue()).isEqualTo(newValue);
    }
}
