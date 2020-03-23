package domain;
/*
* domain类的作用：把数据库中的查询结果放到这个对象中
* */
public class User {
    String userName;
    String passWord;
    String ID;
    String email;
    String phone;

    public User(){}
    public User(String ID,String userName,String passWord,String phone,String email) {
        this.ID = ID;
        this.passWord = passWord;
        this.email = email;
        this.phone=phone;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", ID='" + ID + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
