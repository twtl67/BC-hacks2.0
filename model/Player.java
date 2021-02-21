package model;

public class Player {
    private String name;
    private enum nextBot;

    public Player(String name) {
        this.name = name;
        nextBot = generateNextBot();
    }

    public String getName(){
        return name;
    }

    public enum getNextBot() {
        enum temp = nextBot;
        generateNextBot();
        return temp;
    }

    public void generateNextBot() {
        switch(Math.random() * 3) {
            case 0:
                nextBot = Rock;
                break;
            case 1:
                nextBot = Paper;
                break;
            case 2:
                nextBot = Scissors;
                break;
        }
    }
}
