package MyApp.view;

import java.awt.*;
import javax.swing.*;

import MyApp.view.top.TopPanel;
import MyApp.view.bottom.BottomPanel;
import MyApp.view.center.MainPanel;

public class MainFrame extends JFrame {
    private TopPanel topPanel;
    private MainPanel mainPanel;
    private BottomPanel bottomPanel;
    
    public MainFrame() {
        setTitle("Dokaza v0.1");
        setSize(1200, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());

        topPanel    = new TopPanel();
        mainPanel   = new MainPanel();
        bottomPanel = new BottomPanel();

        add(topPanel,    BorderLayout.NORTH);
        add(mainPanel,   BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    public TopPanel getTopPanel()    { return topPanel; }
    
    public MainPanel   getMainPanel()   { return mainPanel; }
    
    public BottomPanel getBottomPanel() { return bottomPanel; }
}