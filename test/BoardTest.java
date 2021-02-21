package test;
import model.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    @Test
     void TestTick(){
        Board board = new Board();
        assertEquals(8, board.getComputerWall());
    }
}
