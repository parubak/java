package com.java_lessons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranslateButtonListener implements ActionListener {
    DictionaryFrame frame;
    public TranslateButtonListener(DictionaryFrame frame) {
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Frame f=new Frame("bpvtybnm");
        frame.setLocationRelativeTo(f);
        f.setSize(100,100);
//        f.set( Frame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(); //center
//        setResizable(false);
        f.setLayout( new FlowLayout());


        f.setVisible(true);
        f.dispose();

    }
}
