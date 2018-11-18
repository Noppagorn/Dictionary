package sample;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String,Vocabulary> words = new HashMap<>();

    public void addWord(String word,Vocabulary vocab){
        words.put(word,vocab);
    }
    public Vocabulary getWord(String word){
        return words.get(word);
    }
    public HashMap getWords(){
        return  words;
    }
}
