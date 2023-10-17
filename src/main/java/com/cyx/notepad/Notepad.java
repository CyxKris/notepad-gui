package com.cyx.notepad;

import java.awt.*;
import javax.swing.*;

// import com.cyx.notepad.components.MenuBar;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

import raven.toast.Notifications;

public class Notepad extends JFrame {
    

    ImageIcon icon = new ImageIcon("images/notepad-blue.png");

    public Notepad() {
        init();
    }

    public void init() {
        setTitle("Notepad");
        setIconImage(icon.getImage());
        setSize(1150, 650);
        // setJMenuBar(new MenuBar());
        setLocationRelativeTo(null);
        setContentPane(new MainPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Notifications.getInstance().setJFrame(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        FlatInterFont.install();

        FlatLaf.registerCustomDefaultsSource("com.cyx.themes");
        FlatOneDarkIJTheme.setup();
        UIManager.put("defaultFont", new Font(FlatInterFont.FAMILY, Font.PLAIN, 14));

        new Notepad();
    }
}
