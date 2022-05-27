import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignTeam_gui extends JFrame implements ActionListener {
    Coursework main;

    JFrame ATframe = new JFrame("Team Assignment");
    JPanel tmpnl = new JPanel();
    JPanel btnpnl = new JPanel();

    Font tmfnt = new Font("Times New Roman", Font.PLAIN, 18);

    JButton btnTMSave = new JButton("Assign");

    JLabel lblTeamName = new JLabel("Team Name");
    JLabel lblTaskName = new JLabel("Task Description");

    JTextField txtTeamName = new JTextField();
    JTextArea txtTaskName = new JTextArea();

    public AssignTeam_gui(Coursework m){
        Team();
        main = m;
    }

    private void Team(){
        lblTeamName.setFont(tmfnt);
        lblTaskName.setFont(tmfnt);
        txtTeamName.setFont(tmfnt);
        txtTaskName.setFont(tmfnt);

        btnTMSave.setFont(tmfnt);
        btnTMSave.addActionListener(this);
        btnTMSave.setActionCommand("ok");

        btnpnl.add(btnTMSave);

        tmpnl.setLayout(new GridLayout(2,2, 15,15));
        tmpnl.add(lblTeamName);
        tmpnl.add(txtTeamName);
        tmpnl.add(lblTaskName);
        tmpnl.add(txtTaskName);

        ATframe.add(btnpnl, BorderLayout.NORTH);
        ATframe.add(tmpnl, BorderLayout.CENTER);

        ATframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ATframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ATframe.pack();
        ATframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("ok".equals(e.getActionCommand())){
            main.data.getCurrentProject().AssignTeamToTask(txtTeamName.getText(), txtTaskName.getText());
            Coursework c = new Coursework();
            main.frame.setVisible(false);
        }
        ATframe.setVisible(false);
    }
}
