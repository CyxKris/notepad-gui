package com.cyx.notepad.components;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class NotePanel extends JPanel {

    public NotePanel() {
        init();
    }

    public void init() {
        setLayout(new MigLayout("wrap, fillx, insets 20", "fill"));
        putClientProperty("JPanel.tabClosable", "true");
        add(new MenuBar());

    }
}
