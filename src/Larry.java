import java.util.*;
import javafx.util.Pair;

public class Larry extends Player {
    private int failsafe = 0;
    private int limit = 50;
    private Player helper = new DefaultRandomAIPlayer(observable);

    public Larry(Observable o) {
        super(o, "Larry");
    }

    private Pair<Integer,Integer> t(int x, int y) {
        return new Pair<Integer,Integer>(x,y);
    }


    //Larry is always trying to destroy his opponent's stones, so he will always move a stone when he can and place a stone next to his opponent's when he can't move a stone
    public Move makeMove() {
        ArrayList<Pair<Integer,Integer>> opponent_spaces = new ArrayList<Pair<Integer,Integer>>();
        ArrayList<Pair<Integer,Integer>> my_spaces = new ArrayList<Pair<Integer,Integer>>();

        for (Pair<Integer,Integer> key : boardstate.keySet()) {
            Player value = boardstate.get(key);
            if (value == this) {
                my_spaces.add(key);
            }
            if (value != null && value != this) {
                opponent_spaces.add(key);
            }
        }

        for (Pair<Integer,Integer> my_space : my_spaces) {
            for (Pair<Integer,Integer> o_space : opponent_spaces) {
                if (FooGame.checkAdjacency(my_space, o_space)) {
                    return new MoveStone(this, my_space, o_space);
                }
            }
        }

        return randomAdjacent(opponent_spaces);

    }

    private Move randomAdjacent(ArrayList<Pair<Integer,Integer>> spaces) {
        failsafe++;
        if (failsafe>limit) {
            failsafe=0;
            return helper.makeMove();
        }
        Random rand = new Random();
        Pair<Integer,Integer> choice = spaces.get(rand.nextInt(spaces.size()));
        ArrayList<Pair<Integer,Integer>> aspaces = new ArrayList<Pair<Integer,Integer>>();
        aspaces.add(t(choice.getKey()+1, choice.getValue()));
        aspaces.add(t(choice.getKey()-1, choice.getValue()));
        aspaces.add(t(choice.getKey(), choice.getValue()+1));
        aspaces.add(t(choice.getKey(), choice.getValue()-1));
        Pair<Integer,Integer> achoice = aspaces.get(rand.nextInt(aspaces.size()));
        if (boardstate.getOrDefault(achoice, this) == null) {
            failsafe = 0;
            return new PlaceStone(this, achoice);
        } else {
            return randomAdjacent(spaces);
        }
    }
}
