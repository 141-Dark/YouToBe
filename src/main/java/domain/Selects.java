package domain;

public class Selects {
    private String select_id;
    private String s_title;
    private String a;
    private String b;
    private String c;
    private String d;
    private String s_answer;
    private String s_score;
    private String subject;

    public Selects(String select_id, String s_title, String a, String b, String c, String d, String s_answer, String s_score, String subject) {
        this.select_id = select_id;
        this.s_title = s_title;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.s_answer = s_answer;
        this.s_score = s_score;
        this.subject = subject;
    }

    public Selects() {
    }

    public String getSelect_id() {
        return select_id;
    }

    public void setSelect_id(String select_id) {
        this.select_id = select_id;
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getS_answer() {
        return s_answer;
    }

    public void setS_answer(String s_answer) {
        this.s_answer = s_answer;
    }

    public String getS_score() {
        return s_score;
    }

    public void setS_score(String s_score) {
        this.s_score = s_score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Selects{" +
                "select_id='" + select_id + '\'' +
                ", s_title='" + s_title + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", s_answer='" + s_answer + '\'' +
                ", s_score='" + s_score + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
