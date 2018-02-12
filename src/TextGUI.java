import java.util.*;
import javafx.util.Pair;

public class TextGUI extends FooGUI {

  public TextGUI(Observable o) {
    super(o);
  }

  private void print(Object input) {
    if (input == null) {
      System.out.print(" ");
    } else if (input instanceof Player){
      System.out.print(playerlist.indexOf((Player)input)+1);
    } else {
      System.out.print(input);
    }
  }

  private void println(Object input){
    System.out.println(input);
  }

  private void println() {
    System.out.println();
  }

  private Pair<Integer,Integer> t(int x, int y) {
    return new Pair<Integer,Integer>(x,y);
  }

  public void draw() {
    println("---------------------");
    print("| ");
    print(boardstate.get(t(1,5)));
    print(" | ");
    print(boardstate.get(t(2,5)));
    print(" | ");
    print(boardstate.get(t(3,5)));
    print(" | ");
    print(boardstate.get(t(4,5)));
    print(" | ");
    print(boardstate.get(t(5,5)));
    print(" |");
    println();

    println("---------------------");
    print("| ");
    print(boardstate.get(t(1,4)));
    print(" | ");
    print(boardstate.get(t(2,4)));
    print(" | ");
    print(boardstate.get(t(3,4)));
    print(" | ");
    print(boardstate.get(t(4,4)));
    print(" | ");
    print(boardstate.get(t(5,4)));
    print(" |");
    println();

    println("---------------------");
    print("| ");
    print(boardstate.get(t(1,3)));
    print(" | ");
    print(boardstate.get(t(2,3)));
    print(" | ");
    print(boardstate.get(t(3,3)));
    print(" | ");
    print(boardstate.get(t(4,3)));
    print(" | ");
    print(boardstate.get(t(5,3)));
    print(" |");
    println();

    println("---------------------");
    print("| ");
    print(boardstate.get(t(1,2)));
    print(" | ");
    print(boardstate.get(t(2,2)));
    print(" | ");
    print(boardstate.get(t(3,2)));
    print(" | ");
    print(boardstate.get(t(4,2)));
    print(" | ");
    print(boardstate.get(t(5,2)));
    print(" |");
    println();

    println("---------------------");
    print("| ");
    print(boardstate.get(t(1,1)));
    print(" | ");
    print(boardstate.get(t(2,1)));
    print(" | ");
    print(boardstate.get(t(3,1)));
    print(" | ");
    print(boardstate.get(t(4,1)));
    print(" | ");
    print(boardstate.get(t(5,1)));
    print(" |");
    println();
    println("---------------------");

  }

  public static void main(String[] args) {
    Map<Pair<Integer,Integer>,Player> bm = new HashMap<Pair<Integer,Integer>,Player>();
		for (int i=1; i<6; i++) {
			for (int i2=1; i2<6; i++) {
				bm.put(new Pair<Integer,Integer>(i,i2), null);
			}
		}


  }
}
