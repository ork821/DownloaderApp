package com.ork821;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private JPanel panel;
    private JScrollPane scrollPane;

    public MainWindow(String label) {
        super(label);
    }

    public void createGui() {
        this.setWindowSetup();
        this.createTopInputPanel();
        this.createScroll();
        this.createBottomButtons();
    }

    private void createBottomButtons() {
        GridBagConstraints c = new GridBagConstraints();
        JPanel buttons = new JPanel(new GridBagLayout());
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        JButton but1 = new JButton("Add to folder");
        JButton but2 = new JButton("Add to archive");
        buttons.add(but1, c);
        c.gridx = 1;
        buttons.add(but2, c);

        panel.add(buttons, BorderLayout.SOUTH);
    }

    private void createScroll() {
        this.scrollPane = new JScrollPane();
        panel.add(this.scrollPane, BorderLayout.CENTER);
    }

    private void createTopInputPanel() {
        GridBagConstraints c = new GridBagConstraints();
        JPanel inputPanel = new JPanel(new GridBagLayout());
        TextField textField = new TextField("Enter URL here:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        textField.setFocusable(false);
        inputPanel.add(textField, c);
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setFocusable(true);
                textField.requestFocus();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField.setText("Enter URL here:");
            }
        });

        JButton button = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.1;
        c.gridx = 1;
        c.gridy = 0;
        inputPanel.add(button, c);

        this.panel.add(inputPanel, BorderLayout.NORTH);
    }



    private void setWindowSetup() {
        this.panel = new JPanel(new BorderLayout());
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setBorder(padding);
        this.setContentPane(panel);


        // Set sizes of window and disable resize
        this.setSize(300, 300);
        this.setResizable(false);

        // Set action when close app
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set location from upper left corner
        this.setLocationByPlatform(true);

        // Set window visible
        this.setVisible(true);
    }
}
