package com.java_lessons;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame {
    final static int WIDTH = 650;
    final static int HEIGHT = 480;

    MyPanel panel;
    MyToolBar toolBar;

    public MainFrame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(WIDTH,HEIGHT);

        panel=new MyPanel();
        toolBar=new MyToolBar(panel);

        setLayout( new BorderLayout());
        Container container=getContentPane();

        container.add(toolBar,BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);

        panel.fill(File.listRoots()[0].toString());



        setVisible(true);
    }
}
