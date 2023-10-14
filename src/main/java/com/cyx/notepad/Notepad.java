package com.cyx.notepad;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

public class Notepad extends JFrame {
    

    ImageIcon icon = new ImageIcon("images/notepad-blue.png");

    public Notepad() {
        init();
    }

    public void init() {
        setTitle("Notepad");
        setIconImage(icon.getImage());
        setSize(1150, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
