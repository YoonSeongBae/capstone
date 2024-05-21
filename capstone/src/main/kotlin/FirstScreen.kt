package yoonsungbae

import javax.swing.*

fun createFirstScreen(): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("한 번에 턱걸이를 몇 개까지 할 수 있으세요?")
    label.font = label.font.deriveFont(18.0f)
    panel.add(label)

    val beginner = JRadioButton("초급: 10개 할 수 있다.")
    val intermediate = JRadioButton("중급: 20개 할 수 있다.")
    val advanced = JRadioButton("고급: 30개 이상 할 수 있다.")
    val group = ButtonGroup()
    group.add(beginner)
    group.add(intermediate)
    group.add(advanced)
    panel.add(beginner)
    panel.add(intermediate)
    panel.add(advanced)

    val nextButton = JButton("다음")
    nextButton.addActionListener {
        JOptionPane.showMessageDialog(panel, "선택한 수준: ${group.selection?.actionCommand}")
    }
    panel.add(nextButton)

    return panel
}
