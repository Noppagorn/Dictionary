package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sample.Dictionary.Dictionary;
import sample.Dictionary.Vocabulary;

import java.io.IOException;
import java.util.ArrayList;

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
        new FormatTOXml().writeXML(temp);
        //System.out.println(temp);
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(temp);
//        System.out.println(json);
//
//        FormatTOXml xmlFormat = new FormatTOXml();
//        xmlFormat.writeXML(temp);
//
//        try {
//            String s = xmlFormat.readXML();
//            System.out.println(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
