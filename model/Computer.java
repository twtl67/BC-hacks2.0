package model;

public class Computer extends Player {
    private int nextRow;
    private int height;

    public Computer(int height) {
        super("Computer");
        this.height = height;
        generateNextRow();
    }

    public int getNextRow() {
        return nextRow;
    }

    public void generateNextRow() {
        nextRow = Math.random() * height;
    }
}