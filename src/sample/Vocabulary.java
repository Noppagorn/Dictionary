package sample;

public class Vocabulary {
    private String partOfSpeech;
    private String meaning;
    private String example;

    public Vocabulary(String partOfSpeech, String meaning, String example) {
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
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
        temp += "PartOfSpeech : " + partOfSpeech + '\n';
        temp += "meaning : " + meaning + '\n';
        temp += "example : " + example + '\n';
        return temp;
    }
}
