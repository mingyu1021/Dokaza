package MyApp.view.bottom;

import java.awt.*;
import javax.swing.*;

public class BottomPanel extends JPanel {
	
	
	public BottomPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(new Color(45, 45, 45));
		setPreferredSize(new Dimension(1200, 30));

		JLabel statusLabel = new JLabel("  ✅ 준비 완료");
		statusLabel.setForeground(Color.LIGHT_GRAY);
		statusLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		add(statusLabel);
	}
}