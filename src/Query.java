public class Query {
    //you can modify this class

    private String queryContent;
    private String topicId;
    private String descContent;
    private String narrContent;

    public String getDescContent() {
        return descContent;
    }

    public void setDescContent(String descContent) {
        this.descContent = descContent;
    }

    public String getNarrContent() {
        return narrContent;
    }

    public void setNarrContent(String narrContent) {
        this.narrContent = narrContent;
    }

    public String GetQueryContent() {
        return queryContent;
    }

    public String GetTopicId() {
        return topicId;
    }

    public void SetQueryContent(String content) {
        queryContent = content;
    }

    public void SetTopicId(String id) {
        topicId = id;
    }
}
