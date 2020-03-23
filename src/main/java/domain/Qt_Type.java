package domain;

public class Qt_Type {
    private String id;
    private String qt_name;

    public Qt_Type(String id, String qt_name) {
        this.id = id;
        this.qt_name = qt_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQt_name() {
        return qt_name;
    }

    public void setQt_name(String qt_name) {
        this.qt_name = qt_name;
    }

    public Qt_Type() {
    }
}
