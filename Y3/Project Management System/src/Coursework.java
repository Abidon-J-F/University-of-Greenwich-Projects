import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import classes.*;

public class Coursework extends JFrame implements ActionListener{

    public static programHandler data = programHandler.getInstance();

    critical_path path = new critical_path(data);

    MenuBar mb = new MenuBar(this);

    JFrame frame = new JFrame();
    JPanel westpnl = new JPanel(new GridBagLayout());
    JPanel centerpnl = new JPanel(new GridBagLayout());
    JPanel eastpnl = new JPanel(new GridBagLayout());

    JToolBar toolBar = new JToolBar();
    JButton btnNewProject = new JButton("New Project");
    JButton btnAddTeam = new JButton("Add Team");
    JButton btnAssignPerson = new JButton("Assign Team to Task");
    JButton btnSave = new JButton("Save");
    JButton btnCreateTeam = new JButton("Create Team");
    JButton btncritPath = new JButton("Critical Path");

    Font LabelFnt = new Font("Times New Roman", Font.PLAIN, 16);
    JLabel lblProjectTasks = new JLabel();
    JLabel lblProjectTable = new JLabel();
    JLabel lblTeamList = new JLabel();
    JLabel lblTeamMembers = new JLabel();
    JLabel lblGanttChart = new JLabel();


    public static DefaultListModel<String> TeamListNames;
    public static JList<String> TeamList;

    public static ArrayList<String> ProjectBoxList;
    public static JComboBox cbxProjectList;
    JTable ProjectTable;
    public static Object[][] tasktable;
    public String[] columnNames = {"Task Description", "Assigned to Team", "Start", "End", "Completed", "Reliant on:"};
    public GridBagConstraints gbc;

    public JTextArea txtInfoArea = new JTextArea(30,30);

    JScrollPane tableSP;

    public Coursework() {
        JVM();
    }


    private void JVM(){
        load_gui();

        btnNewProject = mb.makeNavigationButton( "New Project","NewProject",
                "Create a new project");
        toolBar.add(btnNewProject);
        toolBar.addSeparator();

        btnAddTeam = mb.makeNavigationButton( "Add Task","AddTask",
                "Create a new task");
        toolBar.add(btnAddTeam);
        toolBar.addSeparator();

        btnCreateTeam = mb.makeNavigationButton( "Create Team","CrtTeam",
                "Create and add a team to the project");
        toolBar.add(btnCreateTeam);
        toolBar.addSeparator();

        btnAssignPerson = mb.makeNavigationButton( "Assign Team to Task", "AssignTeam",
                "Assign a person to a team");
        toolBar.add(btnAssignPerson);
        toolBar.addSeparator();

        btnSave = mb.makeNavigationButton( "Save","Save",
                "Save everything");
        toolBar.add(btnSave);
        toolBar.addSeparator();

        btncritPath = mb.makeNavigationButton( "Critical Path","cp",
                "Display the critical path of your project");
        toolBar.add(btncritPath);

        lblProjectTasks.setText("Projects:");
        lblProjectTasks.setFont(LabelFnt);

        lblProjectTable.setText("Project Table");
        lblProjectTable.setFont(LabelFnt);

        lblGanttChart.setText("Time till completion (Gantt Chart)");
        lblGanttChart.setFont(LabelFnt);

        lblTeamList.setText("List of Teams");
        lblTeamList.setFont(LabelFnt);

        lblTeamMembers.setText("Information:");
        lblTeamMembers.setFont(LabelFnt);

        JScrollPane listSP = new JScrollPane(TeamList);
        listSP.setPreferredSize(new Dimension(200,200));



        txtInfoArea.setEditable(false);

        //Explanation for gridlayout is on yt and the oracle website.
        //https://www.youtube.com/watch?v=ZipG38DJJK8
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15, 15, 15);

//left panel work
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        westpnl.add(lblProjectTasks, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        westpnl.add(cbxProjectList, gbc);



//centerpanel work
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(lblProjectTable,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(tableSP,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(lblGanttChart,gbc);

//eastpanel work

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(lblTeamList,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(listSP,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(lblTeamMembers,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(txtInfoArea,gbc);

        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(westpnl, BorderLayout.WEST);
        frame.add(centerpnl, BorderLayout.CENTER);
        frame.add(eastpnl, BorderLayout.EAST);


        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("JVM Coursework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void load_gui(){
        if (!data.getProjects().isEmpty()){
            tasktable = new Object[data.getCurrentProject().getProjectTasks().size()][6];
            ArrayList<Task> t = data.getCurrentProject().getProjectTasks();
            for (int i = 0; i < data.getCurrentProject().getProjectTasks().size(); i++){
                Task f = data.getCurrentProject().getProjectTasks().get(i);
                Object[] arr = {f.getTaskDesc(), f.getAssignedTeam().getTeamName(), f.getTaskStartDate(), f.getTaskEndDate(), f.getIsCompleted(), f.getPredecessors()};
                for (int j = 0; j < 6; j++){
                    tasktable[i][j] = arr[j];
                }
            }
            ProjectBoxList = new ArrayList<>();
            for (Project i: data.getProjects()){
                ProjectBoxList.add(i.getProjName());
            }
            cbxProjectList= new JComboBox(ProjectBoxList.toArray());
            cbxProjectList.setSelectedIndex(data.getProjects().indexOf(data.getCurrentProject()));
            cbxProjectList.addActionListener(this);
            cbxProjectList.setActionCommand("ProjectFocusChanged");

            TeamListNames = new DefaultListModel<>();
            for (Team i: data.getCurrentProject().getProjectTeams()){
                TeamListNames.addElement(i.getTeamName());
            }
            TeamList = new JList<>(TeamListNames);

            ProjectTable = new JTable(tasktable, columnNames);
            ProjectTable.setCellSelectionEnabled(false);

            tableSP = new JScrollPane(ProjectTable);
            tableSP.setPreferredSize(new Dimension(800,400));
            centerpnl.add(tableSP,gbc);

            txtInfoArea.append(data.infoText);

            appendInfo("Now showing: " +data.getCurrentProject().getProjName() + "\n");
        }else{
            data.CreateProject("new project", "example project", String.valueOf(LocalDate.now()),10, true);
            data.getCurrentProject().addTask("Say hello to world",2, "null");
            load_gui();
        }
    }

    public void appendInfo(String i){
        data.infoText.concat(i);
        txtInfoArea.append(i);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if ("cp".equals(ae.getActionCommand())){
            appendInfo("Critical Path: " + path.calculate_critical_path() + "\n");
        }
        if ("ProjectFocusChanged".equals(ae.getActionCommand())){
            JComboBox cb = (JComboBox)ae.getSource();
            String projName = (String)cb.getSelectedItem();
            data.setCurrentProject(data.getProjOfName(projName));
            Coursework c = new Coursework();
            frame.setVisible(false);
        }

        if ("CrtTeam".equals(ae.getActionCommand())) {
            CreateTeam_gui pj = new CreateTeam_gui(this);
        }

        if ("NewProject".equals(ae.getActionCommand())) {
            Project_gui pj = new Project_gui(this);
        }

        if ("AddTask".equals(ae.getActionCommand())) {
            Task_gui tk = new Task_gui(this);
        }

        if ("AssignTeam".equals(ae.getActionCommand())) {
            AssignTeam_gui tm = new AssignTeam_gui(this);
        }

        if ("Save".equals(ae.getActionCommand())) {
            int SaveConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to save all the recent changes?", "Save Program Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (SaveConfirmation == JOptionPane.YES_OPTION) {
                try {
                    data.saveInstances();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
