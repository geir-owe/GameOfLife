package no.sb1.integration;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {
    @Test
    void gridReadOk() throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("testfile.txt").toURI());
        byte[] fileBytes = Files.readAllBytes(path);
        String data = new String(fileBytes);
        Grid grid = new Grid(data);
        String excpected = "--------\n" +
                "----*---\n" +
                "---**---\n" +
                "--------";
        Cell[][] excpectedGrid = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };
        assertEquals(excpected, data);
        assertTrue(Arrays.deepEquals(excpectedGrid, grid.getCells()));
        assertEquals(2,grid.getLiveNeighboursCount(1,4));
    }
}
