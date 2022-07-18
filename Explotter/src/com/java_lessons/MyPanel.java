package com.java_lessons;

import javax.swing.*;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;

public class MyPanel extends JScrollPane {

    JTable table=new JTable();
    FileTableModel model= new FileTableModel();


    public MyPanel() {
        table.setModel(model);
        setViewportView(table);

        table.setDefaultRenderer(File.class, new FileNameTableCellRenderer());
        table.setDefaultRenderer(FileSize.class, new FileSizeTableCellRenderer());
        table.setDefaultRenderer(FileTime.class, new FineTimeTableCellRenderer());

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;

                File file = (File) table.getValueAt(table.getSelectedRow(), 0);

                if (file.isDirectory()) {
                    fill(file.getAbsolutePath());
                } else {
                    String fileName = file.getName();

                    if (fileName.substring(fileName.length() - 3).toLowerCase(Locale.ROOT).compareTo("zip") == 0) {
                        ZipFileTableModel model = new ZipFileTableModel(file.getAbsolutePath());
                        table.setModel(model);
                    }
                }
            }
        });
    }


    public void fill(String path) {
        table.setModel(model);
        model.UpdateData(path);

        TableRowSorter<FileTableModel> sorter= new TableRowSorter<>(model);
        sorter.setSortable(1,false);
        sorter.setComparator(0, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isDirectory()||!o1.isDirectory()&&!o2.isDirectory() ) {
                   return o1.getName().compareTo(o2.getName());
                }
                return o1.isDirectory()?-1:1;
            }
        });
        sorter.addRowSorterListener(new RowSorterListener() {
            @Override
            public void sorterChanged(RowSorterEvent e) {

            }
        });

        table.setRowSorter(sorter);
        sorter.toggleSortOrder(0);
        sorter.sort();
        table.updateUI();
    }
}
