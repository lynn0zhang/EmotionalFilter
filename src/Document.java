public class Document {

    protected String docno;
    protected double score;

    public Document(String docno, double score) {

        this.docno = docno;
        this.score = score;
    }

    public String docno() {
        return docno;
    }

    public double score() {
        return score;
    }


    public void setDocno(String docno) {
        this.docno = docno;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
