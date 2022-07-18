package com.java_lessons;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class MyToolBar extends JToolBar {

    public MyPanel panel;

    public MyToolBar(MyPanel panel) {
        this.panel=panel;

        for (File f:File.listRoots()){

            JButton btn = new JButton(f.getPath());
            Icon icon = FileSystemView.getFileSystemView().getSystemIcon(f);
            btn.setIcon(icon);
            add(btn);
            btn.addActionListener(e->panel.fill(btn.getText()));
        }
    }
}
