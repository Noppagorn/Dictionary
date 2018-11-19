package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sample.JSON.JsonFormat;
import sample.XML.XmlFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.IOException;
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
        //System.out.println(temp);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(temp);
        System.out.println(json);

        XmlFormat xmlFormat = new XmlFormat();
        xmlFormat.writeXML(temp);
    }
}
