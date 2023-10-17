package com.cyx.notepad.components;

// import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.FileWriter;

import org.apache.commons.io.FileUtils;

import raven.toast.Notifications;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class FileMenu extends JMenu {
    private JMenuItem openItem, saveItem, saveAsItem, exitItem;
    JFileChooser fileChooser = new JFileChooser();

    public FileMenu() {
        init();
    }

    public void init() {
        setText("File");

        openItem = new JMenuItem("Open");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });


        saveItem = new JMenuItem("Save");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });


        saveAsItem = new JMenuItem("Save As");
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        saveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemActionPerformed(evt);
            }
        });


        exitItem = new JMenuItem("Exit");
        // exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });


        // saveAllItem = new JMenuItem("Save All");


        add(openItem);
        add(saveItem);
        add(saveAsItem);
        add(new JSeparator());
        add(exitItem);
        // add(saveAllItem);
    }

    protected void exitItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    protected void saveAsItemActionPerformed(ActionEvent evt) {
        try {
            // fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\cyxkr\\Documents\\Programming\\Java\\"));
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                // String fileData = NotePanel.getInstance().editorPane.getText();
                String fileData = NotePanel.editorPane.getText();

                // file.createNewFile();
                if (file.createNewFile()) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT,
                            "File created successfully!");
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT,
                            "Error in creating file");
                }

                FileWriter writer = new FileWriter(file);
                writer.write(fileData);

                writer.close();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // FIXME: Implement the save feature...
    protected void saveItemActionPerformed(ActionEvent evt) {
        try {
            
            // FileWriter fileWriter = new FileWriter("simple.txt");
            // fileWriter.write(NotePanel.editorPane.getText());
            // fileWriter.close();

            // fileChooser = new JFileChooser();
            // fileChooser.setCurrentDirectory(new File("C:\\Users\\cyxkr\\Documents\\Programming\\Java\\"));
            // int response = fileChooser.showSaveDialog(null);
            // File file = fileChooser.getCurrentDirectory().getAbsoluteFile();
            // String fileData = NotePanel.editorPane.getText();

            // FileWriter writer = new FileWriter(file);

            // writer.write(fileData);

            // writer.close();

            
            // if (response == JFileChooser.APPROVE_OPTION) {
            //     File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

            //     // String fileData = NotePanel.getInstance().editorPane.getText();
            //     String fileData = NotePanel.editorPane.getText();

            //     if (file.exists()) {
            //         FileWriter fileWriter = new FileWriter(file);
            //         fileWriter.write(fileData);

            //         Notifications.getInstance().show(Notifications.Type.SUCCESS,
            //                 Notifications.Location.BOTTOM_RIGHT,
            //                 "File saved successfully!");
            //     } else {
            //         Notifications.getInstance().show(Notifications.Type.ERROR,
            //                 Notifications.Location.BOTTOM_RIGHT,
            //                 "Error. Choose Save As option");
            //     }

            //     FileWriter writer = new FileWriter(file);
            //     writer.write(fileData);

            //     writer.close();
            // }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void openItemActionPerformed(ActionEvent evt) {
        try {
            // fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\cyxkr\\Documents\\Programming\\Java\\"));
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                String fileString = FileUtils.readFileToString(file, "UTF-8");
                // NotePanel.getInstance().editorPane.setText(fileString);
                NotePanel.editorPane.setText(fileString);

                TabMenu tabMenu = new TabMenu();
                tabMenu.setTitleAt(0, fileChooser.getName(file));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
