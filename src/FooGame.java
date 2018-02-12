import java.util.Observable;
import java.lang.Math;
import java.util.*;
import javafx.util.Pair;

public class FooGame extends Observable {
    protected Map<Pair<Integer,Integer>,Player> boardstate;
    protected ArrayList<Player> playerlist;
    protected ArrayList<Rule> ruleslist;
    protected ArrayList<WinCondition> winlist;
    protected FooGUI foogui;
    private Mode mode;
    private int turn = 0;
    private boolean started = false;

    public FooGame(Mode m) {
        mode = m;
        //System.out.println("setting board");
        boardstate = mode.setBoard();
        //System.out.println("setting players");
        playerlist = mode.setPlayers(this);
        //System.out.println("setting rules");
        ruleslist = mode.setRules(this);
        //System.out.println("setting win conditions");
        winlist = mode.setWinConditions(this);
        //System.out.println("setting GUI");
        foogui = mode.setGUI(this);
        showMove();
    }

    public void startGame(){
      if (!started) {
        started = true;
        nextTurn();
      }
    }

    public void addPlayer(Player p) {
    	playerlist.add(p);
    }

    public void removePlayer(Player p) {
    	playerlist.remove(p);
    }


    public void addRule(Rule r) {
    	ruleslist.add(r);
    }

    public void removeRule(Rule r) {
    	ruleslist.remove(r);
    }

    public Map<Pair<Integer,Integer>,Player> getBoardState() {
    	return new HashMap<Pair<Integer,Integer>,Player>(boardstate);
    }

    public ArrayList<Player> getPlayers() {
        return new ArrayList<Player>(playerlist);
    }

    public void nextTurn() {

    	Player currentPlayer = playerlist.get(turn%playerlist.size());
      //System.out.println(currentPlayer);
      System.out.println("Turn " + (turn+1) + ": " + currentPlayer);
    	turn++;

    	askMove(currentPlayer);

        Player winner = null;
        for (WinCondition wc : winlist) {
            winner = wc.checkForWinner();
        }

        if (winner != null) {
            declareWinner(winner);
        } else {
            nextTurn();
        }

    }

    private void askMove(Player p) {
    	Move currentMove = p.makeMove();
    	boolean valid = true;

    	for (Rule r: ruleslist) {
    		if (!r.check(currentMove)){
    			valid = false;
    			break;
    		}
    	}

    	if (valid) {
    		currentMove.alterBoard(boardstate);
    		showMove();
    	} else {
    		System.out.println("Invalid Move");
    		askMove(p);
    	}
    }

    public void showMove() {
      //notify observers that something has changed
      //change board state first
      setChanged();
      notifyObservers();
    }

    public static boolean checkAdjacency(Pair<Integer,Integer> c1, Pair<Integer,Integer> c2) {
    	return (c1.getKey()==c2.getKey()) && (Math.abs(c1.getValue()-c2.getValue())==1) || (c1.getValue()==c2.getValue()) && (Math.abs(c1.getKey()-c2.getKey())==1);
  	}

    private static void declareWinner(Player p) {
        System.out.println(p + " is the winner!");
        System.exit(0);
    }


    public static void main(String[] args) {
      System.out.println("let's play!");
      FooGame game = new FooGame(new Default());
      game.startGame();
      //System.out.println(game.getBoardState());
    }
  }
