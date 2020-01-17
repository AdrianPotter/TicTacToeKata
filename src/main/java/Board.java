public class Board {
    private int [][] grid = new int[3][3];

    public Board() {

    }

    public boolean isValidMove(int x, int y){
        return isWithinBounds(x, y) && isEmptyCell(x, y);
    }

    public void placeMove (int x, int y, int player) {
        grid[x][y] = player;
    }

    private boolean isEmptyCell(int x, int y) {
        return grid[x][y] == 0;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= 2 && y >= 0 && y <= 2;
    }
}
