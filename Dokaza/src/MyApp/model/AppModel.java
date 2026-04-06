package MyApp.model;

import java.util.List;

public class AppModel {
    private String sidebarText;
    private String statusMessage;
    // List<Word> 대신 WordList 객체를 사용
    private WordList wordList;

    public AppModel() {
        wordList = new WordList();
    }

    public WordList getWordList() {
        return wordList;
    }

    // 단어 데이터 업데이트
    public void updateWords(List<Word> newWords) {
        this.wordList.setWords(newWords);
    }

    // sidebarText
    public String getSidebarText() { return sidebarText; }
    public void setSidebarText(String text) { this.sidebarText = text; }

    // statusMessage
    public String getStatusMessage() { return statusMessage; }
    public void setStatusMessage(String message) { this.statusMessage = message; }
    
}