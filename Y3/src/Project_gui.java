import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Project_gui extends JFrame implements ActionListener {

    Coursework main;

    JFrame PJframe;
    JPanel pjpnl;
    JPanel btnpanel;
    Font PJfnt;

    JLabel lblName;
    JLabel lblDescription;
    JLabel lblStartDate;
    JLabel lblDurations;

    JTextField txtName;
    JTextField txtDescription;
    JTextField txtStartDate;
    JTextField txtDurations;

    public Project_gui(Coursework m){
        main = m;
        Project();
    }

    private void Project(){
        PJframe = new JFrame("Project");
        pjpnl = new JPanel();
        btnpanel = new JPanel();
        PJfnt = new Font("Times New Roman", Font.PLAIN, 16);

        lblName = new JLabel("Name");
        lblDescription = new JLabel("Description");
        lblStartDate = new JLabel("Start Date");
        lblDurations = new JLabel("Durations (Days)");

        txtName = new JTextField();
        txtDescription = new JTextField();
        txtStartDate = new JTextField();
        txtDurations = new JTextField();

        lblName.setFont(PJfnt);
        lblDescription.setFont(PJfnt);
        lblStartDate.setFont(PJfnt);
        lblDurations.setFont(PJfnt);

        JButton btnPJSave = new JButton("Create Project");
        btnPJSave.setFont(PJfnt);
        btnPJSave.addActionListener(this);
        btnPJSave.setActionCommand("ok");


        btnpanel.add(btnPJSave);

        pjpnl.setLayout(new GridLayout(4,2, 15,15));
        pjpnl.add(lblName);
        pjpnl.add(txtName);
        pjpnl.add(lblDescription);
        pjpnl.add(txtDescription);
        pjpnl.add(lblStartDate);
        pjpnl.add(txtStartDate);
        pjpnl.add(lblDurations);
        pjpnl.add(txtDurations);


        PJframe.add(btnpanel, BorderLayout.NORTH);
        PJframe.add(pjpnl, BorderLayout.CENTER);

        PJframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PJframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        PJframe.pack();
        PJframe.setVisible(true);

    }


   @Override
   public void actionPerformed(ActionEvent e) {
       if ("ok".equals(e.getActionCommand())){
           main.data.CreateProject(txtName.getText(),txtDescription.getText(), txtStartDate.getText(), Integer.parseInt(txtDurations.getText()), true);
           Coursework c = new Coursework();
           main.frame.setVisible(false);
       }
       PJframe.setVisible(false);
   }
}