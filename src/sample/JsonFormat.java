package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Dictionary.Vocabulary;

import java.io.*;
import java.util.ArrayList;

public class JsonFormat {
    public void writeToJson(ArrayList words){
        Gson gson = new Gson();
        String json = gson.toJson(words);
        try {
            File newDir = null;
            newDir = new File("DataBase");
            newDir.mkdir();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("DataBase/JsonWord.json")));
            pw.println(json);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList readFromJson(){
        Gson gson = new Gson();
        ArrayList<Vocabulary> tempHash = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DataBase/JsonWord.json"));
            ArrayList<Vocabulary> retMap = new Gson().fromJson(
                    reader, new TypeToken<ArrayList<Vocabulary>>() {}.getType()
            );
            reader.close();
            return retMap;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public String readJsonString(){
        Gson gson = new Gson();
        ArrayList<Vocabulary> tempHash = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DataBase/JsonWord.json"));
            ArrayList<Vocabulary> retMap = new Gson().fromJson(
                    reader, new TypeToken<ArrayList<Vocabulary>>() {}.getType()
            );
            reader.close();
            String json = gson.toJson(retMap);
            return json;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}