package todo.model

data class Task(
    val id: Int,
    var description: String,
    var isCompleted: Boolean = false
)
