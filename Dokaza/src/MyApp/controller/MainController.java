package MyApp.controller;

import MyApp.model.AppModel;
import MyApp.model.Word;
import MyApp.view.MainFrame;
import MyApp.view.dialog.AddWordDialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class MainController {
    private MainFrame view;
    private AppModel model;

    public MainController(MainFrame view, AppModel model) {
        this.view = view;
        this.model     = model;
     // 컨트롤러가 생성될 때 바로 이벤트 리스너를 달아줍니다.
        initController();
    }

    private void initController() {
    	view.getMainPanel().getLeftPanel().getTextArea().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateMiddlePanelRealTime(); }

            @Override
            public void removeUpdate(DocumentEvent e) { updateMiddlePanelRealTime(); }

            @Override
            public void changedUpdate(DocumentEvent e) { updateMiddlePanelRealTime(); }
            
        });
    	
    	// MainController.java 내부의 initController() 중 일부
    	view.getMainPanel().getRightPanel().getAddWordButton().addActionListener(e -> {
    	    // 1. 새 다이얼로그 객체 생성 (view가 부모 창)
    	    AddWordDialog dialog = new AddWordDialog(view);

    	    // 2. 다이얼로그 내부의 [취소] 버튼 이벤트
    	    dialog.getCancelButton().addActionListener(ev -> dialog.dispose());

    	    // 3. 다이얼로그 내부의 [추가] 버튼 이벤트
    	    dialog.getSaveButton().addActionListener(ev -> {
    	        String eng = dialog.getEngText();
    	        String kor = dialog.getKorText();
    	        
    	     // ★ 개선: 빈칸이면 경고창을 띄우고 창을 닫지 않음
                if (eng.trim().isEmpty() || kor.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "영어와 한글 뜻을 모두 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                    return; // 아래의 dispose()가 실행되지 않고 멈춤
                }
    	        
    	        // model에 단어 추가하는 로직 실행
    	        addNewWord(eng, kor);
    	        
    	        updateMiddlePanelRealTime(); // 메인 화면 갱신
    	        dialog.dispose(); // 작업 완료 후 창 닫기
    	    });

    	    // 4. 화면에 띄우기 (이 코드가 실행되면 창이 닫힐 때까지 이 줄에서 대기합니다)
    	    dialog.setVisible(true);
    	});
    }
    // 쉼표가 찍힐 때마다 실행되는 로직
    private void updateMiddlePanelRealTime() {
    	// 1. 왼쪽 창 텍스트 가져오기
        String inputText = view.getMainPanel().getLeftPanel().getText();
        
        // 다 지웠을 때는 가운데 창도 같이 비워주기
        if (inputText == null || inputText.trim().isEmpty()) {
            view.getMainPanel().getMiddlePanel().setText("");
            return;
        }

        // 2. 쉼표 기준으로 쪼개기
        String[] words = inputText.split(",");
        
        // 3. 쉼표로 연결할 새로운 문자열을 만들기 위한 StringBuilder
        StringBuilder koreanResult = new StringBuilder(); 

        for (int i = 0; i < words.length; i++) {
            String eng = words[i].trim();
            
            if (!eng.isEmpty()) {
                // WordList에서 한글 뜻 찾기
                String kor = findKoreanMeaning(eng);
                
                // 단어장에 없는 단어일 경우의 처리 (원하시는 대로 수정 가능)
                if (kor.isEmpty()) {
                    kor ="?"; // 미등록 단어 표시
                }
                
                koreanResult.append(kor);
            }
            
            // 마지막 단어가 아니라면 뒤에 쉼표와 공백(", ") 붙여주기
            // (사용자가 hello 뒤에 쉼표를 찍은 상태면, 배열의 마지막이라도 쉼표를 붙임)
            if (i < words.length - 1 || inputText.endsWith(",")) {
                koreanResult.append(", ");
            }
        }

        // 4. 완성된 "안녕, 에이비씨, 디이에프" 문자열을 MiddlePanel에 한 번에 출력!
        view.getMainPanel().getMiddlePanel().setText(koreanResult.toString());
    }
    
    private String findKoreanMeaning(String englishWord) {
    	// model의 WordList에 들어있는 모든 단어를 하나씩 꺼내서 검사
        for (Word word : model.getWordList().getWords()) {
            // 대소문자 무시하고 영어 단어가 일치하면
            if (word.getEnglish().equalsIgnoreCase(englishWord)) {
                return word.getKorean(); // 그 단어의 한글 뜻을 반환!
            }
        }
        return ""; // 다 뒤졌는데 없으면 빈칸 반환
    }
    
    private void addText() {
    	String text = view.getMainPanel().getLeftPanel().getText();
    	
    }
    
 // 단어를 추가하고 화면과 콘솔을 갱신하는 전용 메서드
    private void addNewWord(String english, String korean) {
        // 1. 좌우 공백 제거
        String eng = english.trim();
        String kor = korean.trim();

        // 2. 입력값이 비어있는지 확인 (간단한 유효성 검사)
        if (eng.isEmpty() || kor.isEmpty()) {
            System.out.println("❌ 오류: 영어와 한글 뜻을 모두 입력해야 합니다.");
            return; 
        }

        // 3. 새로운 Word 객체 생성
        Word newWord = new Word(eng, kor);

        // 4. Model(WordList)에 단어 추가
        model.getWordList().addWord(newWord);

        // 5. 추가될 때마다 콘솔에 전체 리스트 출력 (요청하신 기능!)
        model.getWordList().print();

        // 6. 단어가 추가되었으니 MiddlePanel(번역된 결과 창)도 즉각 갱신
        updateMiddlePanelRealTime();
    }
}