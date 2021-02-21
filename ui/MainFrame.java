package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel contentPane;

    public MainFrame() {
        setResizable(false);
        setTitle("Robinion Crash");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 2000);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
    }
}
