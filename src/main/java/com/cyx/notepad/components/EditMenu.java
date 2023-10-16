package com.cyx.notepad.components;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class EditMenu extends JMenu {
    private JMenuItem undoItem, cutItem, copyItem, pasteItem, selectAllItem;

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


        add(cutItem);
        add(copyItem);
        add(pasteItem);
        add(new JSeparator());
        add(selectAllItem);
    }

    protected void undoItemActionPerformed(ActionEvent evt) {
        // NotePanel.getInstance().editorPane
    }

    protected void selectAllItemActionPerformed(ActionEvent evt) {
        NotePanel.getInstance().editorPane.selectAll();
    }

    protected void copyItemActionPerformed(ActionEvent evt) {
        NotePanel.getInstance().editorPane.copy();
    }

    protected void pasteItemActionPerformed(ActionEvent evt) {
        NotePanel.getInstance().editorPane.paste();
    }

    protected void cutItemActionPerformed(ActionEvent evt) {
        NotePanel.getInstance().editorPane.cut();
    }
}
