/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Reydon Sports  Tic Tac Toe Interview code
 * @author Louis_Burrows
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static void drawGameBoard(int rows,int cols){
        
        for (int r = 0; r < rows; r++) {
            String cellLn1="";
            String cellLn2="";
            String cellLn3="";
            for (int c = 0;c<cols;c++){
                cellLn1+=c;
            }
            System.out.println(cellLn1);
          }
        
    
    }
    
}
