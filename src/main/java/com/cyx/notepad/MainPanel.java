package com.cyx.notepad;

import javax.swing.*;

import com.cyx.notepad.components.MenuBar;

import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {

    public MainPanel() {
        init();
    }

    public void init() {
        setLayout(new MigLayout());

        add(new MenuBar());
    }
}
