package ui;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private Board board;
    private final int TESTHEIGHT = 3;
    private final int TESTWIDTH = 3;
    private Player player;
    private String name; //name of the player


    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public GUI(){
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Time to Tic Tac Toe!");
        frame.add(panel);

        init();
    }

    private void init(){
        //having a dialog box for name input
        UIManager ui = new UIManager();
        ui.put("OptionPane.messageFont", new Font("Courier New", Font.BOLD, 15));
        ui.put("OptionPane.background", Color.DARK_GRAY);
        ui.put("OptionPane.messageForeground", Color.BLACK);
        name = String.valueOf(JOptionPane.showInputDialog(null,
                "Enter name for player 1",
                "Player setting",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                ""));

        player = new Player(name);
        board = new Board(TESTHEIGHT, TESTWIDTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
