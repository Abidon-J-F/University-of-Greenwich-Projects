# JVM Programming Languages

### Welcome to our coursework, in the following classes you will find the following code in the following classes:

- Project: holds the logic and structure for the projects, including tasks and teams that are included.
- Task: structure for a task, holds a description, duration, and link to the project it belongs to.
- Team: holds the team’s name and a list of projects assigned to that team.
- programHandler: contains a list of all the projects held in the program, as well as the main method, save and load methods. Save method includes lambda expressions!
- Coursework: main panel GUI that presents all the information to the user about a selected project. Anything with "\_gui" on the end is a sub-menu used to create instance of the same name.
- critical_path: critical path algorithm in Kotlin, works with small projects, may not work with larger ones
- crit_path_scala: critical path in Scala, unfortunately does not work, uncomment to see code
- Projects.csv: The csv file holding project information, used for persistence

## PLEASE NOTE:
- All dates must be in the format of YYYY-MM-DD, it’s how LocalDate likes it.
- The "task leads from" field in the task creation menu takes in a list of all the tasks that are going to file in to this new one. Simply list them out separated with a comma, no spaces needed (A, B, C etc.). If it’s the first task in a project, just type "null".
- Make sure to spell task and team names THE same as shown.

Enjoy!
