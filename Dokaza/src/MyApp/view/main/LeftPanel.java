package MyApp.view.main;

import java.awt.*;
import javax.swing.*;

public class LeftPanel extends JPanel {
	private JTextArea textArea;
	
	public LeftPanel() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      JLabel leftTitle = new JLabel("📁 메뉴");
      leftTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      leftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

      JLabel leftSub = new JLabel("사이드바 영역");
      leftSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
      leftSub.setForeground(Color.GRAY);
      leftSub.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      textArea = new JTextArea();
      textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      
      JScrollPane scrollPane = new JScrollPane(textArea);
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

}