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
public class TicTacToe_DrawMarkerTest {
    
    public TicTacToe_DrawMarkerTest() {
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
        System.out.println("instanctaite main to draw a blank board");
        String[] args = {"3","3"};
        TicTacToe.main(args);

    }

    /**
     * Test of makeAMove method, of class TicTacToe.
     */
    @Test
    public void testcheckAMove() {
        
        System.out.println("checkAMove() accept a move to an empty cell (0,0)");
        TicTacToe.drawGameBoard();
        int x =0;
        int y = 0;
        boolean expResult = true;
        boolean result = TicTacToe.checkAMove(x,y);
        assertEquals(expResult, result);
        
        x =0;
        y = 0;
        String Marker="X";
        TicTacToe.addMarkerToBoard(x, y,Marker);
        System.out.println("checkAMove() reject a move to an full cell (0,0)");
        TicTacToe.drawGameBoard();
        expResult = false;
        result = TicTacToe.checkAMove(x,y);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkMarkerValid method, of class TicTacToe.
     */
    @Test
    public void testcheckCoordValid() {
        String[] args = {"3","3"};
        TicTacToe.main(args);
        
        System.out.println("checkCoordValid() check for acceptance of correct format");
        String consoleInput = "2,2";
        String expResult = "";
        String result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check no coordinates are rejected ");
        consoleInput = "";
        expResult = "Incorrect Coordinate Format expected 'x,y'";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check only 1 coordinates is rejected ");
        consoleInput = "2";
        expResult = "Incorrect Coordinate Format expected 'x,y'";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check more than 2 coordinates are rejected ");
        consoleInput = "2,2,2";
        expResult = "Incorrect Coordinate Format expected 'x,y'";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check x = non int is rejected ");
        consoleInput = "a,2";
        expResult = "x coord is not an integer greater than 0";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check y = non int is rejected ");
        consoleInput = "2,a";
        expResult = "y coord is not an integer greater than 0";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check x and y = non int is rejected ");
        consoleInput = "a,a";
        expResult = "x coord is not an integer greater than 0";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        
        System.out.println("checkCoordValid() check x= -1 is rejected ");
        consoleInput = "-1,2";
        expResult = "x coord is not an integer greater than 0";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check y= -1 is rejected ");
        consoleInput = "2,-1";
        expResult = "y coord is not an integer greater than 0";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);

        System.out.println("checkCoordValid() check y and x= -1 is rejected ");
        consoleInput = "-1,-1";
        expResult = "x coord is not an integer greater than 0";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        
        System.out.println("checkCoordValid() check x>rows is rejected ");
        consoleInput = "3,2";
        expResult = "x coord is to high must be less than 3";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);
        
        System.out.println("checkCoordValid() check y>rows is rejected ");
        consoleInput = "2,3";
        expResult = "y coord is to high must be less than 3";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);

        System.out.println("checkCoordValid() check y and x> rows is rejected ");
        consoleInput = "3,3";
        expResult = "x coord is to high must be less than 3";
        result = TicTacToe.checkCoordValid(consoleInput);
        assertEquals(expResult, result);


    }

    /**
     * Test of isInteger method, of class TicTacToe.
     */
    @Test
    public void testIsPositiveInteger() {
        System.out.println("isPostiveInteger() check integer value is accepted");
        String s = "1";
        int radix = 10;
        boolean expResult = true;
        boolean result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        
        System.out.println("isPositiveIntegr() check for negative int is rejected");
        s = "-1";
        radix = 10;
        expResult = false;
        result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        
        System.out.println("isPositiveInteger() check non int is rejected");
        s = "a";
        radix = 10;
        expResult = false;
        result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        
        System.out.println("isPositiveInteger() check mix of ints and non ints is rejected");
        s = "a1";
        radix = 10;
        expResult = false;
        result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        

    }

    /**
     * Test of addMarkerToBoard method, of class TicTacToe.
     */
    @Test
    public void testAddMarkerToBoard() {
        String[] args = {"3","3"};
        TicTacToe.main(args);
        
        System.out.println("addMarkerToBoard(), add X to non 0 cell index");
        int x = 0;
        int y = 0;
        String Marker="X";
        String[] expResult = new String[]{"X"," "," "," "," "," "," "," "," "};
        String[] result = TicTacToe.addMarkerToBoard(x, y, Marker);
        TicTacToe.drawGameBoard();
        assertArrayEquals(expResult, result);
        
        System.out.println("addMarkerToBoard(), add O to non 0 cell index");
        x = 1;
        y = 0;
        Marker="O";
        expResult = new String[]{"X","O"," "," "," "," "," "," "," "};
        result = TicTacToe.addMarkerToBoard(x, y, Marker);
        assertArrayEquals(expResult, result);
        TicTacToe.drawGameBoard();

    }

    /**
     * Test of drawGameBoard method, of class TicTacToe.
     */
    @Test
    public void testDrawGameBoard() {
        
    }
    
}
