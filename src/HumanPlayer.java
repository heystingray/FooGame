import java.util.Observer;
import java.util.Observable;
import java.util.Arrays;
import java.util.Scanner;
import javafx.util.Pair;

public class HumanPlayer extends Player{
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(Observable o) {
      super(o, "The Human");
    }

    public HumanPlayer(Observable o, String name) {
      super(o, name);
    }

    public Move makeMove(){
        //get move from user and tell fooGame about it
        System.out.println("Enter move: ");
        String[] nextMove=scanner.nextLine().split(" ");
        //split nextMove into moveType and params
        String moveType = nextMove[0];
        //I hope this syntax is allowed in Java
        String[] params =Arrays.copyOfRange(nextMove, 1, 2);
        Move move = parseMe(moveType, params);
        return move;
    }
    public Move parseMe(String moveType, String[] params){
        if(moveType.toLowerCase()=="place"){
            return new PlaceStone(this,makeCoord(params[0]));
        }
        else if(moveType.toLowerCase()=="move"){
            return new MoveStone(this,makeCoord(params[0]),makeCoord(params[1]));
        }
        else{
            System.out.println("Type 'place' to put a new piece on the board, then type the coordinate (ie. A1) it goes in.");
            System.out.println("Type 'move' to move an existing piece, then type it's current location and where it should go.");
            return null;
        }
    }

    public Pair<Integer,Integer> makeCoord(String input){
        char temp =input.charAt(0);
        int i1 = (int)temp-96;
        temp =input.charAt(1);
        int i2 = (int)temp;
        return new Pair<Integer,Integer>(i1,i2);
    }
}
