package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {
    public MainScreen() {
        setTitle("메인 화면");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("환영합니다!");
        welcomeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(welcomeLabel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
