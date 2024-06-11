package kr.mjc.yoonsungbae.capstone2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUsers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user";
        String user = "your_database_user";  // 예: "root"
        String password = "0326";

        String sql = "SELECT * FROM Users";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("user_id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getString("level"));
            }

        } catch (SQLException e) {
            System.out.println("사용자 데이터 조회 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
