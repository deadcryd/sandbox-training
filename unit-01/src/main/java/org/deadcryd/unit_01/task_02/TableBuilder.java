package org.deadcryd.unit_01.task_02;

public class TableBuilder {

    private final int columns;
    private final StringBuilder data;
    private final String rowTemplate;
    private final String lineTemplate;


    TableBuilder(int columns, int cellWidth) {
        this.columns = columns;
        this.data = new StringBuilder();
        this.rowTemplate = ("|%" + cellWidth + "s").repeat(columns) + "|\n";
        this.lineTemplate = ("+" + "-".repeat(cellWidth)).repeat(columns) + "+\n";
    }

    public TableBuilder appendRow(Object... values) {
        if (values.length != columns){
            throw new IllegalArgumentException();
        }

        String row = String.format(rowTemplate, values);
        data.append(row);

        return this;
    }

    public TableBuilder appendLine() {
        data.append(lineTemplate);
        return this;
    }

    public String build() {
        return data.toString();
    }
}
