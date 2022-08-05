package com.lesson;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class SQLTableModel extends AbstractTableModel {

    String queryStr;
    Connection conn;
    Statement statement;
    ResultSet rs;
    ResultSetMetaData meta;

    public SQLTableModel(String connection, String query) throws SQLException {

        queryStr = query;

        conn = DriverManager.getConnection(connection);
        statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = statement.executeQuery(queryStr);
        meta = rs.getMetaData();
    }

    @Override
    public int getRowCount() {

        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        try {
            return meta.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);

            return rs.getObject(columnIndex + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        try {
            return meta.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
