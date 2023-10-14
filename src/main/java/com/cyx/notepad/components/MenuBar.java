package com.cyx.notepad.components;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        init();
    }

    public void init() {
        setAlignmentX(LEFT_ALIGNMENT);

        add(new FileMenu());
        add(new EditMenu());
    }
}
