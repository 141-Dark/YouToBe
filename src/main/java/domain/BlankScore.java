package domain;

public class BlankScore {
    private String customer_id;
    private String cname;
    private int bs;

    public BlankScore() {
    }

    public BlankScore(String customer_id, String cname, int bs) {
        this.customer_id = customer_id;
        this.cname = cname;
        this.bs = bs;
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

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "BlankScore{" +
                "customer_id='" + customer_id + '\'' +
                ", cname='" + cname + '\'' +
                ", bs=" + bs +
                '}';
    }
}
