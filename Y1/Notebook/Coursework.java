/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author Abidon J Fernandes ID: 001013672
 */
//Most of the Codes here are from Andy Wicks youtube lab tutorial video and from our Lab Work Session.
//I will mention all the areas on who contributed what in our OOP Group work
public class Coursework extends JFrame implements ItemListener, MenuListener, ActionListener, KeyListener {

    CommonCode cc = new CommonCode(this);
    JTextField search = new JTextField();

    JFrame frame;
    JPanel pnl = new JPanel(new BorderLayout());
    JTextArea txtNewNote = new JTextArea();
    JTextArea txtDisplayNotes = new JTextArea();
    ArrayList<String> note = new ArrayList<>();
    ArrayList<String> fyle = new ArrayList<>();
    ArrayList<String> courze = new ArrayList<>();
    ArrayList<String> course = new ArrayList<>();
    JComboBox courseList = new JComboBox();
    String crse = "";
    AllNotes allNotes = new AllNotes();

    // Abidon J Fernandes ID: 001013672 contributed to the creation of File Open Dialog, Save Note and Save As Dialog
    JButton button3 = new JButton("Save As");
    JButton button2 = new JButton("Save");
    JButton button1 = new JButton("Open");

    public static void main(String[] args) {
        // This is required for the coursework.
        JOptionPane.showMessageDialog(null, "Abidon Jude Fernandes - 001013672");
        Coursework prg = new Coursework();
    }

    // Using MVC
    public Coursework() {
        model();
        view();
        controller();

    }

    private void model() {

        //   course.add("COMP1713");
        //   course.add("COMP1715");
        course.add("COMP1752");
        course.add("COMP1753");
        //   course.add("COMP1765");
        //  course.add("COMP1771");
        //   course.add("MATH1110");
        //   course.add("MATH1111");
        crse = course.get(0);

// Take these out AFTER you have created the file.
        /*  Note nt = new Note();
     nt.setNoteID(1);
     nt.setDayte(getDateAndTime());
     nt.setCourse(crse);
     nt.setNote("Arrays are of fixed length and are inflexible.");
     allNotes.addNote(nt.getNoteID(), nt.getCourse(), nt.getNote());
     
     // Take these out AFTER you have created the file.
     nt = new Note();
     nt.setNoteID(2);
     nt.setDayte(getDateAndTime());
     nt.setCourse(crse);
     nt.setNote("ArraysList can be added to and items can be deleted.");
     allNotes.addNote(nt.getNoteID(), nt.getCourse(), nt.getNote());
         */
    }

