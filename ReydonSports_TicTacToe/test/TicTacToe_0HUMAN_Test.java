/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis_Burrows
 */
public class TicTacToe_0HUMAN_Test {
    
    public TicTacToe_0HUMAN_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class TicTacToe.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {"3","3","0"};
        TicTacToe.main(args);
    }

    /**
     * Test of getCoordFromPlayer method, of class TicTacToe.
     */
    @Test
    public void testGetCoordFromPlayer() {
        System.out.println("getCoordFromPlayer");
        int[] expResult = null;
        //int[] result = TicTacToe.getCoordFromPlayer();
        //assertArrayEquals(expResult, result);

    }

    /**
     * Test of getHumanPlayerInput method, of class TicTacToe.
     */
    @Test
    public void testGetHumanPlayerInput() {
        System.out.println("getHumanPlayerInput");
        int[] expResult = null;
        //int[] result = TicTacToe.getHumanPlayerInput();
        //assertArrayEquals(expResult, result);

    }

    /**
     * Test of checkAMove method, of class TicTacToe.
     */
    @Test
    public void testCheckAMove() {
        System.out.println("checkAMove");
        int x = 0;
        int y = 0;
        boolean expResult = false;
        //boolean result = TicTacToe.checkAMove(x, y);
        //assertEquals(expResult, result);

    }

    /**
     * Test of checkCoordValid method, of class TicTacToe.
     */
    @Test
    public void testCheckCoordValid() {
        System.out.println("checkCoordValid");
        String consoleInput = "";
        String expResult = "";
        //String result = TicTacToe.checkCoordValid(consoleInput);
        //assertEquals(expResult, result);

    }

    /**
     * Test of isPositiveInteger method, of class TicTacToe.
     */
    @Test
    public void testIsPositiveInteger() {
        System.out.println("isPositiveInteger");
        String s = "";
        int radix = 0;
        boolean expResult = false;
        boolean result = TicTacToe.isPositiveInteger(s, radix);
        //assertEquals(expResult, result);

    }

    /**
     * Test of addMarkerToBoard method, of class TicTacToe.
     */
    @Test
    public void testAddMarkerToBoard() {
        System.out.println("addMarkerToBoard");
        int x = 0;
        int y = 0;
        String Marker = "";
        String[] expResult = null;
        //String[] result = TicTacToe.addMarkerToBoard(x, y, Marker);
        //assertArrayEquals(expResult, result);

    }

    /**
     * Test of checkVictoryConditions method, of class TicTacToe.
     */
    @Test
    public void testCheckVictoryConditions() {
        System.out.println("checkVictoryConditions");
        int[] Coords = null;
        boolean expResult = false;
        //boolean result = TicTacToe.checkVictoryConditions(Coords);
        //assertEquals(expResult, result);

    }

    /**
     * Test of printWinner method, of class TicTacToe.
     */
    @Test
    public void testPrintWinner() {
        System.out.println("printWinner");
        //TicTacToe.printWinner();

    }

    /**
     * Test of printDraw method, of class TicTacToe.
     */
    @Test
    public void testPrintDraw() {
        System.out.println("printDraw");
        //TicTacToe.printDraw();

    }

    /**
     * Test of drawGameBoard method, of class TicTacToe.
     */
    @Test
    public void testDrawGameBoard() {
        System.out.println("drawGameBoard");
        //TicTacToe.drawGameBoard();

    }
    
}
