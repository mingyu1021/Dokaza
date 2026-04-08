

package MyApp.controller;

import MyApp.model.AppModel;
import MyApp.model.Word;
import MyApp.view.MainFrame;
import MyApp.view.dialog.AddWordDialog;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainController {
    private MainFrame view;
    private AppModel model;

    public MainController(MainFrame view, AppModel model) {
        this.view = view;
        this.model = model;
        initController();
    }

    private void initController() {
        // ★ 수정: 글자가 바뀔 때마다 두 패널을 동시에 업데이트하는 메서드 호출
        view.getMainPanel().getLeftPanel().getTextArea().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateBothPanelsRealTime(); }

            @Override
            public void removeUpdate(DocumentEvent e) { updateBothPanelsRealTime(); }

            @Override
            public void changedUpdate(DocumentEvent e) { updateBothPanelsRealTime(); }
        });
        
        view.getMainPanel().getRightPanel().getAddWordButton().addActionListener(e -> {
            AddWordDialog dialog = new AddWordDialog(view);
            dialog.getCancelButton().addActionListener(ev -> dialog.dispose());

            dialog.getSaveButton().addActionListener(ev -> {
                String eng = dialog.getEngText();
                String kor = dialog.getKorText();
                
                if (eng.trim().isEmpty() || kor.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "영어와 한글 뜻을 모두 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                    return; 
                }
                
                addNewWord(eng, kor);
                dialog.dispose(); 
            });

            dialog.setSize(400, 300); // 1. 강제로 넉넉한 크기를 지정해 줍니다.
            dialog.setLocationRelativeTo(view); // 2. 창이 무조건 메인 화면 정중앙에 뜨게 만듭니다.
            dialog.setAlwaysOnTop(true); // 3. 실수로 뒤로 숨지 않게 최상단 위로 끌어올립니다.
            
            dialog.setVisible(true);
        });
    }

    // ★ 추가: Middle과 Right 패널을 한 번에 갱신하는 묶음 메서드
    private void updateBothPanelsRealTime() {
        updateMiddlePanelRealTime();
        updateRightPanelRealTime();
    }

    // (기존 코드와 동일) 쉼표로 이어진 텍스트를 출력하는 메서드
    private void updateMiddlePanelRealTime() {
        String inputText = view.getMainPanel().getLeftPanel().getText();
        
        if (inputText == null || inputText.trim().isEmpty()) {
            view.getMainPanel().getMiddlePanel().setText("");
            return;
        }

        String[] words = inputText.split(",");
        StringBuilder koreanResult = new StringBuilder(); 

        for (int i = 0; i < words.length; i++) {
            String eng = words[i].trim();
            if (!eng.isEmpty()) {
                String kor = findKoreanMeaning(eng);
                if (kor.isEmpty()) kor = "?"; 
                koreanResult.append(kor);
            }
            if (i < words.length - 1 || inputText.endsWith(",")) {
                koreanResult.append(", ");
            }
        }
        view.getMainPanel().getMiddlePanel().setText(koreanResult.toString());
    }

    // ★ 핵심 로직: 입력된 텍스트를 기반으로 RightPanel에 객체(블록)를 생성하는 메서드
