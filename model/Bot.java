
package model;

public class Bot {
    // A bot has a category, a direction it faces
    private Category category;
    private boolean playerOwned;
    private boolean moved;

    // Constructor
    public Bot(Category category, boolean playerOwned) {
        this.category = category;
        this.playerOwned = playerOwned;
        this.moved = true;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getPlayerOwned() {
        return playerOwned;
    }

    public boolean getMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
