package MyApp.view.top;

import java.awt.*;
import javax.swing.*;

public class TopPanel extends JPanel {
	
	public TopPanel() {
		setBackground(new Color(45, 45, 45));
		setPreferredSize(new Dimension(1200, 60));
		
		JLabel titleLabel = new JLabel("DOKAZA");
	    titleLabel.setForeground(Color.WHITE);
	    titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
	    add(titleLabel);
	}
}

