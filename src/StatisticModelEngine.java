

import java.io.IOException;
import java.util.List;

/**
 * !!! YOU CANNOT CHANGE ANYTHING IN THIS CLASS !!!
 * <p>
 * Main class for running your HW3.
 */
public class StatisticModelEngine {

    public static void main(String[] args) throws Exception {
        // Open index
        MyIndexReader ixreader = new MyIndexReader();
        // Initialize the MyRetrievalModel
        QueryRetrievalModel model = new QueryRetrievalModel(ixreader);
        String query = "Test is so important to our project.";
        long startTime = System.currentTimeMillis();
        System.out.println("The query input is: " + query);
        // conduct retrieval on the index for each topic, and return top 20
        // documents
        query = PreprocessQuery(query);
        System.out.println("After preprocessing, the query becomes: "+query);
        List<Document> results = model.retrieveQuery(query, 20);
        if (results != null) {
            int rank = 1;
            for (Document result : results) {
                System.out.println(" Q0 " + result.docno() + " " + rank + " " + result.score()
                        + " MYRUN");
                rank++;
            }
        }

        long endTime = System.currentTimeMillis(); // end time of running code
        System.out.println("\n\nThis query search time: " + (endTime - startTime) / 60000.0 + " min");
        ixreader.close();
    }

    public static String PreprocessQuery(String query) throws IOException {
        StringBuilder newQuery = new StringBuilder();
        StopWordRemover stopwordRemover = new StopWordRemover();
        WordNormalizer normalizer = new WordNormalizer();
        char[] content = query.toCharArray();
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
                newQuery.append(normalizer.stem(word) + " ");
            //stemmed format of each word is written into result file
        }
        return newQuery.toString();
    }

}
