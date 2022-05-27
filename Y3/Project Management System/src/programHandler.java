import classes.Project;
import classes.Task;
import classes.Team;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class programHandler {

    public static programHandler instance = new programHandler();
    private static ArrayList<Project> projects;
    private static Project currentProject;

    public static String infoText;
    public static void main(String args[]) throws IOException {
        projects = new ArrayList<>();
        infoText = "";
        loadInstances();
        Coursework cw = new Coursework();
    }

    public static programHandler getInstance( ) {
        return instance;
    }

    public void CreateProject(String name, String note, String startdate, int dur, boolean isCreate){
        if (isCreate && startdate.compareTo(String.valueOf(LocalDate.now())) < 0){
            System.out.println("ERROR: starting date is earlier than current date!");
        } else{
            Project tmp = new Project(name, note, startdate, dur);
            projects.add(tmp);
            currentProject = tmp;
        }
    }

    public Project getProjOfName(String name){
        Project a = null;
        for (Project project : projects) {
            if (project.getProjName().equals(name)) {
                a = project;
                break;
            }
        }
        return a;
    }

    public Project getCurrentProject(){
        return currentProject;
    }

    public void setCurrentProject(Project p){
        currentProject  = p;
    }

    public ArrayList<Project> getProjects() { return projects;}

    public void saveInstances() throws IOException {
        FileWriter csvWriter = new FileWriter("Projects.csv");
        for (Project j : projects) {
            ArrayList<String> Proj_data = new ArrayList<>(Arrays.asList("p", j.getProjName(), j.getProjNote(), j.getStartDate().toString(),
                    String.valueOf(j.getProjDuration())));
            Proj_data.forEach((c)->{
                try {
                    csvWriter.append(c).append("%");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            csvWriter.append("\n");
            for (int h = 0; h < j.getProjectTeams().size(); h++) {
                Team t = j.getProjectTeams().get(h);
                ArrayList<String> team_data = new ArrayList<> (Arrays.asList("g", t.getTeamName(), t.getTeamDescription(), String.valueOf(t.getID())));
                team_data.forEach((c)->{
                    try {
                        csvWriter.append(c).append("%");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                csvWriter.append("\n");
            }
            for (int h = 0; h < j.getProjectTasks().size(); h++) {
                Task t = j.getProjectTasks().get(h);
                ArrayList<String> task_data = new ArrayList<>(Arrays.asList("t", t.getTaskDesc(), t.getAssignedProj().getProjName(),
                        String.valueOf(t.getDuration()), t.getAssignedTeam().getTeamName(), t.getPredecessors()));
                task_data.forEach((c)->{
                    try {
                        csvWriter.append(c).append("%");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                csvWriter.append("\n");
            }
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public static void loadInstances() throws IOException {
        File csvFile = new File("Projects.csv");
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader("Projects.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split("%");
                if (data[0].equals("p")){
                    instance.CreateProject(data[1],data[2],data[3],Integer.parseInt(data[4]),false);
                }
                if (data[0].equals("g")){
                    instance.currentProject.createTeam(data[1], data[2], Integer.parseInt(data[3]));
                }
                if(data[0].equals("t")){
                    instance.currentProject.addTask(data[1],Integer.parseInt(data[3]),data[5]);
                    if (!data[4].equals("null")){
                        instance.currentProject.AssignTeamToTask(data[4],data[1]);
                    }
                }
            }
            csvReader.close();
        }


    }

}
