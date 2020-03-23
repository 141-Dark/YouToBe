package domain;

import java.util.List;
/*
* 泛型类，用于统计页面信息
* */
public class PageBean<T>{
    private int pc;//当前页page code

    private int tr;//总记录 totalrecord
    private int ps;//每页记录数page size
    private List<T> beanList;//当前页面的记录数
    private String url;//用来实现搜索时的分页


    public int getTp() {
        //计算总页数
        int tp = tr/ps;
        //对是否产生新页做处理(如果没有余数就不产生多余页（返回tp），有余数就产生一个新页面（返回tp+1）)
        return tr%ps == 0?tp : tp+1;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
