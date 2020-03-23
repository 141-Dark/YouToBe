package domain;

public class Course {
    private String cid;
    private String cname;
    private String qt_type;

    public Course(String cid, String cname, String qt_type) {
        this.cid = cid;
        this.cname = cname;
        this.qt_type = qt_type;
    }

    public String getQt_type() {
        return qt_type;
    }

    public void setQt_type(String qt_type) {
        this.qt_type = qt_type;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }



    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", qt_type='" + qt_type + '\'' +
                '}';
    }
}
