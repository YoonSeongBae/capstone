package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourthScreen extends JFrame {
    public FourthScreen() {
        setTitle("루틴 선택");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel routineLabel = new JLabel();
        String level = UserPreferences.getLevel();

        if ("beginner".equals(level)) {
            routineLabel.setText("초급 루틴");
        } else if ("intermediate".equals(level)) {
            routineLabel.setText("중급 루틴");
        } else if ("advanced".equals(level)) {
            routineLabel.setText("고급 루틴");
        } else {
            routineLabel.setText("알 수 없는 레벨");
        }

        JButton startButton = new JButton("운동 시작하기");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifthScreen();
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(routineLabel);
        panel.add(startButton);
        add(panel);

        setVisible(true);
    }
}
