package model;

public class Bot {
    // A bot has a category, a direction it faces, and its position on the board
    private Category category;
    private boolean playerOwned;

    // Top-left box on the board is (0,0)
    private double x;
    private int y;

    // Constructor
    public Bot(Category category, boolean playerOwned, int column, int row) {
        this.category = category;
        this.playerOwned = playerOwned;
        this.x = column;
        this.y = row;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getPlayerOwned() {
        return playerOwned;
    }

    public double getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
