public class Board {
    private int[][] grid = new int[3][3];

    public Board() {

    }

    public boolean isValidMove(int x, int y) {
        return isWithinBounds(x, y) && isEmptyCell(x, y);
    }

    public void placeMove(int x, int y, int player) {
        grid[x][y] = player;
    }

    private boolean isEmptyCell(int x, int y) {
        return grid[x][y] == 0;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= 2 && y >= 0 && y <= 2;
    }

    private boolean playerHasWon(int player) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) {
                return true;
            }
        }
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[2][0] == player && grid[1][1] == player && grid[0][2] == player) {
            return true;
        }
        return false;
    }
}
