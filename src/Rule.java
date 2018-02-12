import java.util.*;
import javafx.util.Pair;

public abstract class Rule implements Observer {
  Observable observable;
  protected Map<Pair<Integer,Integer>,Player> boardstate;

  public Rule(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

  public void update(Observable obs, Object arg) {
        try {
        	FooGame fg = (FooGame)obs;
        	this.boardstate = fg.getBoardState();
        } catch (ClassCastException e) {}
    }

  public abstract boolean check(Move m);


}
