class TasksJournal {
    var tasksIdsList: List<Task> = listOf()

    fun getUserTasks(userId: Int): List<Task> {
        return tasksIdsList
    }
    fun getUserActiveTasks(userId: Int): List<Task> {
        return tasksIdsList
    }
    fun getUserComplitedTasks(userId: Int): List<Task> {
        return tasksIdsList
    }
    fun getUserOverdueTasks(userId: Int): List<Task> {
        return tasksIdsList
    }

}