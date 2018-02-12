import java.util.*;
import javafx.util.Pair;

public class AIvsAI extends Default {
  public ArrayList<Player> setPlayers(Observable o) {
		ArrayList<Player> plist = new ArrayList<Player>();
		plist.add(new DefaultRandomAIPlayer(o, "Computer1"));
		plist.add(new DefaultRandomAIPlayer(o, "Computer2"));
		return plist;
	}
}
