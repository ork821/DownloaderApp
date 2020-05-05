package com.ork821;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextFieldMouseListener implements MouseListener {


    private final JTextField textField;

    public TextFieldMouseListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.textField.setFocusable(true);
        this.textField.requestFocus();
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
}
