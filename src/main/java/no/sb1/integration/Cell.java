package no.sb1.integration;

public enum Cell {
    DEAD("-"),
    ALIVE("*");

    private String cellType;

    Cell(String s) {
        cellType = s;
    }

    static Cell fromString(String s) {
        Cell cellToReturn = null;

        for (Cell cell : Cell.values()) {
            if(cell.cellType.equalsIgnoreCase(s)) {
                cellToReturn = cell;
            }
        }

        return cellToReturn;
    }

    public String getCellType() {
        return cellType;
    }
}
