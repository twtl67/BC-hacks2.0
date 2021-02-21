<<<<<<< HEAD:model/Wall.java
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

    public int loseLife() {
        lives--;
        return lives;
    }
}
=======
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

    public int loseLife() {
        lives--;
        return lives;
    }
}
>>>>>>> e1ad5d8c3171bdaebca6d07549ae9b11ec4ba47c:Wall.java
