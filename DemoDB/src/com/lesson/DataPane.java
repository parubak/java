package com.lesson;

import javax.swing.*;

public class DataPane extends JScrollPane {

    JTable table;

    public DataPane(){
        table=new JTable();
    }

    public void setModel(SQLTableModel model) {
        if (model.meta==null){
            return;
        }
        table.setModel( model);
        setViewportView(table);
    }
}
