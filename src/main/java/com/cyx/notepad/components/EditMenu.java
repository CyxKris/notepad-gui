package com.cyx.notepad.components;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {
    private JMenuItem cutItem, copyItem, pasteItem;

    public EditMenu() {
        init();
    }

    public void init() {
        setText("Edit");

        cutItem = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");


        add(cutItem);
        add(copyItem);
        add(pasteItem);
    }
}
