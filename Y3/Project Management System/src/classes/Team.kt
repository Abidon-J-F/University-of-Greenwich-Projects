package classes

import java.util.*

class Team {
    private var TeamName: String? = null
    var teamDescription: String? = null
        private set
    private var teamTasks: ArrayList<Task>? = null
    var iD = 0
        private set

    constructor(name: String, desc: String?, n: Int) {
        if (name.length > 20) {
            print("ERROR: classes.Team name too long")
        } else {
            TeamName = name
        }
        teamDescription = desc
        iD = n
        teamTasks = ArrayList()
    }

    constructor(name: String) {
        if (name == "N/A" || name.isEmpty()) {
            TeamName = "N/A"
        }
    }

    fun getTeamName(): String? {
        return if (TeamName == "N/A") {
            "null"
        } else {
            TeamName
        }
    }

    fun assignTask(tk: Task) {
        teamTasks!!.add(tk)
    }
}