package com.java_lessons;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;

public class FileSizeTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        File f = (File) value;
        String str = f.isDirectory() ? "<DIR>" : Long.toString(f.length());
        JLabel label = new JLabel(str);

        if (isSelected){
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
