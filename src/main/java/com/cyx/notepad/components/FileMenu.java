package com.cyx.notepad.components;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {
    private JMenuItem openItem, saveItem, saveAsItem, saveAllItem;

    public FileMenu() {
        init();
    }

    public void init() {
        setText("File");

        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As");
        saveAllItem = new JMenuItem("Save All");


        add(openItem);
        add(saveItem);
        add(saveAsItem);
        add(saveAllItem);
    }
}
