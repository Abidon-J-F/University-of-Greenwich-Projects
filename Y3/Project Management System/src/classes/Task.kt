package classes

import java.time.LocalDate
import java.util.*

class Task(
    val taskDesc: String, //private classes.Team assignedTo;
    val assignedProj: Project, val duration: Int, val predecessors: String
) {

    var taskStartDate: LocalDate? = null
        private set
    var taskEndDate: LocalDate? = null
        private set
    private var isFirst = false
    private var isLast = false
    val nextTasks = ArrayList<Task>()
    val prevTasks = ArrayList<Task?>()
    var isCompleted = false
        private set
    var assignedTeam: Team
    @JvmField
    var criticalCost = 0
    var danum = 0;

    fun checkPosition() {
        val otherJobs = assignedProj.projectTasks
        val thisIndex = otherJobs.indexOf(this)
        if (thisIndex == 0 && prevTasks.isEmpty()) {
            isFirst = true
            isLast = false
            taskStartDate = assignedProj.startDate
        }
        if (thisIndex + 1 == otherJobs.size && otherJobs.size > 1 && nextTasks.isEmpty()) {
            isLast = true
            isFirst = false
            var max = LocalDate.parse("1111-11-11")
            for (i in prevTasks.indices) {
                val c = prevTasks[i]!!.taskStartDate!!.plusDays(prevTasks[i]!!.duration.toLong())
                if (c.compareTo(max) > 0) max = c
            }
            taskStartDate = max
        } else if (otherJobs.size > 1 && thisIndex != 0 && thisIndex != otherJobs.size - 1) {
            var max = LocalDate.parse("1111-11-11")
            for (i in prevTasks.indices) {
                val c = prevTasks[i]!!.taskStartDate!!.plusDays(prevTasks[i]!!.duration.toLong())
                if (c.compareTo(max) > 0) max = c
            }
        }
        taskEndDate = taskStartDate!!.plusDays(duration.toLong())
    }

    fun isDependant(t: Task): Boolean {
        if (nextTasks.contains(t)) {
            return true
        }
        for (g in nextTasks) {
            if (g.isDependant(t)) {
                return true
            }
        }
        return false
    }

    fun setTaskComplete() {
        isCompleted = true
    }

    fun getIsCompleted(): Boolean{
        return isCompleted;
    }

    fun getCritCost(): Int{
        return criticalCost;
    }
    fun getdanum(): Int{
        return danum;
    }
    fun setdanum(i: Int){
        danum = i;
    }
    @JvmName("getTaskDesc1")
    fun getTaskDesc(): String{
        return taskDesc;
    }

    @JvmName("getDuration1")
    fun getDuration(): Int{
        return duration;
    }
    init {
        assignedTeam = assignedProj.nonAssigned
        if (predecessors != "null") {
            val nodes = predecessors.split(",".toRegex()).toTypedArray()
            for (node in nodes) {
                assignedProj.getTaskOfDescription(node)!!.nextTasks.add(this)
                prevTasks.add(assignedProj.getTaskOfDescription(node))
            }
        }
    }
}