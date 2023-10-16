package com.cyx.other;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEdit;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JButton btnUndo = new JButton("Undo");
                JButton btnRedo = new JButton("Redo");
                UndoManager undoManager = new UndoManager();
                undoManager.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        btnUndo.setEnabled(undoManager.canUndo());
                        btnRedo.setEnabled(undoManager.canRedo());
                    }
                });

                EditorPane editorPane = new EditorPane(undoManager);

                JToolBar tb = new JToolBar();
                btnUndo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        undoManager.undo();
                    }
                });
                tb.add(btnUndo);
                btnRedo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        undoManager.redo();
                    }
                });
                tb.add(btnRedo);

                JFrame frame = new JFrame();
                frame.add(tb, BorderLayout.NORTH);
                frame.add(new JScrollPane(editorPane));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public class EditorPane extends JPanel {

        private UndoManager undoManager;

        public EditorPane(UndoManager undoManager) {
            setLayout(new BorderLayout());
            this.undoManager = undoManager;
            JTextArea textArea = new JTextArea(20, 40);
            textArea.getDocument().addUndoableEditListener(undoManager);
            add(new JScrollPane(textArea));
        }

    }

    public class UndoManager extends AbstractUndoableEdit implements UndoableEditListener {
        private String lastEditName = null;
        private List<MergeComponentEdit> edits = new ArrayList<MergeComponentEdit>(32);
        private MergeComponentEdit current;
        private int pointer = -1;

        private List<ChangeListener> changeListeners = new ArrayList<>(8);

        public void addChangeListener(ChangeListener changeListener) {
            changeListeners.add(changeListener);
        }

        public void removeChangeListener(ChangeListener changeListener) {
            changeListeners.remove(changeListener);
        }

        public void undoableEditHappened(UndoableEditEvent e) {
            UndoableEdit edit = e.getEdit();
            if (edit instanceof AbstractDocument.DefaultDocumentEvent) {
                try {
                    AbstractDocument.DefaultDocumentEvent event = (AbstractDocument.DefaultDocumentEvent) edit;
                    int start = event.getOffset();
                    int len = event.getLength();
                    if (start + len > event.getDocument().getLength()) {
                        createCompoundEdit();
                        current.addEdit(edit);
                        lastEditName = edit.getPresentationName();
                    } else {

                        String text = event.getDocument().getText(start, len);
                        boolean isNeedStart = false;
                        if (current == null) {
                            isNeedStart = true;
                        } else if (text.contains(" ")) {
                            isNeedStart = true;
                        } else if (lastEditName == null || !lastEditName.equals(edit.getPresentationName())) {
                            isNeedStart = true;
                        }

                        while (pointer < edits.size() - 1) {
                            edits.remove(edits.size() - 1);
                            isNeedStart = true;
                        }
                        if (isNeedStart) {
                            createCompoundEdit();
                        }

                        current.addEdit(edit);
                        lastEditName = edit.getPresentationName();
                    }
                    fireStateChanged();
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        }

        public void createCompoundEdit() {
            if (current == null) {
                current = new MergeComponentEdit();
            } else if (current.getLength() > 0) {
                current = new MergeComponentEdit();
            }

            edits.add(current);
            pointer++;
        }

        public void undo() throws CannotUndoException {
            if (!canUndo()) {
                throw new CannotUndoException();
            }

            MergeComponentEdit u = edits.get(pointer);
            u.undo();
            pointer--;

            fireStateChanged();
        }

        public void redo() throws CannotUndoException {
            if (!canRedo()) {
                throw new CannotUndoException();
            }

            pointer++;
            MergeComponentEdit u = edits.get(pointer);
            u.redo();

            fireStateChanged();
        }

        public boolean canUndo() {
            return pointer >= 0;
        }

        public boolean canRedo() {
            return edits.size() > 0 && pointer < edits.size() - 1;
        }

        protected void fireStateChanged() {
            if (changeListeners.isEmpty()) {
                return;
            }
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : changeListeners) {
                listener.stateChanged(evt);
            }
        }

        protected class MergeComponentEdit extends CompoundEdit {
            boolean isUnDone = false;

            public int getLength() {
                return edits.size();
            }

            public void undo() throws CannotUndoException {
                super.undo();
                isUnDone = true;
            }

            public void redo() throws CannotUndoException {
                super.redo();
                isUnDone = false;
            }

            public boolean canUndo() {
                return edits.size() > 0 && !isUnDone;
            }

            public boolean canRedo() {
                return edits.size() > 0 && isUnDone;
            }

        }
    }
}