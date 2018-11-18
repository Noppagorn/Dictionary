package sample;

import sample.JSON.JsonFormat;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        Vocabulary w1 = new Vocabulary("verb","read somting","I read a book");
        dictionary.addWord("Read",w1);

        Vocabulary w2 = new Vocabulary("verb","read somting","I read a book");
        dictionary.addWord("wrote",w2);

        JsonFormat jsonFormat = new JsonFormat();
        jsonFormat.writeToJson(dictionary.getWords());

        HashMap<String,Vocabulary> temp = jsonFormat.readFromJson();
        System.out.println(temp.get("Read"));
    }
}
