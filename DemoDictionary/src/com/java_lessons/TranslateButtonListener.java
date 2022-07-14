package com.java_lessons;

import javax.swing.*;
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

        String answerInput = frame.inputText.getText();
        if (!answerInput.isEmpty()) {

            String answerDictionary = frame.dictionary.get(answerInput);

            if (answerDictionary == null) {
                if (0 == JOptionPane.showConfirmDialog(frame, "Add translation?",
                        String.format("Word %s not found", answerInput), JOptionPane.YES_NO_OPTION)) {
                    String translate = JOptionPane.showInputDialog("Enter translation: ");

                    if (translate != null && !translate.isEmpty()) {
                        frame.dictionary.putIfAbsent(answerInput, translate);
                        JOptionPane.showMessageDialog(frame,
                                String.format("Translation \"%s\" >>> \"%s\" added successfully!", answerInput, translate));
                        frame.outputText.setText(translate);
                        return;
                    }
                }
            } else {
                frame.outputText.setText(answerDictionary);
                return;
            }
        }
        frame.outputText.setText("");
    }
}
