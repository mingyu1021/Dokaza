package MyApp.view.center;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	private LeftPanel leftPanel;
	private MiddlePanel middlePanel;
	private RightPanel rightPanel;
	
	public MainPanel() {
		setLayout(new GridLayout(1, 3));
		
		leftPanel = new LeftPanel();
		middlePanel = new MiddlePanel();
		rightPanel = new RightPanel();
		 
		add(leftPanel);
		add(middlePanel);
		add(rightPanel);
	}
	
	public LeftPanel    getLeftPanel()    { return leftPanel; }
    public MiddlePanel   getMiddlePanel()   { return middlePanel; }
    public RightPanel getRightPanel() { return rightPanel; }
}