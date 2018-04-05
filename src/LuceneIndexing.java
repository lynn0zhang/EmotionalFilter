import java.io.File;
import java.util.Map;

/**
 * Created by kaiyanglyu on 11/30/16.
 */


public class LuceneIndexing {
    public static void main(String args[]) throws Exception {
        LuceneIndexing indexing = new LuceneIndexing();

        long startTime = System.currentTimeMillis();
        indexing.WriteIndex();
        long endTime = System.currentTimeMillis();
        System.out.println("index web corpus running time: " + (endTime - startTime) / 60000.0 + " min");
        startTime = System.currentTimeMillis();
        indexing.ReadIndex("labor");
        endTime = System.currentTimeMillis();
        System.out.println("load index & retrieve running time: " + (endTime - startTime) / 60000.0 + " min");

    }


    public void WriteIndex() throws Exception {

        // initiate the output object
        MyIndexWriter output = new MyIndexWriter();

        // initiate a doc object, which can hold document number and document content of a document
        Map<String, String> doc = null;

        int count = 0;
        // build index of corpus document by document
        File files = new File(Path.reviewed);
        for (File file : files.listFiles()) {
            // index this document
            output.index(file.getName(), file);

            count++;
            if (count % 1000 == 0)
                System.out.println("finish " + count + " docs");
        }
        System.out.println("totaly document count:  " + count);
        output.close();
    }


    public void ReadIndex(String token) throws Exception {
        // Initiate the index file reader
        MyIndexReader ixreader = new MyIndexReader();

        // do retrieval
        int df = ixreader.DocFreq(token);
        long ctf = ixreader.CollectionFreq(token);
        System.out.println(" >> the token \"" + token + "\" appeared in " + df + " documents and " + ctf + " times in total");
        if (df > 0) {
            int[][] posting = ixreader.getPostingList(token);
            for (int ix = 0; ix < posting.length; ix++) {
                int docid = posting[ix][0];
                int freq = posting[ix][1];
                String docno = ixreader.getDocno(docid);
                System.out.printf("    %20s    %6d    %6d\n", docno, docid, freq);
            }
        }
        ixreader.close();
    }


}
