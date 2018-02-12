import java.util.*;
import javafx.util.Pair;
import java.lang.Math;

public class MoveRule extends Rule {

  public MoveRule(Observable o) {
    super(o);
  }

  public boolean check(Move m) {
    try {
      MoveStone ms = (MoveStone)m;

      if ((ms.getTarget().getKey( ) > 5) || (ms.getTarget().getValue() > 5)) {
        return false;
      }

      if ((ms.getOrigin().getKey( ) > 5) || (ms.getOrigin().getValue() > 5)) {
        return false;
      }

      if (boardstate.get(ms.getTarget())==null) {
        return false;
      }
      if (boardstate.get(ms.getOrigin())!=ms.getPlayer()){
        return false;
      }
      return FooGame.checkAdjacency(ms.getOrigin(), ms.getTarget());
    } catch (ClassCastException e) {
      return true;
    }
  }

  //this static method should be moved into the FooGame class so it can be reused


  public static void main(String[] args) {
    Pair<Integer, Integer> c1 = new Pair<Integer, Integer>(2,3);
    Pair<Integer, Integer> c2 = new Pair<Integer, Integer>(2,4);
    Pair<Integer, Integer> c3 = new Pair<Integer, Integer>(3,4);
    Pair<Integer, Integer> c4 = new Pair<Integer, Integer>(1,1);

    System.out.println(FooGame.checkAdjacency(c1, c2)); //true
    System.out.println(FooGame.checkAdjacency(c2, c3)); //true
    System.out.println(FooGame.checkAdjacency(c3, c4)); //false
  }
}