    private void view() {

        Font fnt = new Font("Arial", Font.PLAIN, 18);

        // Abidon J Fernandes ID: 001013672 contributed to the creation of these three button and the KeyListener
        button3.addActionListener(this);
        button2.addActionListener(this);
        button1.addActionListener(this);

        this.addKeyListener(this);

        JPanel pnlTop = new JPanel();

        JMenuBar menuBar = new JMenuBar();
        JMenu fyle = new JMenu();

        // Abidon J Fernandes ID: 001013672 contributed to the creation of these fyle menubar
        fyle.addActionListener(this);
        fyle = new JMenu("File");
        fyle.setToolTipText("File Option");
        fyle.setFont(fnt);

        fyle.add(cc.makeMenuItem("Directory", "OpenFile", "Open a file", fnt));
        fyle.addSeparator();
        fyle.add(cc.makeMenuItem("Save", "SaveNote", "Save a note.", fnt));
        fyle.addSeparator();
        fyle.add(cc.makeMenuItem("Save As", "SaveAsNote", "Choose your save destination", fnt));

        menuBar.add(fyle);

        JMenu courze = new JMenu();
        courze.addActionListener(this);
        courze = new JMenu("Course");
        courze.setToolTipText("Course Option");
        courze.setFont(fnt);

        courze.add(cc.makeMenuItem("Add Course", "AddCourse", "Add a Course", fnt));
        courze.addSeparator();
        courze.add(cc.makeMenuItem("Amend Course", "EditCourse", "Edit a Course", fnt));
        courze.addSeparator();
        courze.add(cc.makeMenuItem("Delete Course", "DeleteCourse", "Delete a Course", fnt));
        menuBar.add(courze);

//Creating a seperate menu for the coursework requirements
//David Brittain ID: 001026553 contributed to this creation of a menubar and the link fot the coursework requirement
        JMenu CourseReq = new JMenu();
        CourseReq.addActionListener(this);
        CourseReq = new JMenu("Course Requirements");
        CourseReq.setToolTipText("Course Requirements");
        CourseReq.setFont(fnt);

        CourseReq.add(cc.makeMenuItem("Course", "MATH1111", " NewCourse", fnt));
        menuBar.add(CourseReq);

//                //Hackathon: 3 Display Coursework Deadlines for a chosen Module 
//                or all modules by semester or by week. = Abidon J Fernandes ID: 001013672
        JMenu Deadline = new JMenu();
        Deadline.addActionListener(this);
        Deadline = new JMenu("Check Deadlines");
        Deadline.setToolTipText("Module Deadlines");
        Deadline.setFont(fnt);

        Deadline.add(cc.makeMenuItem("Open Deadlines", "OpenDeadlines", "Check your Deadlines", fnt));
        Deadline.addSeparator();
        Deadline.add(cc.makeMenuItem("Save Module", "SaveModule", "Create a new deadline.", fnt));
        menuBar.add(Deadline);

        JMenu note = new JMenu();
        note.addActionListener(this);
        note = new JMenu("Note");
        note.setToolTipText("Note tasks");
        note.setFont(fnt);

        note.add(cc.makeMenuItem("New", "NewNote", "Create a new note.", fnt));
        note.addSeparator();
        note.add(cc.makeMenuItem("Close", "Close", "Close the current note.", fnt));
        menuBar.add(note);
        menuBar.add(cc.makeMenuItem("Exit", "Exit", "Close this program", fnt));

        for (String crse : course) {
            courseList.addItem(crse);
        }
        courseList.setFont(fnt);
        courseList.setMaximumSize(courseList.getPreferredSize());
        courseList.addActionListener(this);
        courseList.setActionCommand("Course");
        menuBar.add(courseList);

        this.setJMenuBar(menuBar);

        JToolBar toolBar = new JToolBar();

        // Abidon J Fernandes ID: 001013672 contributed to the creation of these three icon buttons
        JButton button = null;
        button1 = cc.makeNavigationButton("Documents", "Open",
                "Open a Note",
                "Open");
        toolBar.add(button1);
        toolBar.addSeparator();
        button2 = cc.makeNavigationButton("Accept", "Save",
                "Save your Note",
                "Save");
        toolBar.add(button2);
        toolBar.addSeparator();
        button3 = cc.makeNavigationButton("Save as", "SaveAs",
                "Save your Note Independently",
                "Save As");
        toolBar.add(button3);
        toolBar.addSeparator();

        button = cc.makeNavigationButton("Add", "NewNote",
                "Create a new note.",
                "New");
        toolBar.add(button);
        toolBar.addSeparator();

        button = cc.makeNavigationButton("Delete", "Clear",
                "Clear this note.",
                "Clear");
        toolBar.add(button);

        toolBar.addSeparator();
        button = cc.makeNavigationButton("Exit button", "Exit",
                "Exit from this program.",
                "Exit");
        toolBar.add(button);
        toolBar.addSeparator();

        // This forces anything after it to the right.
        toolBar.add(Box.createHorizontalGlue());
        search.setMaximumSize(new Dimension(6900, 30));
        search.setFont(fnt);
        toolBar.add(search);
        toolBar.addSeparator();
        button = cc.makeNavigationButton("search", "SearchKeyword",
                "Search for this text.",
                "Search");
        toolBar.add(button);

        add(toolBar, BorderLayout.NORTH);

        JPanel pnlcen = new JPanel();
        pnlcen.setLayout(new BoxLayout(pnlcen, BoxLayout.Y_AXIS));
        pnlcen.setBorder(BorderFactory.createLineBorder(Color.black));

        txtNewNote.setFont(fnt);
        pnlcen.add(txtNewNote);

        JButton btnAddNote = new JButton("Add Note");
        btnAddNote.setActionCommand("NewNote");
        btnAddNote.addActionListener(this);
        pnlcen.add(btnAddNote);
        add(pnlcen, BorderLayout.WEST);

        JPanel est = new JPanel();
        est.setLayout(new BoxLayout(est, BoxLayout.Y_AXIS));
        est.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDisplayNotes.setFont(fnt);
        est.add(txtDisplayNotes);

        add(est, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Coursework NotePad - Abidon J Fernandes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);  // Needed to ensure that the items can be seen.
    }

