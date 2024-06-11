package kr.mjc.yoonsungbae.capstone2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstScreen extends JFrame {
    public FirstScreen() {
        setTitle("초, 중, 고급 선택");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton beginnerButton = new JRadioButton("초급");
        JRadioButton intermediateButton = new JRadioButton("중급");
        JRadioButton advancedButton = new JRadioButton("고급");

        Font font = new Font("맑은 고딕", Font.PLAIN, 20);
        beginnerButton.setFont(font);
        intermediateButton.setFont(font);
        advancedButton.setFont(font);

        ButtonGroup group = new ButtonGroup();
        group.add(beginnerButton);
        group.add(intermediateButton);
        group.add(advancedButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(beginnerButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(intermediateButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(advancedButton);
        buttonPanel.add(Box.createVerticalGlue());

        JButton confirmButton = new JButton("확인");
        confirmButton.setFont(font);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedLevel = null;
                if (beginnerButton.isSelected()) {
                    selectedLevel = "beginner";
                } else if (intermediateButton.isSelected()) {
                    selectedLevel = "intermediate";
                } else if (advancedButton.isSelected()) {
                    selectedLevel = "advanced";
                }

                if (selectedLevel != null) {
                    saveLevelAndProceed(selectedLevel);
                } else {
                    JOptionPane.showMessageDialog(null, "레벨을 선택해주세요.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(confirmButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void saveLevelAndProceed(String level) {
        UserPreferences.setLevel(level);
        new ThirdScreen();
        this.dispose();
    }
}
