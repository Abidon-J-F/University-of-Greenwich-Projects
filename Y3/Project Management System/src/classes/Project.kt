package classes

import java.io.Serializable
import java.time.LocalDate
import java.util.*

class Project(private var projName: String, val projNote: String, startdate: String?, dur: Int) : Serializable {
    val projectTasks = ArrayList<Task>()
    val projectTeams = ArrayList<Team>()
    val startDate: LocalDate
    val projDuration: Int
    var currentTask: Task? = null
        private set
    @JvmField
    var nonAssigned = Team("N/A")
    fun addTask(desc: String, d: Int, addTo: String) {
        val tmp = Task(desc, this, d, addTo)
        projectTasks.add(tmp)
        tmp.checkPosition()
        for (i in 0 until projectTasks.size - 1) {
            val t = projectTasks[i]
            t.checkPosition()
        }
        findCurrentTask()
    }

    fun findCurrentTask() {
        for (task in projectTasks) {
            val check = task.isCompleted
            if (!check) {
                currentTask = task
                break
            }
        }
    }

    fun createTeam(name: String, desc: String, n: Int) {
        val tmp = Team(name, desc, n)
        projectTeams.add(tmp)
    }

    fun AssignTeamToTask(team: String, task: String) {
        val te = getTeamOfName(team)
        val tk = getTaskOfDescription(task)
        if (te == null || tk == null) {
            println("ERROR: cannot find team or task")
        } else {
            tk.assignedTeam = te
            te.assignTask(tk)
        }
    }

    fun getTeamOfName(name: String): Team? {
        var a: Team? = null
        for (projectTeam in projectTeams) {
            if (projectTeam.getTeamName() == name) {
                a = projectTeam
                break
            }
        }
        return a
    }

    fun getTaskOfDescription(description: String): Task? {
        var a: Task? = null
        for (projectTask in projectTasks) {
            if (projectTask.taskDesc == description) {
                a = projectTask
                break
            }
        }
        return a
    }

    fun getProjName(): String {
        return projName
    } //returns project name

    fun setProjName(a: String) { //sets the project name
        if (a.length > 20) {
            print("Error: project name exceeds length")
        } else {
            projName = a
        }
    }

    //constructor
    init {
        startDate = LocalDate.parse(startdate)
        projDuration = dur
        val expdEndDate = startDate.plusDays(projDuration.toLong())
    }
}