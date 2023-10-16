package com.cyx.notepad.components;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ViewMenu extends JMenu {
    private JMenuItem zoomIn, zoomOut, resetZoom;

    public ViewMenu() {
        init();
    }

    private void init() {
        setText("View");


        zoomIn = new JMenuItem("Zoom In");
        zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_DOWN_MASK));
        zoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInActionPerformed(evt);
            }
        });


        zoomOut = new JMenuItem("Zoom Out");
        zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.CTRL_DOWN_MASK));
        zoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutActionPerformed(evt);
            }
        });


        resetZoom = new JMenuItem("Reset Zoom");
        resetZoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, InputEvent.CTRL_DOWN_MASK));
        resetZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetZoomActionPerformed(evt);
            }
        });


        add(zoomIn);
        add(zoomOut);
        add(resetZoom);

    }

    protected void resetZoomActionPerformed(ActionEvent evt) {
        // NotePanel.getInstance().editorPane.
    }

    protected void zoomOutActionPerformed(ActionEvent evt) {
    }

    protected void zoomInActionPerformed(ActionEvent evt) {
    }
}
