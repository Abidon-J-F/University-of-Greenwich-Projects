import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTeam_gui extends JFrame implements ActionListener {
    JFrame CTframe = new JFrame("Create Team");
    JPanel tkpnl = new JPanel();
    JPanel btnpnl = new JPanel();

    Font tkfnt = new Font("Times New Roman", Font.PLAIN, 18);

    JButton btnTKSave = new JButton("Create Team");


    JLabel lblName = new JLabel("Team Name");
    JLabel lblDescription = new JLabel("Team description");
    JLabel lblID = new JLabel("ID for team");

    JTextField txtName = new JTextField();
    JTextField txtDescription = new JTextField();
    JTextField txtID = new JTextField();
    Coursework main;


    public CreateTeam_gui(Coursework m){
        Task();
        main = m;
    }

    private void Task(){
        lblName.setFont(tkfnt);
        lblDescription.setFont(tkfnt);
        lblID.setFont(tkfnt);

        btnTKSave.setFont(tkfnt);
        btnTKSave.addActionListener(this);
        btnTKSave.setActionCommand("ok");
        btnpnl.add(btnTKSave);

        tkpnl.setLayout(new GridLayout(3,2, 15,15));
        tkpnl.add(lblName);
        tkpnl.add(txtName);
        tkpnl.add(lblDescription);
        tkpnl.add(txtDescription);
        tkpnl.add(lblID);
        tkpnl.add(txtID);

        CTframe.add(btnpnl, BorderLayout.CENTER);
        CTframe.add(tkpnl, BorderLayout.NORTH);

        CTframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CTframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        CTframe.pack();
        CTframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("ok".equals(e.getActionCommand())){
            main.data.getCurrentProject().createTeam(txtName.getText(), txtDescription.getText() ,Integer.parseInt(txtID.getText()));
            Coursework c = new Coursework();
            main.frame.setVisible(false);
        }
        CTframe.setVisible(false);
    }
}
