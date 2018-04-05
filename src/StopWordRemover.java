import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;

public class StopWordRemover {
    //you can add essential private methods or variables
    private String StopWordAddress;
    private FileInputStream fis;
    private BufferedReader reader;
    private ArrayList<ArrayList<String>> StopWord = new ArrayList<ArrayList<String>>();

    public StopWordRemover() throws IOException {
        // load and store the stop words from the fileinputstream with appropriate data structure
        // that you believe is suitable for matching stop words.
        // address of stopword.txt should be Path.StopwordDir
        Path path;
        this.StopWordAddress = Path.stopWord;
        this.fis = new FileInputStream(StopWordAddress);
        this.reader = new BufferedReader(new InputStreamReader(fis));
        String line = reader.readLine();
     /*   while ((line=reader.readLine())!=null) {
            System.out.println(line);
        }*/
     // built the dictionary for stop words
       ArrayList<String> InitialAList = new ArrayList<String>();
        ArrayList<String> InitialBList = new ArrayList<String>();
        ArrayList<String> InitialCList = new ArrayList<String>();
        ArrayList<String> InitialDList = new ArrayList<String>();
        ArrayList<String> InitialEList = new ArrayList<String>();
        ArrayList<String> InitialFList = new ArrayList<String>();
        ArrayList<String> InitialGList = new ArrayList<String>();
        ArrayList<String> InitialHList = new ArrayList<String>();
        ArrayList<String> InitialIList = new ArrayList<String>();
        ArrayList<String> InitialJList = new ArrayList<String>();
        ArrayList<String> InitialKList = new ArrayList<String>();
        ArrayList<String> InitialLList = new ArrayList<String>();
        ArrayList<String> InitialNList = new ArrayList<String>();
        ArrayList<String> InitialMList = new ArrayList<String>();
        ArrayList<String> InitialOList = new ArrayList<String>();
        ArrayList<String> InitialPList = new ArrayList<String>();
        ArrayList<String> InitialQList = new ArrayList<String>();
        ArrayList<String> InitialRList = new ArrayList<String>();
        ArrayList<String> InitialSList = new ArrayList<String>();
        ArrayList<String> InitialTList = new ArrayList<String>();
        ArrayList<String> InitialUList = new ArrayList<String>();
        ArrayList<String> InitialVList = new ArrayList<String>();
        ArrayList<String> InitialWList = new ArrayList<String>();
        ArrayList<String> InitialXList = new ArrayList<String>();
        ArrayList<String> InitialYList = new ArrayList<String>();
        ArrayList<String> InitialZList = new ArrayList<String>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        while (line != null) {
            if (line.charAt(0) == 'a')
                InitialAList.add(line);
            if (line.charAt(0) == 'b')
                InitialBList.add(line);
            if (line.charAt(0) == 'c')
                InitialCList.add(line);
            if (line.charAt(0) == 'd')
                InitialDList.add(line);
            if (line.charAt(0) == 'e')
                InitialEList.add(line);
            if (line.charAt(0) == 'f')
                InitialFList.add(line);
            if (line.charAt(0) == 'g')
                InitialGList.add(line);
            if (line.charAt(0) == 'h')
                InitialHList.add(line);
            if (line.charAt(0) == 'i')
                InitialIList.add(line);
            if (line.charAt(0) == 'j')
                InitialJList.add(line);
            if (line.charAt(0) == 'k')
                InitialKList.add(line);
            if (line.charAt(0) == 'l')
                InitialLList.add(line);
            if (line.charAt(0) == 'n')
                InitialNList.add(line);
            if (line.charAt(0) == 'm')
                InitialMList.add(line);
            if (line.charAt(0) == 'o')
                InitialOList.add(line);
            if (line.charAt(0) == 'p')
                InitialPList.add(line);
            if (line.charAt(0) == 'q')
                InitialQList.add(line);
            if (line.charAt(0) == 'r')
                InitialRList.add(line);
            if (line.charAt(0) == 's')
                InitialSList.add(line);
            if (line.charAt(0) == 't')
                InitialTList.add(line);
            if (line.charAt(0) == 'u')
                InitialUList.add(line);
            if (line.charAt(0) == 'v')
                InitialVList.add(line);
            if (line.charAt(0) == 'w')
                InitialWList.add(line);
            if (line.charAt(0) == 'x')
                InitialXList.add(line);
            if (line.charAt(0) == 'y')
                InitialYList.add(line);
            if (line.charAt(0) == 'z')
                InitialZList.add(line);
            line = reader.readLine();
        }
        result.add(InitialAList);
        result.add(InitialBList);
        result.add(InitialCList);
        result.add(InitialDList);
        result.add(InitialEList);
        result.add(InitialFList);
        result.add(InitialGList);
        result.add(InitialHList);
        result.add(InitialIList);
        result.add(InitialJList);
        result.add(InitialKList);
        result.add(InitialLList);
        result.add(InitialNList);
        result.add(InitialMList);
        result.add(InitialOList);
        result.add(InitialPList);
        result.add(InitialQList);
        result.add(InitialRList);
        result.add(InitialSList);
        result.add(InitialTList);
        result.add(InitialUList);
        result.add(InitialVList);
        result.add(InitialWList);
        result.add(InitialXList);
        result.add(InitialYList);
        result.add(InitialZList);
        this.StopWord = result;
    }

