package yoonsungbae

import javax.swing.*

fun createFifthScreen(): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("운동 가이드 화면")
    label.font = label.font.deriveFont(18.0f)
    panel.add(label)

    val exerciseLabel = JLabel("푸시업")
    val targetLabel = JLabel("타겟 부위: 가슴")
    val videoLabel = JLabel("<html><a href='https://www.youtube.com/watch?v=106'>영상 보기</a></html>")

    panel.add(exerciseLabel)
    panel.add(targetLabel)
    panel.add(videoLabel)

    val description = JTextArea(5, 20)
    description.text = "운동 방법:\n1. 양팔을 가슴 옆에 두고 바닥에 엎드립니다.\n2. 팔굽을 펴면서 몸을 밀어 올립니다.\n3. 천천히 팔굽을 굽히며 시작 자세로 돌아갑니다."
    description.isEditable = false
    panel.add(description)

    return panel
}
