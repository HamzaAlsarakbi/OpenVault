package main.controllers.lib.table;

import java.util.LinkedList;

public class TableColumn<T> {
    private String header;
    private LinkedList<TableCell<T>> cells;
    public TableColumn(String header, LinkedList<T> cells) {
        setCells(cells);
    }

    public LinkedList<TableCell<T>> getCells() {return cells; }
    public void addCell(TableCell<T> cell) { cells.add(cell); }
    public void setCells(LinkedList<T> cells) {
        for(T cell : cells) this.cells.add(new TableCell<T>(cell));
    }

    public String toString() {
        return String.format("Table Column. Cells: %s", cells);
    }
}
