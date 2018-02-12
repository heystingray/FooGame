import java.util.*;
import javafx.util.Pair;

public class HumanVsLarry extends Default {
  public ArrayList<Player> setPlayers(Observable o) {
		ArrayList<Player> plist = new ArrayList<Player>();
		plist.add(new HumanPlayer(o, "Computer1"));
		plist.add(new Larry(o));
		return plist;
	}
}
