package com.ork821;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class AddToFolderActionHandler implements ActionListener {
    private ArrayList<File> fileList;
    private HashMap<JButton, JPanel> inputList;

    public AddToFolderActionHandler(HashMap<JButton, JPanel> inputList) {
        this.inputList = inputList;
        this.fileList = new ArrayList<File>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JPanel panel : inputList.values()) {
            try {
                JTextField textField = (JTextField) panel.getComponent(0);
                String url = textField.getText();
                File file = new UrlDownloaderFactory().downloadFile(url);
                fileList.add(file);
            } catch (Exception exception) {
                exception.getMessage();
            }
        }
        this.moveFilesToFolder();
    }

    private void moveFilesToFolder() {
        File folder = new File("folder");
        folder.mkdir();
        for (File file : fileList) {
            try {
                folder = new File("folder/" + file.getName());
                Files.copy(file.toPath(), folder.toPath());
                file.delete();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
