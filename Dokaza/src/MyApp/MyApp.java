package MyApp;

import java.awt.*;
import javax.swing.*;

import MyApp.view.MainFrame;

public class MyApp {
    public static void main(String[] args) {
        // Swing은 EDT(Event Dispatch Thread)에서 실행해야 함
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}