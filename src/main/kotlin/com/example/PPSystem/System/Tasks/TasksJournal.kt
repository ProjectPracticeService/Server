package com.example.PPSystem.System.Tasks

class TasksJournal {
    var tasksIdsList: List<com.example.PPSystem.System.Tasks.Task> = listOf()

    fun getUserTasks(userId: Int): List<com.example.PPSystem.System.Tasks.Task> {
        return tasksIdsList
    }
    fun getUserActiveTasks(userId: Int): List<com.example.PPSystem.System.Tasks.Task> {
        return tasksIdsList
    }
    fun getUserComplitedTasks(userId: Int): List<com.example.PPSystem.System.Tasks.Task> {
        return tasksIdsList
    }
    fun getUserOverdueTasks(userId: Int): List<com.example.PPSystem.System.Tasks.Task> {
        return tasksIdsList
    }

}