    private void controller() {
        addAllNotes();
    }

    private void addNote(String text) {
        allNotes.addNote(allNotes.getMaxID(), crse, text);
        note.add(txtNewNote.getText());
        addAllNotes();
    }

    private void addAllNotes() {
        String txtNotes = "";
        for (Note n : allNotes.getAllNotes()) {
            txtNotes += n.getNote() + "\n";
        }

        txtDisplayNotes.setText(txtNotes);

    }

    private String getDateAndTime() {
        String UK_DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";
        String ukDateAndTime;
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat uksdf = new SimpleDateFormat(UK_DATE_FORMAT_NOW);
        ukDateAndTime = uksdf.format(cal.getTime());

        return ukDateAndTime;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//                //Hackathon: 3 Display Coursework Deadlines for a chosen Module 
//                or all modules by semester or by week. = Abidon J Fernandes ID: 001013672
        if ("SaveModule".equals(ae.getActionCommand())) {

            String path = cc.appDir + cc.fileSeparator + "Deadlines" + cc.fileSeparator + "ModuleDeadlines.txt";
            File f = new File(path);

            f.getParentFile().mkdirs();

            try {
                cc.writeTextFile(path, note);
            } catch (IOException ex) {
                Logger.getLogger(Coursework.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if ("NewNote".equals(ae.getActionCommand())) {
            addNote(txtNewNote.getText());
            txtNewNote.setText("");
        }

        // Abidon J Fernandes ID: 001013672 contributed to the creation of this edit combobox sub-menubar
        //http://www.java2s.com/Tutorial/Java/0240__Swing/AddItemstoJComboBox.html
        if ("EditCourse".equals(ae.getActionCommand())) {
            courseList.setEditable(true);
            courseList.addActionListener(this);

        }

        // Abidon J FernandeS ID: 001013672 contributed to the creation of this delete combobox sub-menubar
        if ("DeleteCourse".equals(ae.getActionCommand())) {
            String m = JOptionPane.showInputDialog(null, "Erase your Course of Choice");
            courseList.removeItem(m);
            crse = courseList.getSelectedItem().toString();
        }

        if ("CourseworkRequirement".equals(ae.getActionCommand())) {
            CourseworkItem c = new CourseworkItem();
        }

        if ("AddCourse".equals(ae.getActionCommand())) {
            String q = JOptionPane.showInputDialog(null, "Input your Course");
            courseList.addItem(q);
            crse = courseList.getSelectedItem().toString();

            /*Abidon J Fernandes ID: 001013672 contributed to the creation of saving 
      any created course in a text file format inside the Course folder */
            //https://stackoverflow.com/questions/3634853/how-to-create-a-directory-in-java
            String z = cc.appDir + cc.fileSeparator + "Course" + cc.fileSeparator + "crse.txt";

            File f = new File(z);

            f.getParentFile().mkdirs();
            try {
                cc.writeTextFile(z, course);
            } catch (IOException ex) {
                Logger.getLogger(Coursework.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("SearchKeyword".equals(ae.getActionCommand())) {
            String lyst = allNotes.searchAllNotesByKeyword("", 0, search.getText());
            txtDisplayNotes.setText(lyst);
        }

        /*Abidon J Fernandes ID: 001013672 contributed to the creation of saving 
      any notes in a text file format inside any selected Course folder */
        if ("SaveNote".equals(ae.getActionCommand())) {

            String path = cc.appDir + cc.fileSeparator + crse + cc.fileSeparator + "Notes.txt";
            File f = new File(path);

            f.getParentFile().mkdirs();

            try {
                cc.writeTextFile(path, note);
            } catch (IOException ex) {
                Logger.getLogger(Coursework.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        /*Abidon J Fernandes ID: 001013672 contributed to the creation this read open dialog file */
        //https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
        if ("OpenFile".equals(ae.getActionCommand())) {
            //This code here creates a dialog box using a jFileChooser then gets the file once selected and makes a path to it.
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename;
            filename = f.getAbsolutePath();

            //Reads the selected file and displays it in the JTextArea
            try {
                FileReader reader = new FileReader(filename);
                try (BufferedReader fr = new BufferedReader(reader)) {
                    txtDisplayNotes.read(fr, null);
                }
                txtDisplayNotes.requestFocus();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

        if ("Close".equals(ae.getActionCommand())) {
            txtNewNote.setText("");

        }

//David Brittain ID: 001026553 contributed to this section of Coursework Requirement
//Attempt at creating a list in textbox by David Brittain
//http://tutorials.jenkov.com/java-collections/list.html
//create list for requirements
        if ("MATH1111".equals(ae.getActionCommand())) {
            LinkedList Deadlines = new LinkedList();
            Deadlines.add("MATH1111 - 22/03/2019");
            Deadlines.add("COMP1752 - 25/03/2019");
            Deadlines.add("COMP1771 - 04/04/2019");
        }

        //Hackathon: 3 Display Coursework Deadlines for a chosen Module 
// or all modules by semester or by week. = Abidon J Fernandes ID: 001013672
        if ("OpenDeadlines".equals(ae.getActionCommand())) {
            String strDeadline = JOptionPane.showInputDialog(null, "Input your Coursework Details ");
            int reply = JOptionPane.showConfirmDialog(null, "Are you want to continue", "Deadline Notification", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, " Deadline:  " + "COMP1752 Coursework Deadline: 25th March 2019 = LAB Hackathon + "
                        + " COMP1753 Exam Date: 6th January 2019 = Open Book Exam + " + strDeadline);
            } else {
                JOptionPane.showMessageDialog(null, "See Ya");
            }

        }

        if ("Exit".equals(ae.getActionCommand())) {
            System.exit(0);
        }

        /*Abidon J Fernandes. ID: 001013672. = Contribution.
        This opens up a save as dialog where you can save your notes in a text file format 
        anywhere you like and you have the ability to create folders for your course, 
        coursework requirement, project etc.. and save the text file in them. */
        //https://stackoverflow.com/questions/15939903/create-a-save-save-as-dialog-box-in-java-that-save-a-newly-created-file-or-an-ed
        if (ae.getSource() == button3) {
// This is the Main Component of the dialog
            FileDialog fDialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
            fDialog.setVisible(true);
            String path = fDialog.getDirectory() + cc.fileSeparator + "Work.txt";
            File f = new File(path);

            //Saves the note
            try {
                cc.writeTextFile(path, note);
            } catch (IOException ex) {
                Logger.getLogger(Coursework.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*Abidon J Fernandes ID: 001013672 contributed to the creation of saving 
      a temporarily note in a text file format inside the Coursework folder */
//https://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java
//https://stackoverflow.com/questions/46438359/saving-jtextarea-to-a-txt-file-with-a-button#
        if (ae.getSource() == button2) {
            //Creates a file
            File log = new File("TEMP.txt");
            try {
                if (log.exists() == false) {
                    System.out.println("new file created.");
                    log.createNewFile();
                }
                //Writes the text file
                try (PrintWriter out = new PrintWriter(new FileWriter(log, false))) {
                    out.append("******* " + txtDisplayNotes.getText() + "******* " + "\r\n");
                    out.println(txtDisplayNotes);
                }
            } catch (IOException e) {
                System.out.println("COULD NOT LOG!!");
            }
        }

        /*Abidon J Fernandes. ID: 001013672. = Contribution.
        This opens up a file dialog where you can open up any text files you desire
        and onces selected it will be displayed on your notes .
        It has the ability to create folders so you can save notes in there afterwards.
           https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
        https://www.youtube.com/watch?v=T_T9U8Djles */
        if (ae.getSource() == button1) {
//This code here creates a dialog box using a jFileChooser then gets the file once selected and makes a path to it.
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename;
            filename = f.getAbsolutePath();

            //Reads the selected file and displays it in the JTextArea
            try {
                FileReader reader = new FileReader(filename);
                try (BufferedReader fr = new BufferedReader(reader)) {
                    txtDisplayNotes.read(fr, null);
                    fr.close();
                }
                txtDisplayNotes.requestFocus();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("itemStateChanged not coded yet");
    }

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("menuSelected not coded yet");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        System.out.println("menuDeselected not coded yet");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        System.out.println("menuCanceled not coded yet");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped not coded yet");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed not coded yet");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased not coded yet");
    }
}
