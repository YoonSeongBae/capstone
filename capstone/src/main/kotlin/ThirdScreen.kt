package yoonsungbae

import javax.swing.*

fun createThirdScreen(): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("추천 루틴 및 루틴 선택")
    label.font = label.font.deriveFont(18.0f)
    panel.add(label)

    val recommendLabel = JLabel("추천 루틴: 고급")
    panel.add(recommendLabel)

    val beginner = JRadioButton("초급")
    val intermediate = JRadioButton("중급")
    val advanced = JRadioButton("고급")
    val group = ButtonGroup()
    group.add(beginner)
    group.add(intermediate)
    group.add(advanced)
    panel.add(beginner)
    panel.add(intermediate)
    panel.add(advanced)

    val startButton = JButton("어플 시작하기")
    startButton.addActionListener {
        JOptionPane.showMessageDialog(panel, "선택한 루틴: ${group.selection?.actionCommand}")
    }
    panel.add(startButton)

    return panel
}

