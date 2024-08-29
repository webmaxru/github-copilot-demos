package todo

import todo.model.Task


class ToDoListManager {
    private val tasks = mutableListOf<Task>()
    fun addTask(description: String): Task {
        val newTask = Task(id = tasks.size + 1, description = description)
        tasks.add(newTask)
        return newTask
    }

    fun getTask(id: Int): Task? {
        return tasks.find { it.id == id }
    }

    fun updateTask(id: Int, newDescription: String, isCompleted: Boolean): Task {
        val task = tasks.find { it.id == id } ?: throw NoSuchElementException("Task not found")
        task.description = newDescription
        task.isCompleted = isCompleted
        return task
    }

    fun removeTask(id: Int): Boolean {
        return tasks.removeIf { it.id == id }
    }

    fun listAllTasks(): List<Task> {
        return tasks.toList()
    }

    fun listCompletedTasks(): List<Task> {
        return tasks.filter { it.isCompleted }
    }

    fun listPendingTasks(): List<Task> {
        return tasks.filterNot { it.isCompleted }
    }
}