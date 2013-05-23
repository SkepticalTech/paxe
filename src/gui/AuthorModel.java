/*
 * Copyright (C) 2013 Skeptical_Tech
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gui;

import helpers.*;
import info.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

/**
 *
 * @author chris
 */
public class AuthorModel extends AbstractTableModel {

    private String[] columnNames = {"Author", "Contribution", "Contributor?"};
    public ComplexList<Author> authors; //Reference to author list

    public AuthorModel(ComplexList<Author> authors) {
        this.authors = authors;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return authors.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return authors.get(row).getName();
            case 1:
                return authors.get(row).getContribution();
            case 2:
                return authors.get(row).isContributor();
            default:
                System.out.println("Whoopsie");
                return null;
        }
    }

    @Override
    public Class getColumnClass(int col) {
        switch (col) {
            case 0: //Fall thru
            case 1:
                return String.class; //get string class
            case 2:
                return Boolean.class;
            default:
                System.out.println("Whoopsie");
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case 0:
                authors.get(row).setName((String) value);
                break;
            case 1:
                authors.get(row).setContribution((String) value);
                break;
            case 2:
                authors.get(row).setContributor((Boolean) value);
                break;
            default:
                System.out.println("Whoopsie");
        }
       fireTableCellUpdated(row, col);
    }

    //@Override
    /*
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
    }*/
}
