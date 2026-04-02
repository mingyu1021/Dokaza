package MyApp;

import javax.swing.*;
import java.awt.*;

public class MyApp {
    public static void main(String[] args) {
        // 창 만들기
        JFrame frame = new JFrame("나의 첫 GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 버튼 만들기
        JButton button = new JButton("클릭하요요!");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "안녕하세요! 🎉");
        });

        // 화면에 추가
        frame.add(button, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}