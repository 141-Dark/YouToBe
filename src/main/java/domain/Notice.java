package domain;

public class Notice {
    private String nid;
    private String description;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Notice(String nid, String description) {
        this.nid = nid;
        this.description = description;
    }

    public Notice() {

    }

    @Override
    public String toString() {
        return "Notice{" +
                "nid='" + nid + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
