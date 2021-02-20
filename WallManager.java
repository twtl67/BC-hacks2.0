package model;

public class WallManager {
    // A wall manager takes care of everything to do walls on the board.
    // Each player has HEIGHT walls with 3 lives each.
    private Wall[] playerWall;
    private Wall[] computerWall;

    public WallManager(int height) {
        playerWall = new Wall[height];
        computerWall = new Wall[height];
        for (int i = 0; i < height; i++) {
            playerWall[i] = new Wall();
            computerWall[i] = new Wall();
        }
    }

    public Wall[] getPlayerWall() {
        return playerWall;
    }

    public Wall[] getComputerWall() {
        return computerWall;
    }

    public Wall getPlayerWall(int i) {
        return playerWall[i];
    }

    public Wall getComputerWall(int i) {
        return computerWall[i];
    }
}
