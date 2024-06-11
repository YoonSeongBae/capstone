package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SixthScreen extends JFrame {
    private String[] exercises = {"푸쉬업", "턱걸이", "파이크 푸쉬업", "레그 레이즈"};
    private int currentExerciseIndex = 0;
    private JLabel exerciseLabel;
    private JButton nextButton;

    public SixthScreen() {
        setTitle("운동 진행 중");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exerciseLabel = new JLabel(exercises[currentExerciseIndex]);
        nextButton = new JButton("다음 운동");

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextExercise();
            }
        });

        JPanel panel = new JPanel();
        panel.add(exerciseLabel);
        panel.add(nextButton);
        add(panel);

        setVisible(true);
    }

    private void nextExercise() {
        if (currentExerciseIndex < exercises.length - 1) {
            currentExerciseIndex++;
            exerciseLabel.setText(exercises[currentExerciseIndex]);
        } else {
            new SeventhScreen();
            dispose();
        }
    }
}
