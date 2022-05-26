package coursework;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abidon Jude Fernandes
 */
public class MainPanel extends JPanel implements ActionListener, KeyListener {

    private final JLabel minLbl;
    private final JTextField minField;
    private final JLabel maxLbl;
    private final JTextField maxField;
    private final JButton calcbtn;
    private final JButton tbbtn;
    private EListener EListener;
    private final Bisection bs;
    private final NewtonRaphson nr;
    private final Secant st;
    private final JTable Table;
    private final JPanel panel;
    private Table tb;
    private JButton gpbtn;
    // private TableModel TableModel;
    private final Steffensen sf;

    //Sets the important variables in place. 
    public MainPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        minLbl = new JLabel("Min Range");
        maxLbl = new JLabel("Max Range");

        minField = new JTextField(10);
        maxField = new JTextField(10);

        calcbtn = new JButton("Calculate"); //calculates all four methods
        tbbtn = new JButton("Table");
        gpbtn = new JButton("Graph");
        calcbtn.addActionListener(this);
        tbbtn.addActionListener(this);
        minField.addActionListener(this);
        maxField.addActionListener(this);
        gpbtn.addActionListener(this);

        bs = new Bisection();
        nr = new NewtonRaphson();
        st = new Secant();
        sf = new Steffensen();

        Table = new JTable();
        panel = new JPanel();
        tb = new Table();

//Set the Border and Grid Layout for the variables
        Border innerBd = BorderFactory.createTitledBorder("Calculation Input");
        Border outerBd = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBd, innerBd));

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        ///First Row///
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(minLbl, gbc);

        ///Second Row///
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(minField, gbc);

        ///Third Row///
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(maxLbl, gbc);

        ///Fourth Row///
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(maxField, gbc);

        ///Fifth Row///
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tbbtn, gbc);

        ///Sixth Row///
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(calcbtn, gbc);

        ///Seventh Row///
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(gpbtn, gbc);

    }

    public void setEListener(EListener listener) {
        this.EListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

//Gets the mathematical methods
        if (ae.getSource() == calcbtn) {
            String min = (minField.getText());
            String max = (maxField.getText());
            String Bisection1 = (bs.Bisectionnom(min, max));
            String Bisection2 = (bs.Bisectionlog(min, max));
            String Bisection3 = (bs.Bisectionexp(min, max));

            String NR1 = (nr.NewtonRaphsonnom(min));
            String NR2 = (nr.NewtonRaphsonlog(min));
            String NR3 = (nr.NewtonRaphsonexp(min));

            String Secant1 = (st.Secantnom(min, max));
            String Secant2 = (st.Secantlog(min, max));
            String Secant3 = (st.Secantexp(min, max));

            String Steff1 = (sf.Steffensennom(min));
            String Steff2 = (sf.Steffensenlog(min));
            String Steff3 = (sf.Steffensenexp(min));

            //Stores the Values in an array
            String[] bs1 = Bisection1.split(" ");
            for (int i = 0; i < bs1.length; i++) {
                System.out.print("Bisection x-x^2 Array Stored Value: " + bs1[i] + " " + " \n");
            }
            String[] bs2 = Bisection2.split(" ");
            for (int i = 0; i < bs2.length; i++) {
                System.out.print("Bisection ln(x+1)+1 Array Stored Value: " + bs2[i] + " " + " \n");
            }
            String[] bs3 = Bisection3.split(" ");
            for (int i = 0; i < bs3.length; i++) {
                System.out.print("Bisection e^x-3x Array Stored Value: " + bs3[i] + " " + " \n");
            }

            String[] sc1 = Secant1.split(" ");
            for (int i = 0; i < sc1.length; i++) {
                System.out.print("Secant x-x^2 Array Stored Value: " + sc1[i] + " " + " \n");
            }
            String[] sc2 = Bisection2.split(" ");
            for (int i = 0; i < sc2.length; i++) {
                System.out.print("Secant ln(x+1)+1 Array Stored Value: " + sc2[i] + " " + " \n");
            }
            String[] sc3 = Bisection3.split(" ");
            for (int i = 0; i < sc3.length; i++) {
                System.out.print("Secant e^x-3x Array Stored Value: " + sc3[i] + " " + " \n");
            }

            //Stores the vlaue ina linked list. 
            //Inspiration was based on https://www.geeksforgeeks.org/linked-list-in-java/
            LinkedList<String> llist = new LinkedList<String>();
            llist.addFirst(NR1);
            llist.add(NR2);
            llist.add(NR3);
            llist.add(Steff1);
            llist.add(Steff2);
            llist.addLast(Steff3);
            System.out.println("Newton-Raphson & Steffenson Linked list : " + llist);

            //Sets the function so it is able to be retrieved by the EventPanel
            EventPanel fp = new EventPanel(this, min, max, Bisection1, Bisection2,
                    Bisection3, NR1, NR2, NR3, Secant1, Secant2, Secant3, Steff1,
                    Steff2, Steff3);
            if (EListener != null) {
                EListener.actionPerformed(fp);
            }
        }

        //Useless lines of code because it does not connect to the table class. Suggestion: Ignore it
        if (ae.getSource() == tbbtn) {
            /*  String min = minField.getText();
            String max = maxField.getText();

            String Bisection1 = (bs.Bisectionnom(min, max));
            String Bisection2 = (bs.Bisectionlog(min, max));
            String Bisection3 = (bs.Bisectionexp(min, max));

            String NR1 = (nr.NewtonRaphsonnom(min));
            String NR2 = (nr.NewtonRaphsonlog(min));
            String NR3 = (nr.NewtonRaphsonexp(min));

            String Secant1 = (st.Secantnom(min, max));
            String Secant2 = (st.Secantlog(min, max));
            String Secant3 = (st.Secantexp(min, max));*/

 /*   tb = new Table();
            row[0] = minField.getText();
            row[1] = maxField.getText();
            row[2] = Bisection1.getBytes();
            row[3] = Bisection2.getBytes();
            row[4] = Bisection3.getBytes();
            mod.addRow(row);*/
            //  Object[] cols = {min, max};
            // DefaultTableModel model = (DefaultTableModel) TableModel.getModel();
            //   model.addRow(cols);
        }

        //Useless lines of code because it does not connect to the graph class. Suggestion: Ignore it
        if (ae.getSource() == gpbtn) {

        }
    }

    @Override
    public void keyTyped(KeyEvent ke
    ) {
        System.out.println("keyTyped not coded yet.");
    }

    @Override
    public void keyPressed(KeyEvent ke
    ) {
        System.out.println("keyPressed not coded yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
        System.out.println("keyReleased not coded yet.");
    }
}
