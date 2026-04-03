package MyApp.view.main;

import java.awt.*;
import javax.swing.*;

public class CenterPanel extends JPanel {
	
	public CenterPanel() {
      setBackground(new Color(240, 240, 240));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      JLabel centerTitle = new JLabel("📋 메인 콘텐츠");
      centerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      centerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

      JLabel centerSub = new JLabel("내용이 들어오는 영역");
      centerSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
      centerSub.setForeground(Color.GRAY);
      centerSub.setAlignmentX(Component.CENTER_ALIGNMENT);

      add(Box.createVerticalGlue());
      add(centerTitle);
      add(Box.createVerticalStrut(8));
      add(centerSub);
      add(Box.createVerticalGlue());
	}
}