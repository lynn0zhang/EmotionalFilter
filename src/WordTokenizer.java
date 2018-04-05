import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is for INFSCI 2140 in 2015
 * <p>
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
    //you can add essential private methods or variables
    private char[] CharArray;
    private int index;

    // YOU MUST IMPLEMENT THIS METHOD
    public WordTokenizer(char[] texts) {
        // this constructor will tokenize the input texts (usually it is a char array for a whole document)
        this.CharArray = texts;
        this.index = 0;
    }

    // YOU MUST IMPLEMENT THIS METHOD
    public char[] nextWord() {
        // read and return the next word of the document
        // or return null if it is the end of the document
        ArrayList arrayList = new ArrayList();
        while (index < CharArray.length) { // Extract character only using ascii table
            if (((int) CharArray[index] > 64 && (int) CharArray[index] < 91) || ((int) CharArray[index] > 96 && (int) CharArray[index] < 123)) {
                arrayList.add(CharArray[index]);
                index++;
                if (((int) CharArray[index] > 64 && (int) CharArray[index] < 91) || ((int) CharArray[index] > 96 && (int) CharArray[index] < 123)) {
                    continue;
                } else {
                    break;
                }
            } else {
                index++;
                continue;
            }
        }
        if (!arrayList.isEmpty()) { // Transform arraylist into char []
            char[] result = new char[arrayList.size()];
            Iterator iterator = arrayList.iterator();
            int counting = 0;
            while (iterator.hasNext()) {
                result[counting] = (char) iterator.next();
                counting++;
            }
            return result;
        } else {
            return null;
        }
    }

}
