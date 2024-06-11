package kr.mjc.yoonsungbae.capstone2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeventhScreen extends JFrame {
    public SeventhScreen() {
        setTitle("운동 완료");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel completeLabel = new JLabel("루틴 완료!");
        completeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        completeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton exitButton = new JButton("종료");
        exitButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(completeLabel, BorderLayout.CENTER);
        panel.add(exitButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
