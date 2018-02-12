import java.util.Observer;
import java.util.Observable;
import java.util.*;
import javafx.util.Pair;

public abstract class WinCondition implements Observer {
	Observable observable;
	protected Map<Pair<Integer,Integer>,Player> boardstate;
	ArrayList<Player> playerlist;

	public WinCondition(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

    public void update(Observable obs, Object arg) {
        try {
        	FooGame fg = (FooGame)obs;
        	this.boardstate = fg.getBoardState();
					this.playerlist = fg.getPlayers();
        } catch (ClassCastException e) {}
    }

    public abstract Player checkForWinner();

}
