package model;

import java.util.ArrayList;

public class BotManager {
    // A bot manager takes care of everything to do bots on the board.
    private ArrayList<Bot> bots;
    private int boardSize;

    public BotManager(int width) {
        bots = new ArrayList<>();
        boardSize = width;
    }

    public ArrayList<Bot> getBot() {
        return bots;
    }

    public Bot getBot(int i) {
        return bots.get(i);
    }

    public void addPlayerBot(Category category, int row) {
        bots.add(new Bot(category, true, 0, row));
    }

    public void addComputerBot(Category category, int row) {
        bots.add(new Bot(category, false, boardSize - 1, row));
    }

    public void removeBot(int i) {
        bots.remove(i);
    }
}
