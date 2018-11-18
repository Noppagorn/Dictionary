package sample.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import sample.Vocabulary;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonFormat {
    public void writeToJson(ArrayList words){
        Gson gson = new Gson();
        String json = gson.toJson(words);
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/sample/DataBase/JsonWord.json")));
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
            BufferedReader reader = new BufferedReader(new FileReader("src/sample/DataBase/JsonWord.json"));
            ArrayList<Vocabulary> retMap = new Gson().fromJson(
                    reader, new TypeToken<ArrayList<Vocabulary>>() {}.getType()
            );
            return retMap;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
