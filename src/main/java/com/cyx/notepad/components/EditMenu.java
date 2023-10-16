package com.cyx.notepad.components;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
// import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
// import javax.swing.event.UndoableEditEvent;
// import javax.swing.event.UndoableEditListener;

public class EditMenu extends JMenu {
    public static JMenuItem undoItem, cutItem, copyItem, pasteItem, selectAllItem;

    // private Document document;
    public UndoManager undoManager = new UndoManager();
    // private UndoAction undoAction;
    // private RedoAction redoAction;
    

    public EditMenu() {
        init();
    }

    public void init() {
        setText("Edit");


        undoItem = new JMenuItem("Undo");
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        undoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoItemActionPerformed(evt);
            }
        });


        cutItem = new JMenuItem("Cut");
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });


        copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        copyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemActionPerformed(evt);
            }
        });


        pasteItem = new JMenuItem("Paste");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });


        selectAllItem = new JMenuItem("Select All");
        selectAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        selectAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllItemActionPerformed(evt);
            }
        });


        add(undoItem);
        add(new JSeparator());
        add(cutItem);
        add(copyItem);
        add(pasteItem);
        add(new JSeparator());
        add(selectAllItem);
    }

    protected void undoItemActionPerformed(ActionEvent evt) {
        try {
            // NotePanel.getInstance().undoManager.undo();
            // NotePanel.getInstance().editorPane.
            // undoManager.undo();
            NotePanel.undoManager.undo();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    protected void selectAllItemActionPerformed(ActionEvent evt) {
        try {
            // NotePanel.getInstance().editorPane.selectAll();
            NotePanel.editorPane.selectAll();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void copyItemActionPerformed(ActionEvent evt) {
        try {
            // NotePanel.getInstance().editorPane.copy();
            NotePanel.editorPane.copy();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void pasteItemActionPerformed(ActionEvent evt) {
        try {
            // NotePanel.getInstance().editorPane.paste();
            NotePanel.editorPane.paste();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void cutItemActionPerformed(ActionEvent evt) {
        try {
            // NotePanel.getInstance().editorPane.cut();
            NotePanel.editorPane.cut();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
