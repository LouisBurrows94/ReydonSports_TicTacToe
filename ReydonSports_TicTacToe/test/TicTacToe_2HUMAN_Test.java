/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author Louis_Burrows
 */
public class TicTacToe_2HUMAN_Test {
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;
    
    public TicTacToe_2HUMAN_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }
  
    
    /**
     * Test of main method, of class TicTacToe.
     */
    @Test
    public void testMain() {
        final String testString = "1,1";
        provideInput(testString);
        System.out.println("main");
        String[] args = {"3","3","2"};
        TicTacToe.main(args);
    }

    /**
     * Test of getPlayerInput method, of class TicTacToe.
     */
    @Test
    public void testGetPlayerInput() {
        //System.out.println("getPlayerInput");
        int[] expResult = null;
        //int[] result = TicTacToe.getPlayerInput();
        //assertArrayEquals(expResult, result);

    }

    /**
     * Test of checkAMove method, of class TicTacToe.
     */
    @Test
    public void testCheckAMove() {
        //System.out.println("checkAMove");
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
        //System.out.println("checkCoordValid");
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
        //System.out.println("isPositiveInteger");
        String s = "";
        int radix = 0;
        boolean expResult = false;
        //boolean result = TicTacToe.isPositiveInteger(s, radix);
        //assertEquals(expResult, result);

    }

    /**
     * Test of addMarkerToBoard method, of class TicTacToe.
     */
    @Test
    public void testAddMarkerToBoard() {
        //System.out.println("addMarkerToBoard");
        int x = 0;
        int y = 0;
        String Marker = "";
        String[] expResult = null;
        //String[] result = TicTacToe.addMarkerToBoard(x, y, Marker);
        //assertArrayEquals(expResult, result);

    }

    /**
     * Test of drawGameBoard method, of class TicTacToe.
     */
    @Test
    public void testDrawGameBoard() {
        //System.out.println("drawGameBoard");
        TicTacToe.drawGameBoard();

    }
    
}
