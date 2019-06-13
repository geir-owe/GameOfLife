package no.sb1.integration;

public class GameOfLife {
    private static final String NEW_LINE = System.getProperty("line.separator");

    private Grid grid;

    public GameOfLife(Grid grid) {
        this.grid = grid;
    }

    public GameOfLife(String gridAsString) {
        this.grid = new Grid(gridAsString);
    }

    public void calculateNextGen() {
        StringBuilder nextGenAsString = new StringBuilder();

        for(int i = 0; i< grid.getCells().length; i++) {
            for(int j = 0; j< grid.getCells()[0].length; j++) {
                //sjekke naboer for celle
                Cell currentCell = grid.getCell(i, j);
                int liveNeighboursCount = grid.getLiveNeighboursCount(i,j);
                Cell newCellValue;

                if(currentCell == Cell.DEAD) {
                    if(liveNeighboursCount == 3) {
                        //Any dead cell with exactly three live neighbours becomes a live cell
                        newCellValue = Cell.ALIVE;
                    } else {
                        //stay dead
                        newCellValue = Cell.DEAD;
                    }
                } else {
                    //isAlive
                    if(liveNeighboursCount > 1 && liveNeighboursCount < 4) {
                        //Any live cell with two or three live neighbours lives on to the next generation
                        newCellValue = Cell.ALIVE;
                    } else {
                        //Any live cell with fewer than two live neighbours dies, as if caused by underpopulation
                        //Any live cell with more than three live neighbours dies, as if by overcrowding
                        newCellValue = Cell.DEAD;
                    }
                }
                nextGenAsString.append(newCellValue.getCellType());
            }
            nextGenAsString.append(NEW_LINE);
        }

        grid = new Grid(nextGenAsString.toString());
    }

    public Grid getGrid() {
        return grid;
    }
}
