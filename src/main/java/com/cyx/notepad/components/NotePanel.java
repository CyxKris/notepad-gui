package com.cyx.notepad.components;

import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
// import javax.swing.event.UndoableEditEvent;
// import javax.swing.event.UndoableEditListener;
// import javax.swing.undo.UndoManager;

import com.cyx.notepad.UndoManager;

import net.miginfocom.swing.MigLayout;

public class NotePanel extends JPanel {
    // public static UndoManager undoManager = new UndoManager();
    public static UndoManager undoManager = new UndoManager();


    public static JEditorPane editorPane;

    private NotePanel() {
        init();
    }

    // static NotePanel notePanel;

    public void init() {
        setLayout(new MigLayout("wrap, fill", "fill"));
        putClientProperty("JPanel.tabClosable", "true");
        
        add(new MenuBar());

        undoManager.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                EditMenu.undoItem.setEnabled(undoManager.canUndo());
                // btnRedo.setEnabled(undoManager.canRedo());
            }
        });

        editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(400, 900));

        // editorPane.getDocument().addUndoableEditListener(new UndoableEditListener() {
        //     public void undoableEditHappened(UndoableEditEvent event) {
        //         try {
        //             undoManager.addEdit(event.getEdit());
        //         } catch (Exception e) {
        //             System.out.println(e);
        //             e.printStackTrace();
        //         }
        //     }
        // });

        editorPane.getDocument().addUndoableEditListener(undoManager);

        JScrollPane scrollPane = new JScrollPane(
                editorPane,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scrollPane.setSize(getWidth(), getHeight());

        add(scrollPane, "span, grow");
    }
    
    public static NotePanel getInstance() {
        // if (notePanel == null) {
        //     notePanel = new NotePanel();
        // }

        // return notePanel;
        return new NotePanel();
    }
}
