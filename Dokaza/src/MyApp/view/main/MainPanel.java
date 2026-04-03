package MyApp.view.main;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	private LeftPanel leftPanel;
	private CenterPanel centerPanel;
	private RightPanel rightPanel;
	
	public MainPanel() {
		setLayout(new GridLayout(1, 3));
		
		leftPanel = new LeftPanel();
		centerPanel = new CenterPanel();
		rightPanel = new RightPanel();
		 
		add(leftPanel);
		add(centerPanel);
		add(rightPanel);
	}
}