package coursework;

/**
 *
 * @author Abidon Jude Fernandes
 */
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

//Secure way to run the program
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "your name - id number");
                Coursework cw = new Coursework();
            }

        });

    }

}
