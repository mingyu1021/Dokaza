 package MyApp.view.center;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MiddlePanel extends JPanel {
	private JTextArea textArea;
	
	public MiddlePanel() {
      setBackground(new Color(240, 240, 240));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      JLabel centerTitle = new JLabel("📋 메인 콘텐츠");
      centerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      centerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

      JLabel centerSub = new JLabel("내용이 들어오는 영역");
      centerSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
      centerSub.setForeground(Color.GRAY);
      centerSub.setAlignmentX(Component.CENTER_ALIGNMENT);
      
   // 텍스트 출력 영역 (왼쪽 창과 동일한 형태)
      textArea = new JTextArea(15, 20);
      textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      
   // ★ 중요: 가운데 창은 출력 전용이므로 수정 불가 처리
      textArea.setEditable(false); 
      textArea.setBackground(new Color(245, 245, 245)); // 살짝 회색 배경으로 읽기 전용 느낌 주기
      textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      // 크기는 프로젝트 화면 사이즈에 맞게 조절하세요
      Dimension panelSize = new Dimension(250, 400);
      scrollPane.setPreferredSize(panelSize);
      scrollPane.setMaximumSize(panelSize);

      add(Box.createVerticalGlue());
      add(centerTitle);
      add(Box.createVerticalStrut(8));
      add(centerSub);
      add(Box.createVerticalGlue());
      add(scrollPane);
	}
	
	public void setText(String text) { textArea.setText(text); }
}