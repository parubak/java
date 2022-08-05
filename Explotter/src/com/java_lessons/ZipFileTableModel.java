package com.java_lessons;

import javax.swing.table.AbstractTableModel;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileTableModel extends AbstractTableModel {
    List<String> list = new ArrayList<>();

    public ZipFileTableModel(String absolutePath) {
        try {
            ZipInputStream stream=new ZipInputStream(new BufferedInputStream(new FileInputStream(absolutePath)));
            ZipEntry entry;
            while ((entry=stream.getNextEntry())!=null){
                list.add(entry.getName());
            }

            stream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(rowIndex);
    }
}
