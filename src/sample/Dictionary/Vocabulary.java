package sample.Dictionary;

public class Vocabulary {
    private String word;
    private String partOfSpeech;
    private String meaning;
    private String example;

    public Vocabulary(String word,String partOfSpeech, String meaning, String example) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
    }


    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getWord() {
        return word;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }

    @Override
    public String toString() {
            String temp = "";
            temp += "Word : " + word + '\n';
            temp += "PartOfSpeech : " + partOfSpeech + '\n';
            temp += "meaning : " + meaning + '\n';
            temp += "example : " + example + '\n';
            return temp;
    }
}