    // YOU MUST IMPLEMENT THIS METHOD
    public boolean isStopword(char[] word) {
        // return true if the input word is a stopword, or false if not
        switch (word[0]) { // Check the initial of the word to find the searching list
            case 'a':
                return StopWord.get(0).contains(String.valueOf(word)) ? true : false;
            case 'b':
                return StopWord.get(1).contains(String.valueOf(word)) ? true : false;
            case 'c':
                return StopWord.get(2).contains(String.valueOf(word)) ? true : false;
            case 'd':
                return StopWord.get(3).contains(String.valueOf(word)) ? true : false;
            case 'e':
                return StopWord.get(4).contains(String.valueOf(word)) ? true : false;
            case 'f':
                return StopWord.get(5).contains(String.valueOf(word)) ? true : false;
            case 'g':
                return StopWord.get(6).contains(String.valueOf(word)) ? true : false;
            case 'h':
                return StopWord.get(7).contains(String.valueOf(word)) ? true : false;
            case 'i':
                return StopWord.get(8).contains(String.valueOf(word)) ? true : false;
            case 'j':
                return StopWord.get(9).contains(String.valueOf(word)) ? true : false;
            case 'k':
                return StopWord.get(10).contains(String.valueOf(word)) ? true : false;
            case 'l':
                return StopWord.get(11).contains(String.valueOf(word)) ? true : false;
            case 'n':
                return StopWord.get(12).contains(String.valueOf(word)) ? true : false;
            case 'm':
                return StopWord.get(13).contains(String.valueOf(word)) ? true : false;
            case 'o':
                return StopWord.get(14).contains(String.valueOf(word)) ? true : false;
            case 'p':
                return StopWord.get(15).contains(String.valueOf(word)) ? true : false;
            case 'q':
                return StopWord.get(16).contains(String.valueOf(word)) ? true : false;
            case 'r':
                return StopWord.get(17).contains(String.valueOf(word)) ? true : false;
            case 's':
                return StopWord.get(18).contains(String.valueOf(word)) ? true : false;
            case 't':
                return StopWord.get(19).contains(String.valueOf(word)) ? true : false;
            case 'u':
                return StopWord.get(20).contains(String.valueOf(word)) ? true : false;
            case 'v':
                return StopWord.get(21).contains(String.valueOf(word)) ? true : false;
            case 'w':
                return StopWord.get(22).contains(String.valueOf(word)) ? true : false;
            case 'x':
                return StopWord.get(23).contains(String.valueOf(word)) ? true : false;
            case 'y':
                return StopWord.get(24).contains(String.valueOf(word)) ? true : false;
            default:
                return StopWord.get(25).contains(String.valueOf(word)) ? true : false;
        }
    }

}
