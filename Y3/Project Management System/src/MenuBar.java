import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuBar {
    private final ActionListener MenuBarCalled;


    MenuBar(ActionListener MBCall) {
        MenuBarCalled = MBCall;
    }


    protected JButton makeNavigationButton(String txt, String actionCommand, String toolTipText) {
        Font fnt = new Font("Times New Roman", Font.PLAIN, 18);

        //Create and initialise the MenuButton.
        JButton MenuButton = new JButton();
        MenuButton.setText(txt);
        MenuButton.setFont(fnt);
        MenuButton.setToolTipText(toolTipText);
        MenuButton.setActionCommand(actionCommand);
        MenuButton.addActionListener(MenuBarCalled);

        return MenuButton;
    }
}
