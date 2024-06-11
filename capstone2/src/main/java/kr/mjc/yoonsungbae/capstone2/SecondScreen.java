package kr.mjc.yoonsungbae.capstone2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondScreen extends JFrame {
    public SecondScreen() {
        setTitle("선택 확인");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel selectedLevelLabel = new JLabel();
        String level = UserPreferences.getLevel();

        if ("beginner".equals(level)) {
            selectedLevelLabel.setText("선택한 레벨: 초급");
        } else if ("intermediate".equals(level)) {
            selectedLevelLabel.setText("선택한 레벨: 중급");
        } else if ("advanced".equals(level)) {
            selectedLevelLabel.setText("선택한 레벨: 고급");
        } else {
            selectedLevelLabel.setText("알 수 없는 레벨");
        }

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ThirdScreen();
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(selectedLevelLabel);
        panel.add(confirmButton);
        add(panel);

        setVisible(true);
    }
}
