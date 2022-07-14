package com.java_lessons;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryFrame extends JFrame {
    final static int WIDTH = 350;
    final static int HEIGHT = 200;

    Map<String,String> dictionary=new TreeMap<>();

    JTextField inputText = new JTextField(10);
    JTextField outputText = new JTextField(10);
    JButton translateButton = new JButton("Translate");
    JLabel inputLabel = new JLabel("Enter a word:", JLabel.TRAILING);
    JLabel outputLabel = new JLabel("Translate:", JLabel.TRAILING);

    public DictionaryFrame() {
        super("Dictionary");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //center
        setResizable(false);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        inputLabel.setLabelFor(inputText);
        outputLabel.setLabelFor(outputText);
        inputText.setFont(new Font(null, Font.ITALIC, 20));
        outputText.setFont(new Font(null, Font.ITALIC, 20));
        inputLabel.setFont(new Font(null, Font.PLAIN, 20));
        outputLabel.setFont(new Font(null, Font.PLAIN, 20));
        translateButton.setFont(new Font(null, Font.BOLD, 20));
        translateButton.addActionListener(new TranslateButtonListener(this));

        getContentPane().add(inputLabel);
        getContentPane().add(inputText);
        getContentPane().add(outputLabel);
        getContentPane().add(outputText);
        getContentPane().add(translateButton);

        //inputText
        layout.putConstraint(SpringLayout.NORTH, inputLabel, 25, SpringLayout.NORTH, getContentPane());
        layout.putConstraint(SpringLayout.WEST, inputLabel, 10, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, inputText, 0, SpringLayout.VERTICAL_CENTER, inputLabel);
        layout.putConstraint(SpringLayout.WEST, inputText, 5, SpringLayout.EAST, inputLabel);

        //outputText
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, outputText, 0, SpringLayout.HORIZONTAL_CENTER, inputText);
        layout.putConstraint(SpringLayout.NORTH, outputText, 10, SpringLayout.SOUTH, inputText);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, outputLabel, 0, SpringLayout.VERTICAL_CENTER, outputText);
        layout.putConstraint(SpringLayout.EAST, outputLabel, -5, SpringLayout.WEST, outputText);

        //translateButton
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, translateButton,
                0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, translateButton, 10, SpringLayout.SOUTH, outputText);


        this.setVisible(true);
    }
}