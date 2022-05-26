package coursework;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Abidon Jude Fernandes
 */
//Useless Lines of Code because it does not connect to the Table class. Suggestion: Ignore it
//Inspiration was based on https://stackoverflow.com/questions/2937991/create-tablemodel-and-populate-jtable-dynamically
public class TableModel {

/*
    public class MathTableModel extends AbstractTableModel {

        String[] colName = {"Min", "Max", "Bisection x-x^2", "Bisection ln(x+1)+1"};
        ArrayList<String[]> rows = new ArrayList<String[]>();

        @Override
        public String getColumnName(int col) {
            return colName[col];
        }

        public int getRowCount() {
            return rows.size();

        }

        @Override
        public int getColumnCount() {
            return colName.length;

        }

        @Override
        public String getValueAt(int row, int col) {
            System.out.println("getValueAt method was called."); 
            String[] s = rows.get(row);
            return s[col];
        }

   //     public boolean isCellEditable(int col, int row) {
     //       return true;
     //   }

        public void setValueAt(Object s, int row, int col) {
            System.out.println("setValueAt method was called"); 
            rows.get(row)[col] = (String) s;
            fireTableDataChanged();
        }

        public void test() {
            System.out.println("It worked");
        }

        MathTableModel() {
            rows.add(new String[]{" "});
            rows.add(new String[]{" "});
        }

    }*/

}
