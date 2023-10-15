package com.cyx.notepad;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

import javax.swing.*;

import com.cyx.notepad.components.NotePanel;
import com.cyx.notepad.components.TabMenu;

import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {

    public MainPanel() {
        init();
    }

    public void init() {
        setLayout(new MigLayout("wrap, fillx", "fill"));

        TabMenu tabMenu = new TabMenu();
        tabMenu.putClientProperty("JTabbedPane.tabType", "card");
        tabMenu.putClientProperty("JTabbedPane.tabClosable", "true");
        tabMenu.putClientProperty( "JTabbedPane.tabCloseCallback",
            (BiConsumer<JTabbedPane, Integer>) (tabbedPane, tabIndex) -> {
                    // close tab here
                tabbedPane.remove(tabIndex);
            }
        );
        // tabMenu.putClientProperty("JTabbedPane.tabAreaAlignment", "leading");

        JButton addButton = new JButton();
        Icon addIcon = new ImageIcon("images/plus-icon.png");
        addButton.setIcon(addIcon);
        addButton.setBorder(null);
        addButton.setContentAreaFilled(false);
        setPreferredSize(new Dimension(30, 30));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addButtonActionPerformed(event);
            }

            private void addButtonActionPerformed(ActionEvent event) {
                tabMenu.addTab("Untitled", new NotePanel());
                // JComponent component = (JComponent) tabMenu.getTabComponentAt(tabMenu.getTabCount() - 1);
                // component.putClientProperty("JTabbedPane.tabClosable", "true");
            }
        });
        
        tabMenu.putClientProperty("JTabbedPane.trailingComponent", addButton);

        add(tabMenu);
    }
}
