package model;
public class Wall {
    // A wall has 3 lives at the beginning. It loses one life if a bot from the enemy team collides with it
    private int lives;

    public Wall() {
        lives = 3;
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }
}
