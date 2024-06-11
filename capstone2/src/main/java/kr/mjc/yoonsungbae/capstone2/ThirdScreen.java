package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdScreen extends JFrame {
    public ThirdScreen() {
        setTitle("현재 루틴");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("현재 루틴");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        String level = UserPreferences.getLevel();
        JLabel levelLabel = new JLabel(level);
        levelLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        String[] columnNames = {"운동명", "세트 수", "횟수"};
        String[][] data = getRoutineData(level);

        JTable routineTable = new JTable(data, columnNames);
        routineTable.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        routineTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(routineTable);

        JButton startButton = new JButton("운동 시작하기");
        startButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifthScreen();
                dispose();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(levelLabel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private String[][] getRoutineData(String level) {
        if ("beginner".equals(level)) {
            return new String[][] {
                    {"푸쉬업", "3 Sets", "15 Reps"},
                    {"턱걸이", "3 Sets", "5 Reps"},
                    {"파이크 푸쉬업", "3 Sets", "15 Reps"},
                    {"스텝업", "3 Sets", "15 Reps"},
                    {"런지", "3 Sets", "10 Reps"},
                    {"점프 스쿼트", "3 Sets", "10 Reps"},
                    {"레그 레이즈", "3 Sets", "15 Reps"}
            };
        } else if ("intermediate".equals(level)) {
            return new String[][] {
                    {"푸쉬업", "4 Sets", "20 Reps"},
                    {"턱걸이", "4 Sets", "8 Reps"},
                    {"파이크 푸쉬업", "4 Sets", "20 Reps"},
                    {"스텝업", "4 Sets", "20 Reps"},
                    {"런지", "4 Sets", "15 Reps"},
                    {"점프 스쿼트", "4 Sets", "15 Reps"},
                    {"레그 레이즈", "4 Sets", "20 Reps"}
            };
        } else if ("advanced".equals(level)) {
            return new String[][] {
                    {"푸쉬업", "5 Sets", "30 Reps"},
                    {"턱걸이", "5 Sets", "10 Reps"},
                    {"파이크 푸쉬업", "5 Sets", "30 Reps"},
                    {"스텝업", "5 Sets", "30 Reps"},
                    {"런지", "5 Sets", "20 Reps"},
                    {"점프 스쿼트", "5 Sets", "20 Reps"},
                    {"레그 레이즈", "5 Sets", "30 Reps"}
            };
        }
        return new String[0][0];
    }
}
