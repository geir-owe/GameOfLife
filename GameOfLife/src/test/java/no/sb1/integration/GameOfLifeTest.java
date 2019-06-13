package no.sb1.integration;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeTest {
    @Test
    void vanillaExample() {
        Cell[][] input = new Cell[][] {
            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void shouldNotChange() {
        Cell[][] input = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void liveCellWithMoreThan3Dies() {
        Cell[][] input = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void liveCellWithFewerThan2Dies() {
        Cell[][] input = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void allDeadStaysDead() {
        Cell[][] input = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }


    @Test
    void onlyCornersStayAliveWhenAllStartAlive() {
        Cell[][] input = new Cell[][] {
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE,Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE,Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE,Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE,Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE,Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD,Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD,Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD,Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD,Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD,Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE}
        };

        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void randomTest() {
        Cell[][] input = new Cell[][] {
                {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void deadBecomesLive() {
        Cell[][] input = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.DEAD, Cell.DEAD, Cell.DEAD}
        };

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.DEAD, Cell.ALIVE, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));

    }

    @Test
    void deadBecomesLiveAsStringInput() {
        String input = "---\n" +
                "-*-\n" +
                "***\n" +
                "---";

        String excpected = "---\n" +
                "***\n" +
                "***\n" +
                "-*-\n";

        Cell[][] nextGen = new Cell[][] {
                {Cell.DEAD, Cell.DEAD, Cell.DEAD},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.ALIVE, Cell.ALIVE, Cell.ALIVE},
                {Cell.DEAD, Cell.ALIVE, Cell.DEAD}
        };
        GameOfLife gof = new GameOfLife(new Grid(input));
        gof.calculateNextGen();
        assertTrue(Arrays.deepEquals(gof.getGrid().getCells(), nextGen));
        String result = gof.getGrid().toString();
        assertEquals(excpected, result);

    }
}
