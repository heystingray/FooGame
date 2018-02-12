import java.util.Observer;
import java.util.Observable;
import java.util.*;
import javafx.util.Pair;

public class DefaultRandomAIPlayer extends Player {
	private Random rand;

	public DefaultRandomAIPlayer(Observable o) {
  		super(o, "The Computer");
  		rand = new Random();
  	}

	public DefaultRandomAIPlayer(Observable o, String name) {
	  	super(o, name);
	  	rand = new Random();
	  }

	private Pair<Integer,Integer> pickRandomSpace() {
		int x = rand.nextInt(5)+1;
		int y = rand.nextInt(5)+1;
		//System.out.println(x+" "+y);
		return new Pair<Integer,Integer>(x,y);
	}

    public Move makeMove(){
    	//picks a random space
        Pair<Integer,Integer> space = pickRandomSpace();

        //if that space is empty places stone there
        if (boardstate.get(space) == null) {
        	return new PlaceStone(this, space);
        }

        //if space contain it's own stone, checks surrounding spaces for enemy stones to move onto
        if (boardstate.get(space) == this) {
        	Pair<Integer,Integer> target = new Pair<Integer,Integer>(space.getKey(), space.getValue()+1);
        	if (boardstate.get(target) != null && boardstate.get(target) != this) {
        		return new MoveStone(this, space, target);
        	}

        	target = new Pair<Integer,Integer>(space.getKey(), space.getValue()-1);
        	if (boardstate.get(target) != null && boardstate.get(target) != this) {
        		return new MoveStone(this, space, target);
        	}

        	target = new Pair<Integer,Integer>(space.getKey()+1, space.getValue());
        	if (boardstate.get(target) != null && boardstate.get(target) != this) {
        		return new MoveStone(this, space, target);
        	}

        	target = new Pair<Integer,Integer>(space.getKey()-1, space.getValue());
        	if (boardstate.get(target) != null && boardstate.get(target) != this) {
        		return new MoveStone(this, space, target);
        	}
		}

		//if it doesn't make any moves, try again
		return makeMove();
    }
}
