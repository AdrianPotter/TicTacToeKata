import java.util.ArrayList;

public class Grid {
    ArrayList<Player> grid = new ArrayList<Player>();
    private final int GRIDSIZE = 9;

    public Grid(){
        for(int i = 0; i < GRIDSIZE; i++){
            grid.add(null);
        }
    }


    public Player getCell(int index){
        return grid.get(index);
    }

    public void setCell(int index, Player player){
        grid.set(index, player);
    }

    public int getGridSize(){
        return grid.size();
    }

    public boolean hasEmptyCell(){
        return grid.contains(null);
    }
}
