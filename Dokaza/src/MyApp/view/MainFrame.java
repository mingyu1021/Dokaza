package MyApp.view;

import java.awt.*;
import javax.swing.*;

import MyApp.view.top.TopPanel;
import MyApp.view.main.MainPanel;
import MyApp.view.bottom.BottomPanel;

public class MainFrame extends JFrame {
    private TopPanel topPanel;
    private MainPanel mainPanel;
    private BottomPanel bottomPanel;
    
    

    public MainFrame() {
        setTitle("Dokaza");
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
}