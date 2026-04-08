package MyApp.view.center;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LeftPanel extends JPanel {
	private JTextArea textArea;
	
	public LeftPanel() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      JLabel leftTitle = new JLabel("PROMPT");
      leftTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      leftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

      JLabel leftSub = new JLabel("프롬프 입력 시 한글, 설명이 출력됩니다.");
      leftSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
      leftSub.setForeground(Color.GRAY);
      leftSub.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      textArea = new JTextArea(); // 가로로 긴 1줄짜리 입력창
      textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
      textArea.setMaximumSize(new Dimension(300, 35)); 
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setBorder(BorderFactory.createCompoundBorder(
              BorderFactory.createLineBorder(Color.GRAY), // 겉은 회색 선
              BorderFactory.createEmptyBorder(5, 5, 5, 5) // 안쪽 5px 여백
          ));
      textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
   // 3. JTextArea를 스크롤 패널에 담기 (여러 줄을 입력할 수 있도록 영역 보장)
      JScrollPane scrollPane = new JScrollPane(textArea);
      // 가로 300 고정, 세로는 35보다 약간 키운 80 정도로 설정해야 줄바꿈된 글자가 보입니다.
      scrollPane.setPreferredSize(new Dimension(300, 600));
      scrollPane.setMaximumSize(new Dimension(300, 600)); 
      scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      add(Box.createVerticalStrut(20));
      add(leftTitle);
      add(Box.createVerticalStrut(8));
      add(leftSub);
      add(Box.createVerticalStrut(20));
      add(scrollPane);
      add(Box.createVerticalStrut(20));


      
	}// 내용 저장할 때 사용
    public String getText() { return textArea.getText(); }

    // 내용 불러올 때 사용
    public void setText(String text) { textArea.setText(text); }
    
    public JTextArea getTextArea() { return textArea; }
}