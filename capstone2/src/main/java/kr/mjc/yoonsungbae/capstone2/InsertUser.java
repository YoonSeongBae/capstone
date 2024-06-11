package kr.mjc.yoonsungbae.capstone2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUser {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user";
        String user = "your_database_user";  // 예: "root"
        String password = "0326";

        String sql = "INSERT INTO Users (name, email, password, level) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "홍길동");
            pstmt.setString(2, "hong@example.com");
            pstmt.setString(3, "password123");
            pstmt.setString(4, "beginner");
            pstmt.executeUpdate();

            System.out.println("사용자 데이터가 성공적으로 삽입되었습니다.");

        } catch (SQLException e) {
            System.out.println("사용자 데이터 삽입 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
