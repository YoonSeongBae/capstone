package yoonsungbae

import javax.swing.*

fun createSeventhScreen(): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    val label = JLabel("운동 종료 및 동기부여의 말")
    label.font = label.font.deriveFont(18.0f)
    panel.add(label)

    val messageLabel = JLabel("운동 끝!!!")
    val encouragementLabel = JLabel("오늘도 수고하셨습니다. 내일도 계속해서 힘내세요!")

    panel.add(messageLabel)
    panel.add(encouragementLabel)

    val imageIcon = ImageIcon("path_to_image.jpg") // 이미지 경로를 설정하세요.
    val imageLabel = JLabel(imageIcon)
    panel.add(imageLabel)

    return panel
}
