package model;

public class Board {
    // A board has a list of bots on the screen, and the wall strength on either side
    private Bot[][] board;
    private Wall[] playerWall;
    private Wall[] computerWall;

    final int width = 8;
    final int height = 7;

    public Board() {
        board = new Bot[height][width];
        playerWall = new Wall[height];
        computerWall = new Wall[height];
        for (int i = 0; i < height; i++) {
            playerWall[i] = new Wall();
            computerWall[i] = new Wall();
        }
    }

    public Bot[][] getBoard() {
        return board;
    }

    public Bot getBot(int row, int column) {
        return board[row][column];
    }

    public void addPlayerBot(Category category, int row) {
        board[row][0] = new Bot(category, true, 0, row);
    }

    public void addComputerBot(Category category, int row) {
        board[row][width - 1] = new Bot(category, false, width - 1, row);
    }

    public void removeBot(int row, int column) {
        board[row][column] = null;
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

    // advances all the bots, solves collisions between bots and walls
    // returns 1 if game is still going on
    // returns 2 if computer wins
    // returns 3 if player wins
    private int tick() {
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < height; c++) {
                if (getBot(r, c) != null) {
                    int nextCord = getBot(r, c).advance();
                    switch (nextCord) {
                        case -1:
                            if (getPlayerWall(r).loseLife() == -1) {
                                return 2;
                            }
                            break;
                        case width:
                            if (getComputerWall(r).loseLife() == -1) {
                                return 3;
                            }
                            break;
                        default:
                            if (getBot(nextCord, c) != null) {
                                switch (collide(getBot(r, nextCord), getBot(r, c))) {
                                    case 0:
                                        removeBot(r, nextCord);
                                        removeBot(r, c);
                                        break;
                                    case 1:
                                        removeBot(r, c);
                                        break;
                                    case 2:
                                        // there's a bug right here because the bot can be advanced again in the same cycle
                                        board[r][nextCord] = getBot(r, c);
                                        break;
                                }
                            } else {
                                // same right here
                                board[r][nextCord] = getBot(r, c);
                            }
                    }
                }
            }
        }
        return 1;
    }

    // returns the number of the bot that wins
    public int collide(Bot bot1, Bot bot2) {
        if (bot1.getCategory() == bot2.getCategory()) {
            return 0;
        }
        switch (bot1.getCategory()) {
            case Rock:
                switch (bot2.getCategory()) {
                    case Scissors:
                        return 1;
                    case Paper:
                        return 2;
                }
            case Paper:
                switch (bot2.getCategory()) {
                    case Rock:
                        return 1;
                    case Scissors:
                        return 2;
                }
            case Scissors:
                switch (bot2.getCategory()) {
                    case Paper:
                        return 1;
                    case Rock:
                        return 2;
                }
        }
        return 0;
    }
}
