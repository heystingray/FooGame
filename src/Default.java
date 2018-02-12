import java.util.*;
import javafx.util.Pair;

public class Default implements Mode {

	public ArrayList<Player> setPlayers(Observable o) {
		ArrayList<Player> plist = new ArrayList<Player>();
		plist.add(new HumanPlayer(o, "Player 1"));
		plist.add(new HumanPlayer(o, "Player 2"));
		return plist;
	}

	public ArrayList<Rule> setRules(Observable o) {
		ArrayList<Rule> rlist = new ArrayList<Rule>();
		rlist.add(new PlaceRule(o));
		rlist.add(new MoveRule(o));
		return rlist;

	}

	public Map<Pair<Integer,Integer>,Player> setBoard() {
		Map<Pair<Integer,Integer>,Player> bm = new HashMap<Pair<Integer,Integer>,Player>();
		for (int i=1; i<6; i++) {
			for (int i2=1; i2<6; i2++) {
				bm.put(new Pair<Integer,Integer>(i,i2), null);
			}
		}
		return bm;
	}

	public ArrayList<WinCondition> setWinConditions(Observable o) {
		ArrayList<WinCondition> wlist = new ArrayList<WinCondition>();
		wlist.add(new containsPath(o));
		wlist.add(new maxStones(o));
		return wlist;
	}

	public FooGUI setGUI(Observable o) {
		return new TextGUI(o);
	}
}
