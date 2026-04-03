package MyApp.view.main;

import java.awt.*;
import javax.swing.*;

public class RightPanel extends JPanel {
	
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

      add(Box.createVerticalGlue());
      add(rightTitle);
      add(Box.createVerticalStrut(8));
      add(rightSub);
      add(Box.createVerticalGlue());
	}
}