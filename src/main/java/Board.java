public class Board {
    int [][] grid = new int[3][3];
    int player1 = 1;
    int player2 = 2;

    public Board() {

    }



    public boolean isValidMove(int x, int y){
        if (x < 0 || x > 2 || y < 0 || y > 2)
        {
            return false;
        }
        /*else if(grid[x][y] != 0)
        {
            return false;
        }*/
        return true;
    }
}
