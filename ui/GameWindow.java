package ui;

import model.*;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private Board board;
    Font font = new Font("Courier New", Font.BOLD, 25);
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    //making a new window to play the tic tac toe game
    public GameWindow(Board board) {
        this.board = board;

        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(5, 9));
        panel.setBackground(Color.BLACK);

        frame.add(panel);
        frame.setTitle("GAME TIME!");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(900, 500);
        drawBoard();
        frame.setVisible(true);

        UIManager ui = new UIManager();
        ui.put("OptionPane.messageFont", new Font("Courier New", Font.BOLD, 15));
        ui.put("OptionPane.background", Color.DARK_GRAY);
        ui.put("OptionPane.messageForeground", Color.orange);
    }

    private void drawBoard() {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("./emptyIcon.png").getImage().
                getScaledInstance(25, 25, Image.SCALE_DEFAULT));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                final JLabel label = new JLabel(imageIcon);
                String string = i + "" + j;
                label.setName(string);
                label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                setFontColour(label);
                panel.add(label);
            }
        }
    }

    private void setFontColour(JLabel label) {
        label.setBackground(Color.BLACK);
        label.setForeground(Color.orange);
        label.setFont(font);
        panel.add(label);
    }
}
