package com.cyx.notepad.components;

import java.awt.*;
import javax.swing.*;
// import net.miginfocom.swing.MigLayout;

public class TabMenu extends JTabbedPane {

    public TabMenu() {
        init();
    }


    void init() {
        // setLayout(new MigLayout());
        
        // JButton addButton = new JButton();
        // Icon addIcon = new ImageIcon("images/plus-icon.png");
        // addButton.setIcon(addIcon);
        // addButton.setBorder(null);
        // addButton.setContentAreaFilled(false);
        // setPreferredSize(new Dimension(30, 30));

        
        addTab("New", new NotePanel());
        // setTabComponentAt(0, new NotePanel());
        // setC
        // setComponentAt(0, new NotePanel());
        JComponent component = (JComponent) getTabComponentAt(0);
        component.putClientProperty("JTabbedPane.tabClosable", "true");

        // insertTab("", null, null, "", getTabCount());
        // setTabComponentAt(getTabCount() - 1, addButton);
        
    }
} 
