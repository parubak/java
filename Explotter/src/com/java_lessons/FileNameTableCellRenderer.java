package com.java_lessons;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;

public class FileNameTableCellRenderer implements TableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        File file=(File) value;
        JLabel label= new JLabel(file.getName());
        Icon icon= FileSystemView.getFileSystemView().getSystemIcon(file);
        label.setIcon(icon);

        if (isSelected){
            label.setBackground(Color.GRAY);
            label.setForeground(Color.WHITE);
            label.setOpaque(true);
            label.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));

        }else {
            label.setBorder(null);
        }

        return label;
    }
}
