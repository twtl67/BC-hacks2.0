package model;


public class Board {
    // A board has a list of bots on the screen, and the wall strength on either side
    private Bot[][] board_bot;
    private Wall[] playerWall;
    private Wall[] computerWall;
    private Computer comp;

    final int HEIGHT = 5;
    final int WIDTH = 8;



    public Board() {
        board_bot = new Bot[HEIGHT][WIDTH];
        playerWall = new Wall[HEIGHT];
        computerWall = new Wall[HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
            playerWall[i] = new Wall();
            computerWall[i] = new Wall();
        }
        comp = new Computer(HEIGHT);
    }

    public Bot[][] getBoard_bot() {
        return board_bot;
    }

    public Bot getBot(int row, int column) {
        return board_bot[row][column];
    }

    public void addPlayerBot(Category category, int row) {
        board_bot[row][0] = new Bot(category, true);
    }

    public void addComputerBot(Category category, int row) {
        board_bot[row][WIDTH - 1] = new Bot(category, false);
    }

    public void removeBot(int row, int column) {
        board_bot[row][column] = null;
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
        for (int r = 0; r < WIDTH; r++) {
            for (int c = 0; c < HEIGHT; c++) {
                if (getBot(r, c) != null && !getBot(r, c).getMoved()) {
                    int nextCord;
                    if (getBot(r, c).getPlayerOwned()) {
                        nextCord = c + 1;
                    } else {
                        nextCord = c - 1;
                    }
                    switch (nextCord) {
                        case -1:
                            if (getPlayerWall(r).loseLife() == -1) {
                                return 2;
                            }
                            break;
                        case WIDTH:
                            if (getComputerWall(r).loseLife() == -1) {
                                return 3;
                            }
                            break;
                        default:
                            collision_result(nextCord, r, c);
                    }
                }
            }
        }

        for (int r = 0; r < WIDTH; r++) {
            for (int c = 0; c < HEIGHT; c++) {
                if (getBot(r,c) != null) {
                    getBot(r,c).setMoved(false);
                }
            }
        }

        return 1;
    }

    public void collision_result(int nextCord, int r, int c) {
        // bot 1 = nextCord one
        Bot bot1 = getBot(nextCord, c);
        Bot bot2 = getBot(r, c);
        if (bot1 != null) {
            switch (collide(bot1, bot2)) {
                // check collisions b/w 2 bots
                case 0:
                    // 0 = no one wins, both bots removed only; no advancements
                    removeBot(nextCord, c);
                    removeBot(r, c);
                    break;
                case 1:
                    // bot1 wins, bot 2 removed
                    removeBot(r, c);
                    break;
                case 2:
                    // bot 2 wins, bot 1 removed
                    removeBot(r, c);
                    board_bot[nextCord][c] = bot2;
                    bot2.setMoved(true);
                    break;
            }
        } else {
            removeBot(r, c);
            board_bot[nextCord][c] = bot2;
            bot2.setMoved(true);
        }
    }

    // returns the number of the bot that wins
    // 0 = no one wins
    // 1 = bot 1 wins
    // 2 = bot 2 wins
    public int collide(Bot bot1, Bot bot2) {
        int result = 0;
        if (bot1.getCategory() == bot2.getCategory()) {
            // result = 0;
        } else {
            switch (bot1.getCategory()) {
                case Rock:
                    switch (bot2.getCategory()) {
                        case Scissors:
                            result = 1;
                        case Paper:
                            result = 2;
                    }
                case Paper:
                    switch (bot2.getCategory()) {
                        case Rock:
                            result = 1;
                        case Scissors:
                            result = 2;
                    }
                case Scissors:
                    switch (bot2.getCategory()) {
                        case Paper:
                            result = 1;
                        case Rock:
                            result = 2;
                    }
            }
        }
        return result;
    }
}
