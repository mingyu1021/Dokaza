package MyApp;

import java.awt.*;
import javax.swing.*;

import MyApp.view.MainFrame;
import MyApp.model.AppModel;
import MyApp.controller.MainController;

public class MyApp {
    public static void main(String[] args) {
        // Swing은 EDT(Event Dispatch Thread)에서 실행해야 함
        SwingUtilities.invokeLater(() -> {
        	AppModel model       = new AppModel();
            MainFrame mainFrame  = new MainFrame();
            new MainController(mainFrame, model); // 연결
        });
    }
}