//    private void updateRightPanelRealTime() {
//        // RightPanel의 컨테이너 가져오기 및 초기화
//        javax.swing.JPanel wordListPanel = view.getMainPanel().getRightPanel().getWordListPanel();
//        wordListPanel.removeAll(); 
//
//        // 왼쪽 창 텍스트 가져오기
//        String inputText = view.getMainPanel().getLeftPanel().getText();
//        
//        if (inputText != null && !inputText.trim().isEmpty()) {
//            // 쉼표 기준으로 쪼개기
//            String[] words = inputText.split(",");
//
//            for (String w : words) {
//                String eng = w.trim();
//                
//                if (!eng.isEmpty()) {
//                    String kor = findKoreanMeaning(eng);
//                    if (kor.isEmpty()) kor = "?"; 
//
//                    // --- UI 객체(블록) 생성 ---
//                    javax.swing.JPanel wordBlock = new javax.swing.JPanel();
//                    wordBlock.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
//                    wordBlock.setBorder(javax.swing.BorderFactory.createCompoundBorder(
//                        javax.swing.BorderFactory.createLineBorder(java.awt.Color.LIGHT_GRAY),
//                        javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
//                    ));
//                    
//                    String displayText = eng + " - " + kor;
//                    javax.swing.JLabel wordLabel = new javax.swing.JLabel(displayText);
//                    wordBlock.add(wordLabel);
//                    
//                    // 패널에 블록 추가
//                    wordListPanel.add(wordBlock);
//                }
//            }
//        }
//        
//        // 화면 강제 새로고침
//        wordListPanel.revalidate();
//        wordListPanel.repaint();
//    }
    
    private void updateRightPanelRealTime() {
        // RightPanel의 컨테이너 가져오기 및 초기화
        javax.swing.JPanel wordListPanel = view.getMainPanel().getRightPanel().getWordListPanel();
        wordListPanel.removeAll(); 

        // 왼쪽 창 텍스트 가져오기
        String inputText = view.getMainPanel().getLeftPanel().getText();
        
        if (inputText != null && !inputText.trim().isEmpty()) {
            // 쉼표 기준으로 쪼개기
            String[] words = inputText.split(",");

            for (String w : words) {
                String eng = w.trim();
                
                if (!eng.isEmpty()) {
                    String kor = findKoreanMeaning(eng);
                    if (kor.isEmpty()) kor = "?"; 

                    // --- UI 객체(블록) 생성 ---
                    javax.swing.JPanel wordBlock = new javax.swing.JPanel();
                    
                    // 글자가 위아래 중앙에 오도록 FlowLayout 여백 조정
                    wordBlock.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8)); 
                    
                    // ★ 1. 크기 고정: 가로는 꽉 채우고(300), 세로 높이는 40으로 고정합니다.
                    Dimension blockDim = new Dimension(300, 40);
                    wordBlock.setPreferredSize(blockDim);
                    wordBlock.setMaximumSize(blockDim); // BoxLayout이 못 늘리게 막는 핵심!
                    wordBlock.setAlignmentX(Component.CENTER_ALIGNMENT);
                    
                    wordBlock.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(java.awt.Color.LIGHT_GRAY),
                        javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)
                    ));
                    
                    String displayText = eng + " - " + kor;
                    javax.swing.JLabel wordLabel = new javax.swing.JLabel(displayText);
                    wordBlock.add(wordLabel);
                    
                    // 패널에 블록 추가
                    wordListPanel.add(wordBlock);
                }
            }
        }
        
        // ★ 2. 빈 공간 밀어내기: 블록이 다 추가된 후, 남는 아래 공간을 꽉 채우는 투명 스프링을 넣습니다.
        // 이 녀석이 들어가면 위의 블록들이 더 이상 늘어나지 않고 맨 위로 착 달라붙습니다.
        wordListPanel.add(Box.createVerticalGlue());
        
        // 화면 강제 새로고침
        wordListPanel.revalidate();
        wordListPanel.repaint();
    }
    
    // (기존 코드와 동일) 단어 검색
    private String findKoreanMeaning(String englishWord) {
        for (Word word : model.getWordList().getWords()) {
            if (word.getEnglish().equalsIgnoreCase(englishWord)) {
                return word.getKorean(); 
            }
        }
        return ""; 
    }
    
    // 단어 추가 후 화면 갱신
    private void addNewWord(String english, String korean) {
        String eng = english.trim();
        String kor = korean.trim();

        if (eng.isEmpty() || kor.isEmpty()) {
            System.out.println("❌ 오류: 영어와 한글 뜻을 모두 입력해야 합니다.");
            return; 
        }

        model.getWordList().addWord(new Word(eng, kor));
        model.getWordList().print();

        // ★ 단어가 추가되면 입력 중이던 "?" 표시가 즉시 실제 뜻으로 바뀌도록 두 화면 모두 갱신
        updateBothPanelsRealTime();
    }
}