import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task_gui extends JFrame implements ActionListener {
    JFrame TKframe = new JFrame("Task");
    JPanel tkpnl = new JPanel();
    JPanel btnpnl = new JPanel();

    Font tkfnt = new Font("Times New Roman", Font.PLAIN, 18);

    JButton btnTKSave = new JButton("Save Task");


    JLabel lblDescript = new JLabel("Task Description");
    JLabel lblDuration = new JLabel("Task Duration");
    JLabel lblleads = new JLabel("Task leads from");

    JTextField txtDescript = new JTextField();
    JTextField txtDuration = new JTextField();
    JTextField txtleads = new JTextField();
    Coursework main;

    public Task_gui(Coursework m){
        Task();
        main = m;
    }

    private void Task(){
        lblDescript.setFont(tkfnt);
        lblDuration.setFont(tkfnt);
        lblleads.setFont(tkfnt);

        btnTKSave.setFont(tkfnt);
        btnTKSave.addActionListener(this);
        btnTKSave.setActionCommand("ok");
        btnpnl.add(btnTKSave);

        tkpnl.setLayout(new GridLayout(3,2, 15,15));
        tkpnl.add(lblDescript);
        tkpnl.add(txtDescript);
        tkpnl.add(lblDuration);
        tkpnl.add(txtDuration);
        tkpnl.add(lblleads);
        tkpnl.add(txtleads);

        TKframe.add(btnpnl, BorderLayout.CENTER);
        TKframe.add(tkpnl, BorderLayout.NORTH);

        TKframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TKframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        TKframe.pack();
        TKframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("ok".equals(e.getActionCommand())){
            main.data.getCurrentProject().addTask(txtDescript.getText(),Integer.parseInt(txtDuration.getText()), txtleads.getText());
            Coursework c = new Coursework();
            main.frame.setVisible(false);
        }
        TKframe.setVisible(false);
    }
}
