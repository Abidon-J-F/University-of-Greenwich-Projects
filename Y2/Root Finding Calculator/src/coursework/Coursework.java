package coursework;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Abidon Jude Fernandes
 */
public class Coursework extends JFrame implements ActionListener, KeyListener {

    private JComboBox fq;
    private TextPanel answer;
    private MainPanel mp;
    private EListener EListener;
    private TableModel tm;

    public static void main(String[] args) {

    }

//Sets the GUI
    public Coursework() {
        setTitle("Computer Algorithms and Modelling");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font fnt = new Font("Arial", Font.PLAIN, 14);

        mp = new MainPanel();
        add(mp, BorderLayout.WEST);

        answer = new TextPanel();

        add(answer, BorderLayout.CENTER);

        // Retrieves the data from the EListener class and sets the data to the JTextArea
        mp.setEListener(new EListener() {
            @Override
            public void actionPerformed(EventPanel ae) {

                String min = ae.getMin();
                String max = ae.getMax();

                String Bisection1 = ae.getBisection1();
                String Bisection2 = ae.getBisection2();
                String Bisection3 = ae.getBisection3();
                String NR1 = ae.getNR1();
                String NR2 = ae.getNR2();
                String NR3 = ae.getNR3();
                String Secant1 = ae.getSecant1();
                String Secant2 = ae.getSecant2();
                String Secant3 = ae.getSecant3();
                String Steff1 = ae.getSteff1();
                String Steff2 = ae.getSteff2();
                String Steff3 = ae.getSteff3();

                answer.appendText(" \n");
                answer.appendText("Min Range: " + min + " \n" + "Max Range: " + max + " \n");
                answer.appendText(" \n");

                answer.appendText("Bisection:" + " \n");
                answer.appendText("1:Normal 2:Log 3:Exp : " + Bisection1 + " [] " + Bisection2 + " [] " + Bisection3 + " \n");
                answer.appendText(" \n");

                answer.appendText("Newton Raphson:" + " \n");
                answer.appendText("1:Normal 2:Log 3:Exp: " + NR1 + " [] " + NR2 + " [] " + NR3 + " \n");
                answer.appendText(" \n");

                answer.appendText("Secant:" + " \n");
                answer.appendText("1:Normal 2:Log 3:Exp: " + Secant1 + " [] " + Secant2 + " [] " + Secant3 + " \n");
                answer.appendText(" \n");

                answer.appendText("Steffensen:" + " \n");
                answer.appendText("1:Normal 2:Log 3:Exp: " + Steff1 + " [] " + Steff2 + " [] " + Steff3 + " \n");
                answer.appendText(" \n");

            }

        });
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("keyTyped not coded yet.");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("keyPressed not coded yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("keyReleased not coded yet.");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("actionPerformed not coded yet.");
    }

}
