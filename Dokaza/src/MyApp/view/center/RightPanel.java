package MyApp.view.center;

import java.awt.*;
import javax.swing.*;

public class RightPanel extends JPanel {
    private JButton addWordButton;
    private JPanel wordListPanel;
    
    public RightPanel() {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel rightTitle = new JLabel("⚙ 설정");
        rightTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        rightTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel rightSub = new JLabel("우측 패널 영역");
        rightSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        rightSub.setForeground(Color.GRAY);
        rightSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // 단어 블록들이 수직으로 쌓일 안쪽 패널
        wordListPanel = new JPanel();
        wordListPanel.setLayout(new BoxLayout(wordListPanel, BoxLayout.Y_AXIS));
        wordListPanel.setBackground(Color.WHITE); // 스크롤 안쪽 배경도 하얗게 통일

        // 단어가 많아지면 스크롤이 생기도록 JScrollPane에 담기
        JScrollPane scrollPane = new JScrollPane(wordListPanel);
        
        // ★ 추가: LeftPanel, MiddlePanel과 완벽히 동일한 300x600 크기로 고정!
        Dimension fixedSize = new Dimension(300, 600);
        scrollPane.setPreferredSize(fixedSize);
        scrollPane.setMaximumSize(fixedSize);
        scrollPane.setMinimumSize(fixedSize);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        addWordButton = new JButton("단어 추가하기");
        addWordButton.setAlignmentX(Component.CENTER_ALIGNMENT); // 버튼 가운데 정렬
        addWordButton.setMaximumSize(new Dimension(150, 40)); // 버튼 크기 살짝 키우기 (선택사항)

        add(Box.createVerticalStrut(20));
        add(rightTitle);
        add(Box.createVerticalStrut(8));
        add(rightSub);
        add(Box.createVerticalStrut(20));
        
        // ★ 수정: BoxLayout을 쓰고 있으므로 BorderLayout.CENTER 속성은 뺐습니다.
        add(scrollPane); 
        
        add(Box.createVerticalStrut(15)); // 스크롤 패널과 버튼 사이의 간격
        add(addWordButton);
        add(Box.createVerticalStrut(20));
    }
    
    public JButton getAddWordButton() { return this.addWordButton; }
    
    public JPanel getWordListPanel() { return wordListPanel; }
}