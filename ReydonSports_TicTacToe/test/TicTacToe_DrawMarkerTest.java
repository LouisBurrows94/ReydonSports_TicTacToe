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
        System.out.println("main");
        String[] args = {"3","3"};
        TicTacToe.main(args);

    }

    /**
     * Test of makeAMove method, of class TicTacToe.
     */
    @Test
    public void testMakeAMove() {
        System.out.println("makeAMove");
        TicTacToe.makeAMove();
    }

    /**
     * Test of checkMarkerValid method, of class TicTacToe.
     */
    @Test
    public void testCheckMarkerValid() {
        System.out.println("checkMarkerValid");
        String consoleInput = "2,2";
        String expResult = "";
        String result = TicTacToe.checkMarkerValid(consoleInput);
        assertEquals(expResult, result);

    }

    /**
     * Test of isInteger method, of class TicTacToe.
     */
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        String s = "1";
        int radix = 10;
        boolean expResult = true;
        boolean result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        
        System.out.println("check for negative ints");
        s = "-1";
        radix = 10;
        expResult = false;
        result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        
        System.out.println("check for non int");
        s = "a";
        radix = 10;
        expResult = false;
        result = TicTacToe.isPositiveInteger(s, radix);
        assertEquals(expResult, result);
        
        System.out.println("check for mix of ints and non ints");
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
        System.out.println("addMarkerToBoard");
        int x = 0;
        int y = 0;
        String[] Cells = {" "," "," "," "," "," "," "," "," "};
        String[] expResult = {"X"," "," "," "," "," "," "," "," "};
        String[] result = TicTacToe.addMarkerToBoard(x, y, Cells);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of drawGameBoard method, of class TicTacToe.
     */
    @Test
    public void testDrawGameBoard() {
        
    }
    
}
