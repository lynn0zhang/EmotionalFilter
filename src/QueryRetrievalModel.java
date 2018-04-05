

import java.io.IOException;
import java.util.*;

public class QueryRetrievalModel {

    protected MyIndexReader indexReader;
    private int totalWord;

    public QueryRetrievalModel(MyIndexReader ixreader) throws IOException {
        indexReader = ixreader;
        this.totalWord = indexReader.totalWord();
    }

    /**
     * Search for the topic information.
     * The returned results (retrieved documents) should be ranked by the score (from the most relevant to the least).
     * TopN specifies the maximum number of results to be returned.
     *
     * @param query The query to be searched for.
     * @param TopN  The maximum number of returned document
     * @return
     */

    public List<Document> retrieveQuery(String query, int TopN) throws IOException {
        // NT: you will find our IndexingLucene.Myindexreader provides method: docLength()
        // implement your retrieval model here, and for each input query, return the topN retrieved documents
        // sort the docs based on their relevance score, from high to low\
        ArrayList<Document> result = new ArrayList<>();
        // Processing aQuery
        ArrayList<Integer> docIds = new ArrayList<Integer>();
        ArrayList<HashMap<Integer, Integer>> docList = new ArrayList<HashMap<Integer, Integer>>();
        String[] wordCollection = query.split(" ");
        for (String word : wordCollection) {
            int[][] docId_termFreq = indexReader.getPostingList(word);
            HashMap<Integer, Integer> wordMap = new HashMap<Integer, Integer>();
            for (int[] i : docId_termFreq) {
                int docId = i[0], termFreq = i[1];
                // Extract documents containing words from aQuery
                if (!docIds.contains(docId))
                    docIds.add(docId);
                wordMap.put(docId, termFreq);
            }
            docList.add(wordMap);
        }
        // Rearrange hashmap showing freq of each word in one doc
        ArrayList<HashMap<String, Integer>> wordList = new ArrayList<HashMap<String, Integer>>();
        ArrayList<int[]> docLength = new ArrayList<int[]>();
        for (int i = 0; i < docIds.size(); i++) {
            HashMap<String, Integer> wordMap = new HashMap<>();
            int[] docId_docLength = new int[2];
            for (int j = 0; j < docList.size(); j++) {
                if (docList.get(j).containsKey(docIds.get(i))) {
                    wordMap.put(wordCollection[j], docList.get(j).get(docIds.get(i)));
                } else {
                    wordMap.put(wordCollection[j], 0);
                }
            }
            wordList.add(wordMap);
            docId_docLength[0] = docIds.get(i);
            docId_docLength[1] = indexReader.docLength(docId_docLength[0]);
            docLength.add(docId_docLength);
        }
        // Count P(w|REF)
        HashMap<String, Integer> Reference = new HashMap<String, Integer>();
        for (int i = 0; i < docList.size(); i++) {
            int totalAppear = 0;
            for (Integer j : docList.get(i).values()) {
                totalAppear += j;
            }
            Reference.put(wordCollection[i], totalAppear);
        }
        // Step into statisticModel
        TreeMap<Integer, Double> statisticModel = new TreeMap<Integer, Double>();
        statisticModel = statisticModel(wordList, docLength, Reference, wordCollection);
        ArrayList<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(statisticModel.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        int i = 0;
        String lastDocno = indexReader.getDocno(list.get(0).getKey());
        for (Map.Entry<Integer, Double> item : list) {
            if (!lastDocno.equals(indexReader.getDocno(item.getKey()))) {
                Document document = new Document(indexReader.getDocno(item.getKey()), item.getValue());
                result.add(document);
                i++;
                if (i == TopN)
                    break;
            }
            lastDocno = indexReader.getDocno(item.getKey());
        }
        return result;
    }

    public TreeMap<Integer, Double> statisticModel(ArrayList<HashMap<String, Integer>> wordList, ArrayList<int[]> docLength, HashMap<String, Integer> Reference, String[] wordCollection) {
        // I assume that the μ is equal to 2000
        int m = 2000;
        TreeMap<Integer, Double> result = new TreeMap<>();
        for (int i = 0; i < docLength.size(); i++) {
            double Score = 1;
            for (String word : wordCollection) {
                Score *= ((double) wordList.get(i).get(word) + ((double) m * (double) Reference.get(word) / (double) totalWord)) / (double) (docLength.get(i)[1] + m);
            }
            result.put(docLength.get(i)[0], Score);
        }
        return result;
    }
}