package domain;

public class AddSelectsAnswer {
    private String customer_id;//学生id
    private String cname;//课程名
    private  String number;//问题序号
    private String title;//题目内容
    private String yanswer;//你的答案

    public AddSelectsAnswer(String customer_id, String cname, String number, String title, String yanswer) {
        this.customer_id = customer_id;
        this.cname = cname;
        this.number = number;
        this.title = title;
        this.yanswer = yanswer;
    }

    public AddSelectsAnswer() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYanswer() {
        return yanswer;
    }

    public void setYanswer(String yanswer) {
        this.yanswer = yanswer;
    }

    @Override
    public String toString() {
        return "AddSelectsAnswer{" +
                "customer_id='" + customer_id + '\'' +
                ", cname='" + cname + '\'' +
                ", number='" + number + '\'' +
                ", title='" + title + '\'' +
                ", yanswer='" + yanswer + '\'' +
                '}';
    }
}
