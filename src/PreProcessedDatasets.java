import java.io.*;

/**
 * Created by kaiyanglyu on 12/2/16.
 */
public class PreProcessedDatasets {
    public static void main(String arge[]) throws IOException {
        PreProcessedDatasets pre = new PreProcessedDatasets();
        pre.ReadFiles();
    }

    public void ReadFiles() throws IOException {
        File fileFolder = new File(Path.Merge);
        FileInputStream input;
        InputStreamReader is;
        BufferedReader br;
        // initiate the BufferedWriter to output result
        FileWriter wr;
        // loading stopword list and initiate the StopWordRemover and WordNormalizer class
        StopWordRemover stopwordRemover = new StopWordRemover();
        WordNormalizer normalizer = new WordNormalizer();
        for (File file : fileFolder.listFiles()) {
            input = new FileInputStream(file);
            is = new InputStreamReader(input);
            br = new BufferedReader(is);
            wr = new FileWriter(Path.reviewed + "//" + file.getName());
            String line = br.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line + "\n");
                line = br.readLine();
            }
            char[] content = builder.toString().toCharArray();
            // Preprocessing

            // initiate the WordTokenizer class
            WordTokenizer tokenizer = new WordTokenizer(content);

            // initiate a word object, which can hold a word
            char[] word = null;

            // process the document word by word iteratively
            while ((word = tokenizer.nextWord()) != null) {
                // each word is transformed into lowercase
                word = normalizer.lowercase(word);

                // filter out stopword, and only non-stopword will be written
                // into result file
                if (!stopwordRemover.isStopword(word))
                    wr.append(normalizer.stem(word) + " ");
                //stemmed format of each word is written into result file
            }
            input.close();
            is.close();
            br.close();
            wr.close();
        }
    }

}
