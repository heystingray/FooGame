import java.util.*;
import javafx.util.Pair;

public abstract class FooGUI implements Observer {
  Observable observable;
	protected Map<Pair<Integer,Integer>,Player> boardstate;
  protected ArrayList<Player> playerlist;

  public FooGUI(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

  public void update(Observable obs, Object arg) {
        try {
        	FooGame fg = (FooGame)obs;
        	this.boardstate = fg.getBoardState();
          this.playerlist = fg.getPlayers();
          draw();
        } catch (ClassCastException e) {}
    }

  public abstract void draw();

}
