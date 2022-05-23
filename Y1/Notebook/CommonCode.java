package coursework;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

/**
 *
 * @author Abidon
 *
 */
public class CommonCode {

    // These allow the system date to be accessed in ordered, UK and US formats.
    public static final String ORDERED_DATE_TIME_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    public static final String UK_DATE_TIME_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";
    public static final String US_DATE_TIME_FORMAT_NOW = "MM-dd-yyyy HH:mm:ss";
    public static final String ORDERED_DATE_FORMAT_NOW = "yyyy-MM-dd";
    public static final String UK_DATE_FORMAT_NOW = "dd-MM-yyyy";
    public static final String US_DATE_FORMAT_NOW = "MM-dd-yyyy";
    public String orderedDateAndTime;
    public String ukDateAndTime;
    public String usDateAndTime;
    public String orderedDate;
    public String ukDate;
    public String usDate;

    // These are some useful items.
    public final String userName = System.getProperty("user.name");
    public final String appDir = System.getProperty("user.dir");
    public final String os = System.getProperty("os.name");
    public final String fileSeparator = System.getProperty("file.separator");

    private ActionListener calledBy;

    CommonCode(ActionListener call) {
        calledBy = call;
        initialiseVariables();
    }

    CommonCode() {
        initialiseVariables();
    }

    // This is used by CommonCode to set up the public variables.
    private void initialiseVariables() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat o1sdf = new SimpleDateFormat(ORDERED_DATE_TIME_FORMAT_NOW);
        orderedDateAndTime = o1sdf.format(cal.getTime());
        SimpleDateFormat uk1sdf = new SimpleDateFormat(UK_DATE_TIME_FORMAT_NOW);
        ukDateAndTime = uk1sdf.format(cal.getTime());
        SimpleDateFormat us1sdf = new SimpleDateFormat(US_DATE_TIME_FORMAT_NOW);
        usDateAndTime = us1sdf.format(cal.getTime());
        SimpleDateFormat o2sdf = new SimpleDateFormat(ORDERED_DATE_TIME_FORMAT_NOW);
        orderedDate = o2sdf.format(cal.getTime());
        SimpleDateFormat uk2sdf = new SimpleDateFormat(UK_DATE_TIME_FORMAT_NOW);
        ukDate = uk2sdf.format(cal.getTime());
        SimpleDateFormat us2sdf = new SimpleDateFormat(US_DATE_TIME_FORMAT_NOW);
        usDate = us2sdf.format(cal.getTime());
    }

    protected JMenuItem makeMenuItem(String txt,
            String actionCommand,
            String toolTipText,
            Font fnt) {

        JMenuItem mnuItem = new JMenuItem();
        mnuItem.setText(txt);
        mnuItem.setActionCommand(actionCommand);
        mnuItem.setToolTipText(toolTipText);
        mnuItem.setFont(fnt);
        mnuItem.addActionListener(calledBy);

        return mnuItem;
    }

    protected JButton makeNavigationButton(String imageName,
            String actionCommand,
            String toolTipText,
            String altText) {

        //Look for the image.
        String imgLocation = System.getProperty("user.dir") + "\\icons\\"
                + imageName
                + ".png";

        //Create and initialize the button.
        JButton button = new JButton();
        button.setToolTipText(toolTipText);
        button.setActionCommand(actionCommand);
        button.addActionListener(calledBy);

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

    public String getDateAndTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat uksdf = new SimpleDateFormat(UK_DATE_FORMAT_NOW);
        ukDateAndTime = uksdf.format(cal.getTime());

        return ukDateAndTime;
    }

    // This reads a text file into an ArrayList of Strings.  The path to the
    // file has to be added.  Use appDir if the files are in the application 
    // directory.  Use fileSeperator if the app may be running under a 
    // different OS.
    public ArrayList<String> readTextFile(String fileName) {
        ArrayList file = new ArrayList();
        String line;

        if ((fileName == null) || (fileName.equals(""))) {
            System.out.println("No file name specified.");
        } else {
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));

                if (!in.ready()) {
                    throw new IOException();
                }

                while ((line = in.readLine()) != null) {
                    file.add(line);
                }
                in.close();
            } catch (IOException e) {
                System.out.println(e);
                file.add("File not found");
            }
        }

        return file;
    }

    // This writes to a text file using an ArrayList of Strings.  The path to the
    // file has to be added.  Use appDir if the files are in the application 
    // directory.  Use fileSeperator if the app may be running under a 
    // different OS.
    /**
     * Change the contents of text file in its entirety, overwriting any
     * existing text.
     *
     * @param fn
     * @param aContents
     * @throws java.io.FileNotFoundException
     */
    public void writeTextFile(String fn, ArrayList<String> outputText)
            throws FileNotFoundException, IOException {

        File fileName = new File(fn);

        Writer output = new BufferedWriter(new FileWriter(fileName));
        try {
            for (int i = 0; i < outputText.size(); i++) {
                output.write(outputText.get(i).toString() + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            output.close();
        }
    }
}
