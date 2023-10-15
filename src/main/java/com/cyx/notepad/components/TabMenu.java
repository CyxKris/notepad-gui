package com.cyx.notepad.components;

import javax.swing.*;
// import net.miginfocom.swing.MigLayout;
import javax.swing.plaf.DimensionUIResource;

public class TabMenu extends JTabbedPane {

    public TabMenu(int another, int some) {
        init();
    }


    void init() {
        // setLayout(new MigLayout());
        
        JButton addButton = new JButton();
        Icon addIcon = new ImageIcon("images/plus-icon.png");
        addButton.setIcon(addIcon);
        addButton.setBorder(null);
        addButton.setContentAreaFilled(false);
        setPreferredSize(new DimensionUIResource(30, 30));
        
        
        
        add("untitled", new NotePanel());
        // add("New", new NotePanel());

        insertTab("", null, null, "", getTabCount());
        setTabComponentAt(getTabCount() - 1, addButton);
        
    }
} 
