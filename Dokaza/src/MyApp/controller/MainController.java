package MyApp.controller;

import MyApp.model.AppModel;
import MyApp.model.Word;
import MyApp.view.MainFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        // LeftPanel의 [추가] 버튼에 액션 리스너(클릭 감지기) 달기
       view.getMainPanel().getLeftPanel().getTextArea().addKeyListener(new KeyAdapter() {
    	   @Override
           public void keyReleased(KeyEvent e) {
               // 키보드에서 뗀 키가 쉼표(',')일 때만 아래 로직 실행
               if (e.getKeyChar() == ',') {
                   updateMiddlePanelRealTime();
               }
    	   }
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
                    kor = "?"; // 미등록 단어 표시
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
}