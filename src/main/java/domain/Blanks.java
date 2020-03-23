package domain;

public class Blanks {
    private String blanks_id;
    private String title;//题目
    private String answer;
    private String parsing;//解析
    private String score;
    private String subject;//科目

    public Blanks() {
    }

    public Blanks(String blanks_id, String title, String answer, String parsing, String score, String subject) {
        this.blanks_id = blanks_id;
        this.title = title;
        this.answer = answer;
        this.parsing = parsing;
        this.score = score;
        this.subject = subject;
    }

    public String getBlanks_id() {
        return blanks_id;
    }

    public void setBlanks_id(String blanks_id) {
        this.blanks_id = blanks_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tile) {
        this.title = tile;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getParsing() {
        return parsing;
    }

    public void setParsing(String parsing) {
        this.parsing = parsing;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
