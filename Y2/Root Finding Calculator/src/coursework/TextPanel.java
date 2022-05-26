/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001013672_comp1555_coursework;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Abidon
 */
//Sets the TextArea
public class TextPanel extends JPanel {

    private final JTextArea answer;

    public TextPanel() {
        Border innerBd = BorderFactory.createTitledBorder("Answer Output");
        Border outerBd = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBd, innerBd));
        answer = new JTextArea();
        JScrollPane scroll = new JScrollPane(answer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        answer.setEditable(false);

        setLayout(new BorderLayout());

        add(scroll, BorderLayout.CENTER);
    }

    //Creates the function to write the text
    public void appendText(String text) {
        answer.append(text);

    }
}
