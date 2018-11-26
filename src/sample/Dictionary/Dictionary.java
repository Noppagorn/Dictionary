package sample.Dictionary;

import sample.Main;
import sample.MyFormatter;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Vocabulary> words = new ArrayList<>();

    public void writeTofile(ArrayList<Vocabulary> words ){
        this.words = words;

        String cwd = System.getProperty("user.dir");
        String fileSep = System.getProperty("file.separator");

        String path = cwd + fileSep;
        File newDir = null;
        newDir = new File("newDie");
        newDir.mkdir();
        try (PrintWriter printWriter = new PrintWriter(new File(getPathJarFile()+fileSep+"data.txt"));) {
            StringBuilder sb = new StringBuilder();
            for (Vocabulary x: words) {
                sb.append(x.getWord()).append(",");
                sb.append(x.getPartOfSpeech()).append(",");
                sb.append(x.getMeaning()).append(",");
                sb.append(x.getExample());
                printWriter.println(sb.toString());
                sb.delete(0,sb.length());
            }
            printWriter.write(sb.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Vocabulary> readToArrayList(){
        ArrayList<Vocabulary> temp = new ArrayList<>();
        String fileSep = System.getProperty("file.separator");
        try {
            BufferedReader br = new BufferedReader(new FileReader(getPathJarFile()+fileSep+"data.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                String splt[] = line.split(",");
                Vocabulary tv = new Vocabulary(splt[0],splt[1],splt[2],splt[3]);
                temp.add(tv);
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  temp;
    }

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

    public ArrayList<Vocabulary> getWords(){
        return  words;
    }

    public String MyFormat(MyFormatter formatter){
        return formatter.format(words);
    }

    private static String getPathJarFile() throws UnsupportedEncodingException {
        URL url = Dictionary.class.getProtectionDomain().getCodeSource().getLocation();
        String jarpath = URLDecoder.decode(url.getFile(),"UTF-8");
        String parentPath = new File(jarpath).getParentFile().getPath();
        return parentPath;
    }


}
