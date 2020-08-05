
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static int cols = 0;
    private static int rows = 0;
    private static int humans=0;
    
    private static String[] Cells=null;
    private static boolean gameRunning=false;
    private static String currentPlayer="";
    private static String currentMarker="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length<1){
            System.out.println("insuffiient parameters provided");
            return;
        }
        if (args.length>=1){
            if(isPositiveInteger(args[0],10)){
                cols=Integer.parseInt(args[0]);
            }else{
                System.out.println("value for number of columns is not an integer greater than 0");
                return;
            }
        }
        if (args.length>=2){
            if(isPositiveInteger(args[1],10)){
                rows=Integer.parseInt(args[1]);
            }else{
                System.out.println("value for number of rows is not an integer greater than 0");
                return;
            }
        }
        if (args.length>=3){
            if(isPositiveInteger(args[2],10)){
                humans=Integer.parseInt(args[2]);
                if(humans>2){
                    System.out.println("Too many human oppponents please enter value between 0 - 2");
                }
            }else{
                System.out.println("value for number of humans is not an integer please enter value between 0 - 2");
                return;
            }
        }
        //populate game board
        Cells=new String[cols*rows];
        for(int i =0;i<Cells.length;i++){
            Cells[i]=" ";
        } 
        drawGameBoard();
        
        gameRunning=true;
        currentPlayer="PLAYER1";
        currentMarker="X";
        while (gameRunning==true){
            
            int[] Coords = getPlayerInput();
            addMarkerToBoard(Coords[0],Coords[1],currentMarker);
            
            drawGameBoard();
            gameRunning=checkVictoryConditions(Coords);
            if ("PLAYER1".equals(currentPlayer)){
                currentPlayer="PLAYER2";
                currentMarker="O";
            }else{
                currentPlayer="PLAYER1";
                currentMarker="X";
            }
            
        }
            
        
        
    }
    public static int[] getPlayerInput(){
        boolean validInput=false;
        String input="";
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int[] Coords= new int[]{0,0};
        while (validInput==false){
            
            System.out.println(currentPlayer +" ("+currentMarker+")");
            System.out.println("Enter coordinates (X,Y):");
            //input = reader.readLine();
            input = in.nextLine();
            String coordFormatCheck=checkCoordValid(input);
            if("".equals(coordFormatCheck)){
                String[] strCoords=input.split(",");
                int x = Integer.parseInt(strCoords[0]);
                int y = Integer.parseInt(strCoords[1]);
                if(checkAMove(x,y)){
                    Coords=new int[]{x,y};
                    validInput=true;
                }else{
                    System.out.println(x+","+y+" is not a valid move");
                }    
            }else {
                System.out.println(coordFormatCheck);
            }
            
           
        }   
                 
        return Coords;
    }
    public static boolean checkAMove(int x , int y){
        //check if the move has already been made
            if (!" ".equals(Cells[x+(y*rows)]))return false;
        return true;
    }
    public static String checkCoordValid(String consoleInput){
        /**
         * Marker position is valid if 
         * x and y are integers
         * 0<x < columns
         * 0<y <rows
         * x and y 
         */
        String[] inputArray=consoleInput.split(",");
        //check coordinate format
        if(inputArray.length!=2)return "Incorrect Coordinate Format expected 'x,y'";
        //check coordinate data type and are in bounds
        if(!isPositiveInteger(inputArray[0],10))return "x coord is not an integer greater than 0";
        if(Integer.parseInt(inputArray[0])>=cols)return "x coord is to high must be less than "+cols;
        if(!isPositiveInteger(inputArray[1],10))return "y coord is not an integer greater than 0";
        if(Integer.parseInt(inputArray[1])>=rows)return "y coord is to high must be less than "+rows;
        return ""; //no errors
    }
    public static boolean isPositiveInteger(String s, int radix) {
    //For string check if it is a valid integer value and greater than 0 
    if(s.isEmpty()) return false;
    if(s.charAt(0) == '-')return false;
    for(int i = 0; i < s.length(); i++) {
        if(i == 0 && s.charAt(i) == '-') {
            if(s.length() == 1) return false;
            else continue;
        }
        if(Character.digit(s.charAt(i),radix) < 0) return false;
    }
    return true;
}
    public static String[] addMarkerToBoard(int x ,int y,String Marker){
        /**
         * Take x and y and turn it into some position in the cells array 
         * cellPos = x+y*rows)
         */
        Cells[x+(y*rows)]=Marker;
        return Cells;
    }
    public static boolean checkVictoryConditions(int[] Coords){
        /**
         * return true if game not won yet
         * return false if draw or game won
         * 
         * victory positions can be checked from the position of the last place marker
         * 1 check for any directly adjacent same marker
         *  in the same direction check for a second marker
         *  or on teh opposite side of the last placed marker
         */
        int x = Coords[0];
        int y = Coords[1];
        // For Vertical check 
        for(int row =y-2;row<y;row++){
            if(row >cols) break;
            if(row<0) continue;
            if(Cells[x+(row*rows)].equals(currentMarker)){
                if(row == y-2){
                    if(Cells[x+((y-1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if((row==y-1)&&(y+1<rows)){
                    if(Cells[x+((y+1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((row==y)&&(y+1<rows))&&(y+2<rows)){
                    if((Cells[x+((y+1)*rows)].equals(currentMarker))&&(Cells[x+((y+2)*rows)].equals(currentMarker))){
                        printWinner();
                        return false;
                    }
                }
            }
        }

        // For Vertical check 
        for(int col =x-2;col<x;col++){
            if(col >cols) break;
            if(col<0) continue;
            if(Cells[col+(y*rows)].equals(currentMarker)){
                if(col == x-2){
                    if(Cells[(x-1)+(y*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if((col==x-1)&&(x+1<rows)){
                    if(Cells[(x+1)+(y*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((col==x)&&(x+1<rows))&&(x+2<rows)){
                    if((Cells[(x+1)+(y*rows)].equals(currentMarker))&&(Cells[(x+2)+(y*rows)].equals(currentMarker))){
                        printWinner();
                        return false;
                    }
                }
            }
        }
        // For any left to right diagonal , 
        for( int i =2 ; i>-1;i--){
            int dX=x-i;
            int dY=y-i;
            if((dX<0)||(dY<0)) continue;
            if(Cells[dX+(dY*rows)].equals(currentMarker)){
                if(i == 2){
                    if(Cells[(x-1)+((y-1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if((i==1)&&(y+1<rows)){
                    if(Cells[(x+1)+((y+1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((i==0)&&(x+2<cols))&&(rows-y>=2)){
                    if((Cells[(x+1)+((y+1)*rows)].equals(currentMarker))&&(Cells[(x+2)+((y+2)*rows)].equals(currentMarker))){
                        printWinner();
                        return false;
                    }
                }
            }
        }
        
        // For right to left diagonal
        for( int i =2 ; i>-1;i--){
            int dX=x+i;
            int dY=y-i;
            if((dX>cols)||(dY<0)) continue;
            if(Cells[dX+(dY*rows)].equals(currentMarker)){
                if(i == 2){
                    if(Cells[(x+1)+((y-1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if((i==1)&&(y+1<rows)){
                    if(Cells[(x-1)+((y+1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((i==0)&&(x-2>=0))&&(rows-y>=2)){
                    if((Cells[(x-1)+((y+1)*rows)].equals(currentMarker))&&(Cells[(x-2)+((y+2)*rows)].equals(currentMarker))){
                        printWinner();
                        return false;
                    }
                }
            }
        }
        
        // check for any remaining spaces
        for(String Marker : Cells){
            if(" ".equals(Marker)){
                //thier are stioll moves left to make
                return true;
            }
        }
        // the board must be full , a draw has been reached
        printDraw();
        return false;
    }
    public static void printWinner(){
        System.out.println("*******WINNER**********");
        System.out.println("Congratulations "+currentPlayer);
        System.out.println("***********************");
        
    }
    public static void printDraw(){
        System.out.println("*********Draw**********");
        System.out.println("The only winning move is");
        System.out.println("not to play");
        System.out.println("***********************");
    }        
    public static void drawGameBoard(){
        System.out.println("TIC-TAC-TOE");
        int pos=0;
        for (int r = 0; r < rows; r++) {
            String boardHeader=" ";
            String cellLn1=" ";
            String cellLn2=""+r;
            String cellLn3=" ";
            String horizLn=" ";
            for (int c = 0;c<cols;c++){
                if (r==0){
                    boardHeader+=" "+c+" ";
                    if (cols-c>1){
                        boardHeader+=" ";
                    }
                }
                cellLn1+="   ";
                cellLn2+=" "+Cells[pos]+" ";
                cellLn3+="   ";
                horizLn+="---";
                if (cols-c>1){
                    cellLn1+="|";
                    cellLn2+="|";
                    cellLn3+="|";
                    horizLn+="-";
                }        
                pos++;
            }
            
            if (r==0){
                System.out.println(boardHeader);
            }
            System.out.println(cellLn1);
            System.out.println(cellLn2);
            System.out.println(cellLn3);
            if(rows-r>1){
                System.out.println(horizLn);
            }
          }
        
    
    }
    
}
