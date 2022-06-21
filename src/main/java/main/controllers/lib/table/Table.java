package main.controllers.lib.table;

import java.util.LinkedList;

public class Table {
    // We don't know what type of data the column contains.
    private LinkedList<TableColumn<TableCell<?>>> columns;
    public Table() {
        columns = new LinkedList<>();
    }
    public void addColumn(TableColumn<TableCell<?>> tableColumn) { columns.add(tableColumn); }
    public LinkedList<TableColumn<TableCell<?>>> getColumns() { return columns; }
}
