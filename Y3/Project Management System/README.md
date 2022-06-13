# Project Management System

Created a project management system using Kotlin as back-end and JAVA as front-end as a group project.

### Contribution to this project:
- Abidon Jude Fernandes
- Sean Daly
- Fredrik Wells

## Coursework Project Tasks
Create a system to provide the following functionality:
- Set up projects
- Set up teams
- Divide projects into tasks
    -  Duration and sequence of tasks can be defined (a task can have none, one or more successor tasks)
    -  Each task is assigned to particular team 
- Register task progress. Project progress can be tracked 


**Accomplishment:**
1. Created a desktop application with a graphical user interface to enable project managers to set up projects, manage teams and record progress on tasks.
2. Created a domain and entity classes in Kotlin that create an object-oriented structure and is integrated the Java GUI application.
3. Created a persistence for the project, team, and task data, and saved the data in a CSV or ACCDB file. Then utilised Lambdas expressions to manage collections of data all in Kotlin and integrated into the Java GUI.
4. Implemented an object-oriented component called the critical path which uses a longest path algorithm in Kotlin that calculates the duration and finishing date of a project using the longest path for (based on its critical path) when provided with a project object.
5. Integrated the critical path component from Kotlin into the project management process in Java, so that when a project is edited, the critical path is automatically calculated and the duration and finishing date are updated. 


### Welcome to our JVM Programming Languages Coursework, in the following classes you will find the following code in the following classes:

- Project: holds the logic and structure for the projects, including tasks and teams that are included.
- Task: structure for a task, holds a description, duration, and link to the project it belongs to.
- Team: holds the team’s name and a list of projects assigned to that team.
- programHandler: contains a list of all the projects held in the program, as well as the main method, save and load methods. Save method includes lambda expressions!
- Coursework: main panel GUI that presents all the information to the user about a selected project. Anything with "\_gui" on the end is a sub-menu used to create instance of the same name.
- critical_path: critical path algorithm in Kotlin, works with small projects, may not work with larger ones.
- crit_path_scala: critical path in Scala, unfortunately does not work, uncomment to see code (DO NOT INSTALL SCALA as of 27/05/2022, there is a bug which will prevent you from running this program).
- Projects.csv: The csv file holding project information, used for persistence.

## PLEASE NOTE:
- All dates must be in the format of YYYY-MM-DD, it’s how LocalDate likes it.
- The "task leads from" field in the task creation menu takes in a list of all the tasks that are going to file in to this new one. Simply list them out separated with a comma, no spaces needed (A, B, C etc.). If it’s the first task in a project, just type "null".
- Make sure to spell task and team names THE same as shown.


## Software
**Utilised JAVA version 13, Kotlin and Scala programming languages and the Intellij IDEA IDE in this project.**
