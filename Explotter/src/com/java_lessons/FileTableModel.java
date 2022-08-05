package com.java_lessons;

import javax.swing.table.AbstractTableModel;
import java.io.File;

interface FileSize{

}
interface FileTime{

}
public class FileTableModel extends AbstractTableModel {

    File[] files;
    String[] head={"File","Size","Last change time"};

    public FileTableModel() {
        files=new File[0];
    }


    public void UpdateData(String path){
        files=new File(path).listFiles();

    }

    @Override
    public int getRowCount() {
        return files.length;
    }

    @Override
    public int getColumnCount() {
        return head.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return files[rowIndex];
    }

    @Override
    public String getColumnName(int column) {
        return head[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex){
            case 0: return File.class;
            case 1: return FileSize.class;
            case 2: return FileTime.class;

            default:
                return super.getColumnClass(columnIndex);
        }

    }
}
