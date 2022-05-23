package coursework;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Testing extends AllNotes {

    public static void main(String[] args) {
        Testing th = new Testing();
    }

    public Testing() {
        ArrayList<Note> n = new ArrayList<>();
        n = getAllNotes();
        JOptionPane.showMessageDialog(null, n.size());
    }
}
