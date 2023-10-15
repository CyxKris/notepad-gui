package com.cyx.notepad;

import javax.swing.*;

import com.cyx.notepad.components.TabMenu;

import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {

    public MainPanel() {
        init();
    }

    public void init() {
        setLayout(new MigLayout());
        add(new TabMenu(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT));
    }
}
