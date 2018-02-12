import java.util.*;
import javafx.util.Pair;

public interface Mode {

	public ArrayList<Player> setPlayers(Observable o);

	public ArrayList<Rule> setRules(Observable o);

	public Map<Pair<Integer,Integer>,Player> setBoard();

	public ArrayList<WinCondition> setWinConditions(Observable o);

	public FooGUI setGUI(Observable o);
}
