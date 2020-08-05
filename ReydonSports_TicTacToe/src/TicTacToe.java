
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    private static String humanPlayer="";
    private static String Winner="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Parse arguments
        //define size of baord
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
        //define number of players
        if (args.length>=3){
            if(isPositiveInteger(args[2],10)){
                humans=Integer.parseInt(args[2]);
                if(humans>2){
                    System.out.println("Too many human oppponents please enter value between 0 - 2");
                    return;
                }else if (humans ==1){
                    if (args.length>=4){
                        if("true".equals(args[3])){
                            humanPlayer="PLAYER1";
                        }else if("false".equals(args[3])){
                            humanPlayer="PLAYER2";                        
                        }else{
                            System.out.println("enter 'true' to goFirst or 'false to go second ");
                            return;
                        }
                        System.out.println("human player is "+humanPlayer);
                    }else{
                        humanPlayer="PLAYER1";
                    }
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
        //game runtime routine
        gameRunning=true;
        currentPlayer="PLAYER1";
        currentMarker="X";
        while (gameRunning==true){
            //get input
            int[] Coords = getCoordFromPlayer();
            //update game baord
            addMarkerToBoard(Coords[0],Coords[1],currentMarker);
            //draw o console
            drawGameBoard();
            //check fail game end state
            gameRunning=checkVictoryConditions(Coords);
            //switch players
            if ("PLAYER1".equals(currentPlayer)){
                currentPlayer="PLAYER2";
                currentMarker="O";
            }else{
                currentPlayer="PLAYER1";
                currentMarker="X";
            }
            
        }
        //record result
        addToLeaderBoard( Winner);
            
        
        
    }
    public static int[] getCoordFromPlayer(){
        /**
         * The number of humans determines how the input for each move is aquired
         */
        
        switch (humans){
            case 0:
                return getAIPlayerInput();
            case 1:
                if(currentPlayer.equals(humanPlayer)){
                    return getHumanPlayerInput();
                }else{
                    return getAIPlayerInput();
                }
            case 2:
                return getHumanPlayerInput();
            default:
                System.out.println("more than 2 human players");            
        }
        return new int[]{0,0};
    }
    public static int[] getAIPlayerInput(){
        /**
         * A simple ai opponent that picks a random avaialble cell
         * the ai will only make moves that are available and valid
         */
        System.out.println(currentPlayer +" ("+currentMarker+")");
        System.out.println("Enter coordinates (X,Y):");
        Random r = new Random();
        int i=0;
        List<Integer> triedMoves = new ArrayList<Integer>();
        while(triedMoves.size()<(cols*rows)){
            i=r.nextInt(cols*rows);
            if (!triedMoves.contains(i)){
                triedMoves.add(i);
                if(" ".equals(Cells[i])){
                    int x = i%cols;
                    int y = i / rows;
                    System.out.println(x+","+y);
                    return new int[]{x,y};
                }
            }
         }     
        return new int[]{0,0};
    }
    public static int[] getHumanPlayerInput(){
        /**
         * Gets user input from human player and checks that the input is valid
         */
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
        //check if the move has already been made on the game
            if (!" ".equals(Cells[x+(y*rows)]))return false;
        return true;
    }
    public static String checkCoordValid(String consoleInput){
        /**
         * Marker position is valid if 
         * x and y are integers
         * 0<x < columns
         * 0<y <rows
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
    /**
     * //For string check if it is a valid integer value and greater than 0 
     */
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
         * check for lines in vertical , horizontal ,left to right diagonal , right to left diagonal
         * thier are 5 positions in each direction that a line could be in if the line is length 3  iem -,-,X,-,- 
         * for any directions thier are 3 cases to check ,
         * 1 if a line start 2 cells away from the placed piece         ie, sX,-,pX
         * 2 if a line starts 1 square away from the placed piece       ie, sX,pX,-
         * 3 if a line starts on the placed piece                       ie, pX,-,-
         * 
         * The second and  third case cover the remaining no start positions in each possible direction 
         *
         */
        int x = Coords[0];
        int y = Coords[1];
        // For Vertical check 
        for(int row =y-2;row<y;row++){
            if(row >rows) break;
            if(row<0) continue;
            if(Cells[x+(row*rows)].equals(currentMarker)){
                if(row == y-2){                                 //line start 2 cells away from the placed piece
                    if(Cells[x+((y-1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if((row==y-1)&&(y+1<rows)){               //if a line starts 1 square away from the placed piece 
                    if(Cells[x+((y+1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((row==y)&&(y+1<rows))&&(y+2<rows)){   //if a line starts on the placed piece 
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
                if(col == x-2){                                 //line start 2 cells away from the placed piece
                    if(Cells[(x-1)+(y*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if((col==x-1)&&(x+1<cols)){               //if a line starts 1 square away from the placed piece 
                    if(Cells[(x+1)+(y*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((col==x)&&(x+1<cols))&&(x+2<cols)){   //if a line starts on the placed piece 
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
                if(i == 2){                                     //line start 2 cells away from the placed piece
                    if(Cells[(x-1)+((y-1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((i==1)&&(x+1<cols))&&(y+1<rows)){     //if a line starts 1 square away from the placed piece 
                    if(Cells[(x+1)+((y+1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((i==0)&&(x+2<cols))&&(y+2<rows)){     //if a line starts on the placed piece 
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
                if(i == 2){                                         //line start 2 cells away from the placed piece
                    if(Cells[(x+1)+((y-1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((i==1)&&(x-1>=0))&&(y + 1 < rows)){       //if a line starts 1 square away from the placed piece 
                    if(Cells[(x-1)+((y+1)*rows)].equals(currentMarker)){
                        printWinner();
                        return false;
                    }
                }else if(((i==0)&&(x-2>=0))&&(y+2<rows)){           //if a line starts on the placed piece 
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
                //thier are still moves left to make
                return true;
            }
        }
        // the board must be full , a draw has been reached
        printDraw();
        return false;
    }
    public static void printWinner(){
        Winner=currentPlayer;
        System.out.println("*******WINNER**********");
        System.out.println("Congratulations "+currentPlayer);
        System.out.println("***********************");
        
    }
    public static void printDraw(){
        Winner="Draw";
        System.out.println("*********Draw**********");
        System.out.println("The only winning move is");
        System.out.println("not to play");
        System.out.println("***********************");
    }        
    public static void drawGameBoard(){
        /**
         * draw the game board with any number of rows and columns based on the parameters passed to main 
         */
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
    public static void addToLeaderBoard(String leader){
        /**
         * Output Results to JSON File for potential further anlysis
         * uses json simple to build a josn object from the game resulst
         * uses json simlpe to load the json array from file
         * adds json object to json array 
         * rewrites the json file with the updated json array using gson to format the output so that it is human readable 
         */
        Timestamp TimeStamp = new Timestamp(System.currentTimeMillis());
        String leaderJson="{\"winner\":\""+leader+"\",\"TimeStamp\" : \""+TimeStamp+"\"}";
        
        JSONParser parser = new JSONParser();
        
        Object fileObj;
        Object leaderObj;
        try {
            fileObj = parser.parse(new FileReader("LeaderBoard.json"));
            JSONArray itemList = (JSONArray) fileObj;
            leaderObj=parser.parse(leaderJson);
            JSONObject leaderJSON=(JSONObject)leaderObj;
            itemList.add(leaderJSON);
            //convert to pretty print for nice output
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            // add to 
            FileWriter file = new FileWriter("LeaderBoard.json");
            //System.out.println(itemList.toString());
            file.write(gson.toJson(itemList));
            file.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }


        


    }
}
