package coursework;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Abidon Jude Fernandes
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
