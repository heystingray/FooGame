import java.util.Observer;
import java.util.Observable;
import java.util.*;
import javafx.util.Pair;
import java.lang.Math;

public class containsPath extends WinCondition{
    private Player filler = new DefaultRandomAIPlayer(observable);


    public containsPath(Observable observable) {
        super(observable);
    }

    private Pair<Integer,Integer> t(int x, int y) {
        return new Pair<Integer,Integer>(x,y);
    }

    public Player checkForWinner(){
        for(Player p:playerlist){
            if(checkForPath(p)){
                return p;
            }
        }
        return null;
    }

    public boolean checkForPath(Player p){
        boolean path = false;
        int endColumn = (int)(Math.sqrt((double)boardstate.size()));
        int endRow=endColumn;
        Map<Pair<Integer,Integer>,Player> tempmap = boardstate;
        for(Map.Entry<Pair<Integer,Integer>,Player> entry : tempmap.entrySet()){
            Integer x = entry.getKey().getKey();
            Integer y = entry.getKey().getValue();
            if(x==0){
                flood(tempmap, x,y,p);
            }

        }
        for(Map.Entry<Pair<Integer,Integer>,Player> entry : tempmap.entrySet()){
            Integer x = entry.getKey().getKey();
            Integer y = entry.getKey().getValue();
            if(tempmap.get(entry)==filler && x==endColumn){
                path=true;
                break;
            }
        }
        //if we've found a path don't go through the process of flooding again
        if(!path){
            for(Map.Entry<Pair<Integer,Integer>,Player> entry : tempmap.entrySet()){
                Integer x = entry.getKey().getKey();
                Integer y = entry.getKey().getValue();
                if(y==0){
                    flood(tempmap, x,y,p);
                }
            }
            for(Map.Entry<Pair<Integer,Integer>,Player> entry :tempmap.entrySet()){
                Integer x = entry.getKey().getKey();
                Integer y = entry.getKey().getValue();
                if(tempmap.get(entry)==filler && y==endColumn){
                    path=true;
                    break;
                }
            }
        }
        return path;
    }
    public Map<Pair<Integer,Integer>,Player> flood(Map<Pair<Integer,Integer>,Player> map, Integer x, Integer y, Player p){
        //mark this point as checked
        map.put(t(x,y), filler);
        if(map.get(t(x+1,y))==p){ flood(map,x+1,y,p);}
        if(map.get(t(x-1,y))==p){flood(map,x-1,y,p);}
        if(map.get(t(x,y+1))==p){flood(map,x,y+1,p);}
        if(map.get(t(x+1,y-1))==p){flood(map,x,y-1,p);}
        return map;
    }

}
