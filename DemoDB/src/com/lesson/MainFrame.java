package com.lesson;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    private final String connStr= "jdbc:sqlserver://localhost:1433;databaseName=books;user=java;password=java;" +
            "encrypt=true;trustServerCertificate=true";
    TextArea queryText;
    Button buttonExecute;
    DataPane dataPane;
    Panel panel;

    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(640, 480);
        setLayout(new BorderLayout());

        queryText = new TextArea("select *\n from table", 3, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
        queryText.setFont(new Font(null, Font.ITALIC, 25));
        buttonExecute = new Button("Execute \n request");
        dataPane = new DataPane();

        queryText.setBackground(Color.LIGHT_GRAY);
        buttonExecute.setBackground(Color.PINK);

        buttonExecute.addActionListener(e -> {
            try {
                dataPane.setModel(new SQLTableModel(connStr, queryText.getText()));
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,
                        error.getMessage(),
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel = new Panel(new BorderLayout());
        panel.add(new Label("Enter a request :", Label.CENTER), NORTH);
        panel.add(queryText, BorderLayout.CENTER);
        panel.add(buttonExecute, AFTER_LINE_ENDS);
        panel.add(new Label("Result :", Label.CENTER), SOUTH);

        getContentPane().add(panel, NORTH);
        getContentPane().add(dataPane, CENTER);


        setVisible(true);
    }
}
