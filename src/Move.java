import java.util.*;
import javafx.util.Pair;


public abstract class Move {
  protected Player player;

  public Move(Player p) {
    player = p;
  }

  public abstract Map<Pair<Integer,Integer>,Player> alterBoard(Map<Pair<Integer,Integer>,Player> boardstate);

  public Player getPlayer() {
    return player;
  }

}
