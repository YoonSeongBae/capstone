package yoonsungbae

import javax.swing.*
import java.awt.*

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("운동 루틴 설계")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(600, 800)

        val mainPanel = JPanel(CardLayout())
        val cardLayout = mainPanel.layout as CardLayout

        mainPanel.add(createFirstScreenPanel(mainPanel, cardLayout), "Screen1")
        mainPanel.add(createSecondScreenPanel(mainPanel, cardLayout), "Screen2")
        mainPanel.add(createThirdScreenPanel(mainPanel, cardLayout), "Screen3")
        mainPanel.add(createFourthScreenPanel(mainPanel, cardLayout), "Screen4")
        mainPanel.add(createFifthScreenPanel(mainPanel, cardLayout), "Screen5")
        mainPanel.add(createSixthScreenPanel(mainPanel, cardLayout), "Screen6")
        mainPanel.add(createSeventhScreenPanel(mainPanel, cardLayout), "Screen7")

        frame.contentPane.add(mainPanel)
        frame.isVisible = true

        cardLayout.show(mainPanel, "Screen1")
    }
}

fun createFirstScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
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
        cardLayout.show(mainPanel, "Screen2")
    }
    panel.add(nextButton)

    return panel
}

fun createThirdScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
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
        cardLayout.show(mainPanel, "Screen4")
    }
    panel.add(startButton)

    return panel
}

fun createFourthScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
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
        cardLayout.show(mainPanel, "Screen5")
    }
    panel.add(startButton)

    return panel
}

fun createFifthScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
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

    val nextButton = JButton("다음")
    nextButton.addActionListener {
        cardLayout.show(mainPanel, "Screen6")
    }
    panel.add(nextButton)

    return panel
}

fun createSixthScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
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
        cardLayout.show(mainPanel, "Screen7")
    }
    nextButton.addActionListener {
        cardLayout.show(mainPanel, "Screen1")
    }

    panel.add(exerciseLabel)
    panel.add(startButton)
    panel.add(restLabel)
    panel.add(timerLabel)
    panel.add(nextButton)

    return panel
}

fun createSeventhScreenPanel(mainPanel: JPanel, cardLayout: CardLayout): JPanel {
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

    val finishButton = JButton("완료")
    finishButton.addActionListener {
        cardLayout.show(mainPanel, "Screen1")
    }
    panel.add(finishButton)

    return panel
}
