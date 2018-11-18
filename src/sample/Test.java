package sample;

import sample.JSON.JsonFormat;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        Vocabulary w1 = new Vocabulary("Read","verb","read somting","I read a book");

        Vocabulary w2 = new Vocabulary("Write","verb","read somting","I read a book");
        dictionary.addWord(w1);
        dictionary.addWord(w2);
        JsonFormat jsonFormat = new JsonFormat();
        jsonFormat.writeToJson(dictionary.getWords());

        ArrayList<Vocabulary> temp = jsonFormat.readFromJson();
        System.out.println(temp);
    }
}
