package sample.Dictionary;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Dictionary {
    private ArrayList<Vocabulary> words = new ArrayList<>();

    public void addWord(Vocabulary vocab){
        words.add(vocab);
    }
    public Vocabulary getWord(String word){

        for (Vocabulary x: words
             ) {
            if(word.equals(x.getWord())) return  x;
        }
        throw new NoSuchElementException("Cannot find " + word);
    }
    public ArrayList<Vocabulary> getWords(){
        return  words;
    }

}
