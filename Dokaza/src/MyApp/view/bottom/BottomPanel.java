package MyApp.view.bottom;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BottomPanel extends JPanel {
	private JLabel statusLabel;
	
	public BottomPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(new Color(45, 45, 45));
		setPreferredSize(new Dimension(1200, 30));

		statusLabel = new JLabel("  ✅ 준비 완료");
		statusLabel.setForeground(Color.LIGHT_GRAY);
		statusLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		JButton button = new JButton("Click");
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        });
		
		add(button);
		add(statusLabel);
	}
	public void setStatus(String text) {
		statusLabel.setText(text);
	}
}