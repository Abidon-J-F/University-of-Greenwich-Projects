//Attempt at displaying deadlines by David Brittain

//Inspiration based on https://stackoverflow.com/questions/16418108/displaying-a-list-of-records-in-a-message-dialog
 
package coursework;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Deadline {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Deadline> deadlines = new ArrayList<Deadline>();

        // populate from database
        // Hard coding
        deadlines.add(new Deadline("MATH1111", 1));
        deadlines.add(new Deadline("COMP1771", 2));
        deadlines.add(new Deadline("COMP1752", 3));
        String message = "\n Doctor records \n ";
        for (Deadline doc : deadlines) {
            message += "\n\n\n" + "Name:" + doc.getName() + "Id:" + doc.getId();
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private Deadline(String matH1111, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
