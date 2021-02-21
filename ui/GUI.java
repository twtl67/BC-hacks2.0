package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public GUI(){
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Time to Tic Tac Toe!");
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
