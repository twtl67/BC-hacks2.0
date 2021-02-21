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
        panel.setLayout(new java.awt.GridLayout(5, 10));
        panel.setBackground(Color.BLACK);

        frame.add(panel);
        frame.setTitle("GAME TIME!");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(1000, 500);
        drawBoard();
        frame.setVisible(true);

        UIManager ui = new UIManager();
        ui.put("OptionPane.messageFont", new Font("Courier New", Font.BOLD, 15));
        ui.put("OptionPane.background", Color.DARK_GRAY);
        ui.put("OptionPane.messageForeground", Color.orange);
    }

    private void drawBoard() {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("./emptyIcon.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon craneIcon = new ImageIcon(new ImageIcon("./crane.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon craneIconFlipped = new ImageIcon(new ImageIcon("./craneFlipped.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));

//        Icon craneIcon = new ImageIcon("./crane.png");
//        Icon craneIconFlipped = new ImageIcon("./craneFlipped.png");

        for (int i = 0; i < 5; i++) {
            final JLabel playerCraneLabel = new JLabel(craneIcon);
            playerCraneLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            panel.add(playerCraneLabel);
            for (int j = 0; j <8; j++) {
                final JLabel label = new JLabel(imageIcon);
                String string = i + "" + j;
                label.setName(string);
                label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                setFontColour(label);
                panel.add(label);
            }
            final JLabel computerCraneLabel = new JLabel(craneIconFlipped);
            computerCraneLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            panel.add(computerCraneLabel);
        }
    }

    private void setFontColour(JLabel label) {
        label.setBackground(Color.BLACK);
        label.setForeground(Color.orange);
        label.setFont(font);
        panel.add(label);
    }
}
