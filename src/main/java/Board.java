public class Board {
    int xDim = 3;
    int yDim = 3;

    int board[][] = new int[xDim][yDim];

    public boolean checkIfLegal(int x, int y) {
        if(x < 0 || x > xDim - 1 || y < 0 || y > yDim - 1) {
            return false;
        }
        else if(board[x][y] != 0){
            return false;
        }
        return true;
    }

    public void placeMove (int x, int y, int player) {
        board[x][y] = player;
        System.out.println("Successful Move!");
    }

}
