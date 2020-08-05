/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Louis_Burrows
 */
public class TicTacToe_DrawBoardTest {
    
    public TicTacToe_DrawBoardTest() {
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
        System.out.println("Draw 3x3 Game Board");
        String[] args = {"3","3"};
        TicTacToe.main(args);
        System.out.println("Draw 4x4 Game Board");
        args = new String[]{"4","4"};
        TicTacToe.main(args);

    }
    
}
