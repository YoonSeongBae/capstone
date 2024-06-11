package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class FifthScreen extends JFrame {
    private String[] exercises = {"푸쉬업", "턱걸이", "파이크 푸쉬업", "스텝업", "런지", "점프 스쿼트", "레그 레이즈"};
    private int currentExerciseIndex = 0;
    private JLabel exerciseLabel;
    private JButton startButton;
    private JLabel timerLabel;
    private Timer timer;
    private int timeRemaining = 60; // 60초 타이머

    public FifthScreen() {
        setTitle("운동 진행 중");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 한글 폰트 설정
        Font font = new Font("맑은 고딕", Font.PLAIN, 20);

        exerciseLabel = new JLabel(exercises[currentExerciseIndex]);
        exerciseLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        exerciseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        startButton = new JButton("시작");
        startButton.setFont(font);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        JLabel restLabel = new JLabel("1분간 휴식하세요");
        restLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        restLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timerLabel = new JLabel("01:00");
        timerLabel.setFont(font);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton nextButton = new JButton("다음 운동");
        nextButton.setFont(font);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextExercise();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(exerciseLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(restLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(timerLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(nextButton);

        add(panel);
        setVisible(true);
    }

    private void startTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timeRemaining = 60;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                timeRemaining--;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        timerLabel.setText(String.format("%02d:%02d", timeRemaining / 60, timeRemaining % 60));
                    }
                });
                if (timeRemaining <= 0) {
                    timer.cancel();
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            timerLabel.setText("01:00");
                        }
                    });
                }
            }
        }, 1000, 1000);
    }

    private void nextExercise() {
        if (currentExerciseIndex < exercises.length - 1) {
            currentExerciseIndex++;
            exerciseLabel.setText(exercises[currentExerciseIndex]);
            timerLabel.setText("01:00");
            if (timer != null) {
                timer.cancel();
            }
        } else {
            new SeventhScreen();
            dispose();
        }
    }
}

