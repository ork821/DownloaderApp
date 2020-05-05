package com.ork821;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow window = new MainWindow("Downloader");
                window.createGui();
            }
        });
    }
}
