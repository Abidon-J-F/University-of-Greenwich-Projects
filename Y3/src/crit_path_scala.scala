/*
import classes.Task
import java.util
import scala.jdk.CollectionConverters._
class crit_path_scala(val h: programHandler) {
  handler = h
  var handler = programHandler.getInstance
  val tasks = handler.getCurrentProject.getProjectTasks
  val remaining = handler.getCurrentProject.getProjectTasks
  val sp = tasks.get(0)
  val ep = tasks.get(tasks.size - 1)
  val visited = new util.ArrayList[Task]
  val criticalPath = new util.ArrayList[Task]
  var this_node = sp

  def calculate_critical_path() = {
    while ( {
      !(this_node == ep)
    }) {
      var highest_cost = 0
      var highest_cost_node = null
      for (node <- this_node.getNextTasks) {
        if (node.getDuration >= highest_cost) {
          highest_cost = node.getDuration
          highest_cost_node = node
        }
      }
      criticalPath.add(this_node)
      remaining.remove(this_node)
      this_node = highest_cost_node
    }
    var output = ""
    for (item <- criticalPath) {
      output = output.concat(item.getTaskDesc).concat(", ")
    }
    output = output.concat(this_node.getTaskDesc)
    System.out.println(output)
  }
}

 */