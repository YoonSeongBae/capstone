package yoonsungbae

import javax.swing.*

fun createSixthScreen(): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("진행 상황 및 통계 화면")
    label.font = label.font.deriveFont(18.0f)
    panel.add(label)

    val exerciseLabel = JLabel("푸시업")
    val startButton = JButton("시작")
    val restLabel = JLabel("1분간 휴식하세요")
    val timerLabel = JLabel("01:00")
    val nextButton = JButton("다음 운동")

    startButton.addActionListener {
        JOptionPane.showMessageDialog(panel, "운동 시작")
    }
    nextButton.addActionListener {
        JOptionPane.showMessageDialog(panel, "다음 운동으로 이동")
    }

    panel.add(exerciseLabel)
    panel.add(startButton)
    panel.add(restLabel)
    panel.add(timerLabel)
    panel.add(nextButton)

    return panel
}
