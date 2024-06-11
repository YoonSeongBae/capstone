package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpScreen extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public SignUpScreen() {
        setTitle("회원 가입");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("이메일:");
        emailLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        passwordField = new JPasswordField(20);

        signUpButton = new JButton("가입");
        signUpButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(signUpButton);

        add(panel);
        setVisible(true);
    }

    private void signUp() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
            new FirstScreen();
            this.dispose();
            return;
        }

        String url = "jdbc:mysql://localhost:3306/user";
        String dbUser = "your_database_user";  // 예: "root"
        String dbPassword = "0326";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword)) {
            String sql = "INSERT INTO Users (name, email, password, level) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, "beginner");

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "가입 중 오류가 발생했습니다: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        } finally {
            new FirstScreen();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpScreen();
            }
        });
    }
}
