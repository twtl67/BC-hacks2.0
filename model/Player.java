package model;
import java.lang.Math;

public class Player {
    private String name;
    private Category nextBot;

    public Player(String name) {
        this.name = name;
        generateNextBot();
    }

    public String getName(){
        return name;
    }

    public Category getNextBot() {
        Category temp = nextBot;
        generateNextBot();
        return temp;
    }

    public void generateNextBot() {
        switch((int) (Math.random() * 3)) {
            case 0:
                nextBot = Category.Rock;
                break;
            case 1:
                nextBot = Category.Paper;
                break;
            case 2:
                nextBot = Category.Scissors;
                break;
        }
    }
}
