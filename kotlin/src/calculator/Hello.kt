import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

fun getUserData(userId: String): ResultSet? {
    val connection: Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password")
    val statement: Statement = connection.createStatement()
    val query = "SELECT * FROM users WHERE id = '$userId'"
    return statement.executeQuery(query)
}

fun main() {
    val userId = "1 OR 1=1" // This is an example of SQL injection
    val resultSet = getUserData(userId)
    while (resultSet?.next() == true) {
        println("User: ${resultSet.getString("username")}")
    }
}
