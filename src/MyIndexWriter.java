
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.*;
import java.nio.file.Paths;


public class MyIndexWriter {

    protected File dir;
    private Directory directory;
    private IndexWriter ixwriter;
    private FieldType type;


    public MyIndexWriter() throws IOException {
        // Start from here
        directory = FSDirectory.open(Paths.get(Path.result));
        IndexWriterConfig indexConfig = new IndexWriterConfig(new StandardAnalyzer());
        indexConfig.setMaxBufferedDocs(1000);
        ixwriter = new IndexWriter(directory, indexConfig);
        type = new FieldType();
        type.setIndexOptions(IndexOptions.DOCS_AND_FREQS);
        type.setStored(false);
        type.setStoreTermVectors(true);
    }

    /**
     * This method build index for each document.
     * NOTE THAT: in your implementation of the index, you should transform your string docnos into non-negative integer docids !!!
     * In MyIndexReader, you should be able to request the integer docid for docnos.
     *
     * @param docno
     * @param file
     * @throws IOException
     */
    public void index(String docno, File file) throws IOException {
        // you should implement this method to build index for each document
        StringBuilder builder = new StringBuilder();
        String content;
        FileInputStream input;
        InputStreamReader is;
        BufferedReader br;
        input = new FileInputStream(file);
        is = new InputStreamReader(input);
        br = new BufferedReader(is);
        String line = br.readLine();
        while (line != null) {
            builder.append(line + "\n");
            line = br.readLine();
        }
        content = builder.toString();
        input.close();
        is.close();
        br.close();
        Document doc = new Document();
        doc.add(new StoredField("DOCNO", docno));
        doc.add(new Field("CONTENT", content, type));
        ixwriter.addDocument(doc);
    }

    /**
     * Close the index writer, and you should output all the buffered content (if any).
     *
     * @throws IOException
     */
    public void close() throws IOException {
        // you should implement this method if necessary
        ixwriter.close();
        directory.close();
    }

}
