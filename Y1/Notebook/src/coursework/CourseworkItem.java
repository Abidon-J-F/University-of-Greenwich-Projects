package coursework;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class CourseworkItem extends JFrame implements ActionListener, KeyListener {

    CommonCode cc = new CommonCode();
    JPanel pnl = new JPanel(new BorderLayout());

    public CourseworkItem() {
        model();
        view();
        controller();
    }

    private void model() {
        // This is the logic of the program.

    }

    private void view() {
        JMenuBar menuBar;
        JMenu fyle;

        JToolBar toolBar = new JToolBar();
        Font fnt = new Font("Georgia", Font.PLAIN, 36);

        // Setting up the MenuBar
        menuBar = new JMenuBar();
        fyle = new JMenu("File");
        fyle.setToolTipText("File tasks");
        fyle.setFont(fnt);

        JMenuItem mnuItem = null;

        mnuItem = makeMenuItem("New", "New", "Create a new something or other", fnt);
        fyle.add(mnuItem);

        fyle.addSeparator();

        mnuItem = makeMenuItem("Close", "Close", "Close something or other", fnt);
        fyle.add(mnuItem);

        menuBar.add(fyle);

        mnuItem = makeMenuItem("Exit", "Exit", "Close this program", fnt);
        menuBar.add(mnuItem);

        setJMenuBar(menuBar);

        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("Coursework Requirement Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cen = new JPanel();
        cen.setLayout(new FlowLayout());
        JLabel cenLbl = new JLabel("<html><body>Here are this year Coursework Requirement</body></html>");
        cenLbl.setFont(fnt);
        cen.add(cenLbl);
        add(cen, BorderLayout.CENTER);

        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        JLabel copy = new JLabel("<html><body>You must complete all these requirement in order to pass this course</body></html>");
        copy.setFont(fnt);
        bot.add(copy);
        add(bot, BorderLayout.SOUTH);

        setVisible(true);

        // Setting up the ButtonBar
        JButton button = null;
        button = makeNavigationButton("Create", "Return2Notes",
                "Return to the Notes window",
                "Notes");
        toolBar.add(button);
        button = makeNavigationButton("closed door", "Close",
                "Close this thingy",
                "Close");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeNavigationButton("exit", "Exit",
                "Exit from this program",
                "Exit");
        toolBar.add(button);

        add(toolBar, BorderLayout.NORTH);
    }

    private void controller() {
        // This is the logic of the program.

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("Return2Notes".equals(ae.getActionCommand())) {
            Coursework cw = new Coursework();
        }
        if ("New".equals(ae.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "New clicked");
        }
        if ("Close".equals(ae.getActionCommand())) {

            JOptionPane.showMessageDialog(this, "Close clicked");
        }
        if ("Exit".equals(ae.getActionCommand())) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("keyTyped has not been coded yet.");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("keyPressed has not been coded yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("keyReleased has not been coded yet.");
    }

    protected JMenuItem makeMenuItem(String txt,
            String actionCommand,
            String toolTipText,
            Font fnt) {

        JMenuItem mnuItem = new JMenuItem();
        mnuItem.setFont(fnt);
        mnuItem.setText(txt);
        mnuItem.setToolTipText(toolTipText);
        mnuItem.setActionCommand(actionCommand);
        mnuItem.addActionListener(this);

        return mnuItem;
    }

    protected JButton makeNavigationButton(String imageName,
            String actionCommand,
            String toolTipText,
            String altText) {

        //Look for the image.
        String imgLocation = cc.appDir + "\\icons\\"
                + imageName
                + ".png";

        //Create and initialize the button.
        JButton button = new JButton();
        button.setToolTipText(toolTipText);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);

        File fyle = new File(imgLocation);
        if (fyle.exists() && !fyle.isDirectory()) {
            // image found
            Icon img;
            img = new ImageIcon(imgLocation);
            button.setIcon(img);
        } else {
            // image NOT found
            button.setText(altText);
            System.err.println("Resource not found: " + imgLocation);
        }

        return button;
    }
}
