package model;

public class Board {
    // A board has a bot manager and a wall manager
    private BotManager bm;
    private WallManager wm;

    final int width = 8;
    final int height = 7;

    public Board() {
        bm = new BotManager(width);
        wm = new WallManager(height);
    }
}
