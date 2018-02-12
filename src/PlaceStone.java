import java.util.*;
import javafx.util.Pair;

public class PlaceStone extends Move {
  private Pair<Integer,Integer> target;

  public PlaceStone(Player p, Pair<Integer,Integer> c) {
    super(p);
    target = c;
  }

  public  Map<Pair<Integer,Integer>,Player> alterBoard(Map<Pair<Integer,Integer>,Player> boardstate) {
      //System.out.println(player);
      player.useStone();
      boardstate.put(target, player);
      return boardstate;
  }

  public Pair<Integer,Integer> getTarget() {
    return target;
  }

  public static void main(String[] args) {
    FooGame game = new FooGame(new Default());
    Player p = new DefaultRandomAIPlayer(game);
    PlaceStone ps = new PlaceStone(p, new Pair<Integer,Integer>(1,1));
    Map<Pair<Integer,Integer>,Player> bs = game.getBoardState();
    System.out.println(bs);
    System.out.println(p.getStones());
    ps.alterBoard(bs);
    System.out.println(bs);
    System.out.println(p.getStones());
  }
}
