package domain;

public class Customer {

    private String cid;
    private String cname;

    private String cellphone;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    private String description;

    public Customer(String cid ,String cname,String gender,String birthday,String cellphone,String email,String description) {
        this.cellphone = cellphone;
        this.cname=cname;
        this.description = description;
        this.cid = cid;

    }

    public Customer() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
