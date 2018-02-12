import java.util.*;
import javafx.util.Pair;

public class PlaceRule extends Rule {

  public PlaceRule(Observable o) {
  	super(o);
  }

  public boolean check(Move m) {
    try {
      PlaceStone ps = (PlaceStone)m;
      if ((ps.getTarget().getKey() > 5) || (ps.getTarget().getValue() > 5)) {
      	return false;
      }
      if ((ps.getTarget().getKey() < 0) || (ps.getTarget().getValue() < 0)) {
      	return false;
      }
      return boardstate.get(ps.getTarget()) == null;
    } catch (ClassCastException e) {
      return true;
    }
  }
}
