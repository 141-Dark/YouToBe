package domain;

public class Tes {
    private String tes;

    @Override
    public String toString() {
        return "Tes{" +
                "tes='" + tes + '\'' +
                '}';
    }

    public String getTes() {
        return tes;
    }

    public void setTes(String tes) {
        this.tes = tes;
    }

    public Tes() {
    }

    public Tes(String tes) {
        this.tes = tes;
    }
}
