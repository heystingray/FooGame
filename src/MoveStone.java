import java.util.*;
import javafx.util.Pair;

public class MoveStone extends Move {
  private Pair<Integer,Integer> origin;
  private Pair<Integer,Integer> target;

  public MoveStone(Player p, Pair<Integer,Integer> c1, Pair<Integer,Integer> c2) {
    super(p);
    origin = c1;
    target = c2;
  }

  public  Map<Pair<Integer,Integer>,Player> alterBoard(Map<Pair<Integer,Integer>,Player> boardstate) {
      boardstate.put(target, boardstate.get(origin));
      boardstate.put(origin, null);
      return boardstate;
  }

  public Pair<Integer,Integer> getOrigin() {
    return origin;
  }

  public Pair<Integer,Integer> getTarget() {
    return target;
  }
}
