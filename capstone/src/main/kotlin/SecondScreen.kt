package yoonsungbae

import javax.swing.*
import java.awt.*

fun createSecondScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("운동을 시작할 때의 자신의 키, 몸무게를 저장할 수 있는 화면")
    label.font = label.font.deriveFont(16.0f)
    panel.add(label)

    val heightLabel = JLabel("키:")
    val heightField = JTextField(10)
    val weightLabel = JLabel("몸무게:")
    val weightField = JTextField(10)

    val heightPanel = JPanel(FlowLayout(FlowLayout.LEFT))
    heightPanel.add(heightLabel)
    heightPanel.add(heightField)

    val weightPanel = JPanel(FlowLayout(FlowLayout.LEFT))
    weightPanel.add(weightLabel)
    weightPanel.add(weightField)

    panel.add(heightPanel)
    panel.add(weightPanel)

    val nextButton = JButton("다음")
    nextButton.addActionListener {
        cardLayout.show(mainPanel, "Screen3")
    }
    panel.add(nextButton)

    return panel
}
