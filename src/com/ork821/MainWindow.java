package com.ork821;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.util.HashMap;


public class MainWindow extends JFrame {
    final HashMap<JButton, JPanel> inputList;
    private JPanel panel;

    private JScrollPane scrollPane;

    private JPanel mainList;


    public MainWindow(String label) {
        super(label);
        this.inputList = new HashMap<JButton, JPanel>();
    }

    public void createGui() {
        this.setWindowSetup();
        this.createTopInputPanel();
        this.createScroll();
        this.createBottomButtons();
    }

    public JPanel getMainList() {
        return this.mainList;
    }

    private void createBottomButtons() {
        GridBagConstraints c = new GridBagConstraints();
        JPanel buttons = new JPanel(new GridBagLayout());
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        JButton but1 = new JButton("Add to folder");
        but1.addActionListener(new AddToFolderActionHandler(inputList));
        JButton but2 = new JButton("Add to archive");
        buttons.add(but1, c);
        c.gridx = 1;
        buttons.add(but2, c);

        panel.add(buttons, BorderLayout.SOUTH);
    }

    private void createScroll() {
        this.mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.scrollPane = new JScrollPane(this.mainList);
        panel.add(this.scrollPane, BorderLayout.CENTER);
    }

    private void createTopInputPanel() {
        GridBagConstraints c = new GridBagConstraints();
        JPanel inputPanel = new JPanel(new GridBagLayout());

        JButton button = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        button.addActionListener(new AddButtonActionListener(this));
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
