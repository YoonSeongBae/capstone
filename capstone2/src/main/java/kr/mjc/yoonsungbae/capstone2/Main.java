package kr.mjc.yoonsungbae.capstone2;

import kr.mjc.yoonsungbae.capstone2.FirstScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FirstScreen();
            }
        });
    }
}
