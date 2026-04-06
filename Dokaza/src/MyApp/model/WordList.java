package MyApp.model;

import java.util.ArrayList;
import java.util.List;

public class WordList {
    // Word 객체들을 담는 실제 리스트
    private List<Word> words;

    // 생성자: 객체가 생성될 때 빈 리스트로 초기화
    public WordList() {
        this.words = new ArrayList<>();
    }

    // 리스트 전체를 교체할 때 사용 (MainController에서 중복 제거 후 넘겨줄 때)
    public void setWords(List<Word> words) {
        this.words = words;
    }

    // 리스트 전체를 가져올 때 사용
    public List<Word> getWords() {
        return words;
    }

    // 단어 하나를 리스트에 추가할 때 사용
    public void addWord(Word word) {
        this.words.add(word);
    }

    // 모든 단어를 지울 때 사용 (예: "새로 만들기" 기능)
    public void clear() {
        this.words.clear();
    }
    
    // 현재 저장된 단어의 개수를 반환
    public int size() {
        return this.words.size();
    }
    
 // MyApp.model.WordList.java 내부에 추가/수정

    public void print() {
        System.out.println("\n=== 📚 현재 단어장 목록 (총 " + words.size() + "개) ===");
        
        if (words.isEmpty()) {
            System.out.println("저장된 단어가 없습니다.");
        } else {
            for (int i = 0; i < words.size(); i++) {
                Word w = words.get(i);
                System.out.println((i + 1) + ". " + w.getEnglish() + " : " + w.getKorean());
            }
        }
        System.out.println("========================================\n");
    }
}