package no.sb1.integration;

public class Grid {
    private static final String NEW_LINE = System.getProperty("line.separator");



    private Cell[][] cells;

    public Grid(String gridAsString) {
        this.cells = convertStringToGrid(gridAsString);
    }

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    private Cell[][] convertStringToGrid(String gridAsString) {
        //List
        //Splitte opp radene
        String[] rows = gridAsString.split(NEW_LINE);
        int rowCount = rows.length;
        int columncount = rows[0].length();
        Cell[][] cells = new Cell[rowCount][columncount];
        //Oversette til celleformat
        for(int i = 0; i < rowCount; i++) {
            char[] chars = rows[i].trim().toCharArray();
            for(int j = 0; j<chars.length;j++) {
                Cell cell = Cell.fromString(Character.toString(chars[j]));
                if (cell == null) {
                    throw new IllegalArgumentException();
                }

                cells[i][j] = cell;
            }
        }

        return cells;
    }

    public int getLiveNeighboursCount(int x, int y) {
        System.out.println(getCell(x,y));
        int totalLiveNeighbours = 0;
        for(int xCoordinate = x -1; xCoordinate <= x+1 ; xCoordinate++) {
            for(int yCoordinate = y-1; yCoordinate <= y+1; yCoordinate++) {

                if(!outOfBounds(xCoordinate, yCoordinate) && cells[xCoordinate][yCoordinate] == Cell.ALIVE && !self(x,y,yCoordinate ,xCoordinate )) {
                        totalLiveNeighbours++;
                    }
                }
            }
        return totalLiveNeighbours;
    }

    private boolean self(int x, int y, int ycordinate, int xCoordinate) {
        return x==xCoordinate && y==ycordinate;
    }

    private boolean outOfBounds(int xCoordinate, int yCoordinate) {
        return (xCoordinate < 0 || xCoordinate > cells.length - 1 || yCoordinate < 0 || yCoordinate > cells[0].length - 1);
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }


    public Cell[][] getCells() {
        return cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j<cells[0].length; j++) {
                sb.append(cells[i][j].getCellType());
            }
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }
}
