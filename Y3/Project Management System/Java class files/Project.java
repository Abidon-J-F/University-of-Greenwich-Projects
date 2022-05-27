import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.time.LocalDate;

public class Project {
    private String projName;//Name of the project
    private String projNote;//Brief description of the project

    private ArrayList<Task> ProjectTasks = new ArrayList<>();//Stores the tasks required for project completion
    private LocalDate StartDate;//date project was created
    private int ProjDuration;//deadline date that the project finishes
    private Task CurrentTask;

    //constructor
    public Project(String name, String note, String startdate, int dur){
        projName = name;
        projNote = note;
        StartDate = LocalDate.parse(startdate);
        ProjDuration = dur;
    }

    public void addTask(String desc, int d){
        Task tmp = new Task(desc, Project.this, d);
        this.ProjectTasks.add(tmp);
        tmp.checkPosition();
        for (int i =0; i < this.ProjectTasks.size()-1; i++){
            Task t = ProjectTasks.get(i);
            t.checkPosition();
        }
    }

    public void findCurrentTask(){
        for(int i = 0; i < this.ProjectTasks.size(); i++){
            Boolean check = this.ProjectTasks.get(i).getIsCompleted();
            if (check == false){
                this.CurrentTask = this.ProjectTasks.get(i);
                break;
            }
        }
    }


    public ArrayList<Task> getProjectTasks(){
        return ProjectTasks;
    }

    public void displayTaskData(){
        for (int i =0; i < ProjectTasks.size(); i++){
            Task tmp = ProjectTasks.get(i);
            System.out.println("Description: " + tmp +" "+ tmp.getTaskDesc() + " Start Date: " + tmp.getStartDate());
        }
    }

    public String getProjName(){
        return projName;
    }//returns project name

    public void setProjName(@NotNull String a){//sets the project name
        if (a.length() > 20){
            System.out.print("Error: project name exceeds length");
        } else{
            projName = a;
        }
    }

    public LocalDate getStartDate(){
        return StartDate;
    }


    public Task getCurrentTask() {
        return CurrentTask;
    }
}


