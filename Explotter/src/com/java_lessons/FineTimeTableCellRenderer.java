package com.java_lessons;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FineTimeTableCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        File file = (File) value;

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        JLabel label = new JLabel(df.format(new Date(file.lastModified())));

        if (isSelected) {
            label.setBackground(Color.GRAY);
            label.setForeground(Color.WHITE);
            label.setOpaque(true);
            label.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        } else {
            label.setBorder(null);
        }
        return label;
    }
}
