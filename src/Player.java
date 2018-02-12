import java.util.Observer;
import java.util.Observable;
import java.util.*;
import javafx.util.Pair;

public abstract class Player implements Observer {
  String name;
	Observable observable;
	protected Map<Pair<Integer,Integer>,Player> boardstate;
	private int stones;

	public Player(Observable observable, String name) {
		this.observable = observable;
		observable.addObserver(this);
    this.name = name;
    this.stones = 21;
	}

    public void update(Observable obs, Object arg) {
        try {
        	FooGame fg = (FooGame)obs;
        	this.boardstate = fg.getBoardState();
        } catch (ClassCastException e) {}
    }

    public void useStone() {
    	stones--;
    }

    public int getStones() {
    	return stones;
    }

    public void setStones(int i) {
    	stones = i;
    }

    public abstract Move makeMove();

    public String toString() {
        return name;
    }

}
