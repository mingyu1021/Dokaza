package MyApp;
import javax.swing.*;
import java.awt.*;

public class MyApp {
    public static void main(String[] args) {
        // 창 만들기
        JFrame frame = new JFrame();
        frame.setTitle("Dokaza");
        frame.setSize(1200, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ContentPane 가져오기
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        // ───────────────────────────────
        // 상단 타이틀 영역 (NORTH)
        // ───────────────────────────────
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(45, 45, 45));
        topPanel.setPreferredSize(new Dimension(1200, 60));
        
        JLabel titleLabel = new JLabel("Dokaza");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        topPanel.add(titleLabel);
        
        contentPane.add(topPanel, BorderLayout.NORTH);
        
        // ───────────────────────────────
        // 메인 패널 3분할 (CENTER)
        // ───────────────────────────────
        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        // 왼쪽 패널
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JLabel leftTitle = new JLabel("📁 메뉴");
        leftTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        leftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel leftSub = new JLabel("사이드바 영역");
        leftSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        leftSub.setForeground(Color.GRAY);
        leftSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(leftTitle);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(leftSub);
        leftPanel.add(Box.createVerticalGlue());

        // 가운데 패널
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(240, 240, 240));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel centerTitle = new JLabel("📋 메인 콘텐츠");
        centerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        centerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel centerSub = new JLabel("내용이 들어오는 영역");
        centerSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        centerSub.setForeground(Color.GRAY);
        centerSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(centerTitle);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(centerSub);
        centerPanel.add(Box.createVerticalGlue());

        // 오른쪽 패널
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JLabel rightTitle = new JLabel("⚙ 설정");
        rightTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        rightTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel rightSub = new JLabel("우측 패널 영역");
        rightSub.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        rightSub.setForeground(Color.GRAY);
        rightSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(rightTitle);
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(rightSub);
        rightPanel.add(Box.createVerticalGlue());

        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);

        contentPane.add(mainPanel, BorderLayout.CENTER);

        // ───────────────────────────────
        // 하단 상태바 (SOUTH)
        // ───────────────────────────────
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(new Color(45, 45, 45));
        bottomPanel.setPreferredSize(new Dimension(1200, 30));

        JLabel statusLabel = new JLabel("  ✅ 준비 완료");
        statusLabel.setForeground(Color.LIGHT_GRAY);
        statusLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        bottomPanel.add(statusLabel);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}