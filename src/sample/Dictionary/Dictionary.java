package sample.Dictionary;

import sample.MyFormatter;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Dictionary {
    private ArrayList<Vocabulary> words = new ArrayList<>();

    public Dictionary(){
        words.add(new Vocabulary("Run","Verb","Walk fast","I run so fast"));
        words.add(new Vocabulary("Walk","Verb","move to somewhere by leg","I walk in the park"));
        words.add(new Vocabulary("I","Noun","yourself","I run so fast"));
        words.add(new Vocabulary("Cat","Noun","kind of pet","I like a cat."));
        words.add(new Vocabulary("Dog","Noun","Kind of pet","I love a dog."));
    }
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

    public String MyFormat(MyFormatter formatter){
        return formatter.format(words);
    }

    public void updateDictionary(ArrayList<Vocabulary> newWord){
        words = (ArrayList<Vocabulary>) newWord.clone();
    }

}
