package todo.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import todo.ToDoListManager

class ToDoListManagerTests {
    private lateinit var toDoListManager: ToDoListManager

    @BeforeEach
    fun setup() {
        toDoListManager = ToDoListManager()
    }

    @Test
    fun `addTask adds a task to the list`() {
        val task = toDoListManager.addTask("Test task")
        assertNotNull(toDoListManager.getTask(task.id))
    }

    @Test
    fun `addTask returns the added task`() {
        val task = toDoListManager.addTask("Test task")
        assertEquals("Test task", task.description)
    }

    @Test
    fun `addTask assigns unique ids to tasks`() {
        val task1 = toDoListManager.addTask("Test task 1")
        val task2 = toDoListManager.addTask("Test task 2")
        assertNotEquals(task1.id, task2.id)
    }
}