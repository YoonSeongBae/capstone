package kr.mjc.yoonsungbae.capstone2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user";
        String user = "your_database_user";  // 예: "root"
        String password = "0326";

        String usersTable = "CREATE TABLE IF NOT EXISTS Users ("
                + "user_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "password VARCHAR(255) NOT NULL,"
                + "level VARCHAR(50) NOT NULL"
                + ");";

        String exercisesTable = "CREATE TABLE IF NOT EXISTS Exercises ("
                + "exercise_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "description TEXT,"
                + "image BLOB"
                + ");";

        String routinesTable = "CREATE TABLE IF NOT EXISTS Routines ("
                + "routine_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "level VARCHAR(50) NOT NULL,"
                + "set_count INT NOT NULL,"
                + "rep_count INT NOT NULL"
                + ");";

        String userRoutinesTable = "CREATE TABLE IF NOT EXISTS UserRoutines ("
                + "user_routine_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "user_id INT NOT NULL,"
                + "routine_id INT NOT NULL,"
                + "date DATE NOT NULL,"
                + "FOREIGN KEY (user_id) REFERENCES Users(user_id),"
                + "FOREIGN KEY (routine_id) REFERENCES Routines(routine_id)"
                + ");";

        String routineExercisesTable = "CREATE TABLE IF NOT EXISTS RoutineExercises ("
                + "routine_exercise_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "routine_id INT NOT NULL,"
                + "exercise_id INT NOT NULL,"
                + "sequence INT NOT NULL,"
                + "FOREIGN KEY (routine_id) REFERENCES Routines(routine_id),"
                + "FOREIGN KEY (exercise_id) REFERENCES Exercises(exercise_id)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute(usersTable);
            stmt.execute(exercisesTable);
            stmt.execute(routinesTable);
            stmt.execute(userRoutinesTable);
            stmt.execute(routineExercisesTable);

            System.out.println("테이블이 성공적으로 생성되었습니다.");

        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}

