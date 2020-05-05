package com.ork821;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;



public class AddButtonActionListener implements ActionListener {

    HashMap<JButton, JPanel> urlFields;

    private int position = 0;

    private final MainWindow window;

    public AddButtonActionListener(MainWindow window) {
        this.window = window;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridBagConstraints c = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());
        JTextField textField = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(textField, c);

        JButton button = new JButton("-");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = window.getInputList().get(button);
                window.getMainList().remove(panel);
                position--;
                window.validate();
                window.repaint();
            }
        });
        c.weightx = 0.1;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(button, c);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        window.getMainList().add(panel, gbc, position++);
        window.getInputList().put(button, panel);
        window.validate();
        window.repaint();
    }

}
