package com.cyx.notepad.components;

import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class NotePanel extends JPanel {
    public JEditorPane editorPane;

    private NotePanel() {
        init();
    }

    static NotePanel notePanel;

    public void init() {
        setLayout(new MigLayout("wrap, fill", "fill"));
        putClientProperty("JPanel.tabClosable", "true");
        add(new MenuBar());

        editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(400, 900));

        JScrollPane scrollPane = new JScrollPane(
                editorPane,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scrollPane.setSize(getWidth(), getHeight());

        add(scrollPane, "span, grow");
    }
    
    public static NotePanel getInstance() {
        if (notePanel == null) {
            notePanel = new NotePanel();
        }

        return notePanel;
    }
}
