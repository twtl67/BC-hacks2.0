package ui;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private Board board;
    private Player player;
    private String name; //name of the player


    private JButton play;
    private JButton rules;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private Font font = new Font("Courier New", Font.BOLD, 25);

    public GUI(){
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Time to Tic Tac Toe!");
        frame.add(panel);

        init();
        displayMenu();

        //panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(Color.BLACK);
        //frame.pack();
        frame.setVisible(true);

        UIManager ui = new UIManager();
        ui.put("OptionPane.messageFont", new Font("Courier New", Font.BOLD, 15));
        ui.put("OptionPane.background", Color.DARK_GRAY);
        ui.put("OptionPane.messageForeground", Color.orange);
    }

    private void init(){
        //having a dialog box for name input
        Icon image = new ImageIcon("./dexter.png");
        UIManager ui = new UIManager();
        ui.put("OptionPane.messageFont", new Font("Courier New", Font.BOLD, 15));
        ui.put("OptionPane.background", Color.DARK_GRAY);
        ui.put("OptionPane.messageForeground", Color.BLACK);
        name = String.valueOf(JOptionPane.showInputDialog(null,
                "Enter name of player",
                "Player setting",
                JOptionPane.INFORMATION_MESSAGE,
                image,
                null,
                ""));

        player = new Player(name);
        board = new Board();
    }

    private void displayMenu() {
        play = new JButton("Play game");
        play.setActionCommand("play");
        play.addActionListener(this);
        play.setBackground(Color.BLACK);

        rules = new JButton("Show me the rules");
        rules.setActionCommand("rules");
        rules.addActionListener(this);
        rules.setBackground(Color.BLACK);

        setFontColour(play);
        setFontColour(rules);
    }

    // MODIFIES: this
    // EFFECTS: change the font and colour of button
    private void setFontColour(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.orange);
        button.setFont(font);
        panel.add(button);
    }

    private void popup(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg,
                title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "play":
                break;
            case "rules":
                popup("we put in the rules here...", "Rules");
                break;
        }
    }
}
