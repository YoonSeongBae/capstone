package yoonsungbae

import javax.swing.*

fun createFourthScreen(): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("현재 루틴")
    label.font = label.font.deriveFont(18.0f)
    panel.add(label)

    val columnNames = arrayOf("운동명", "세트 수", "횟수")
    val data = arrayOf(
        arrayOf("푸시업", "5 Sets", "30 Reps"),
        arrayOf("턱걸이", "5 Sets", "10 Reps"),
        arrayOf("파이크 푸시업", "5 Sets", "30 Reps"),
        arrayOf("스쿼트", "5 Sets", "30 Reps"),
        arrayOf("런지", "5 Sets", "20 Reps"),
        arrayOf("점프 스쿼트", "5 Sets", "20 Reps"),
        arrayOf("레그레이즈", "5 Sets", "30 Reps")
    )

    val table = JTable(data, columnNames)
    val scrollPane = JScrollPane(table)
    panel.add(scrollPane)

    val startButton = JButton("운동 시작하기")
    startButton.addActionListener {
        JOptionPane.showMessageDialog(panel, "운동을 시작합니다")
    }
    panel.add(startButton)

    return panel
}
