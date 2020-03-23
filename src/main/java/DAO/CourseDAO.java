package DAO;

import cn.itcast.jdbc.TxQueryRunner;
import domain.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseDAO {
    private QueryRunner qr = new TxQueryRunner();
    public void addcourse(Course c) throws SQLException {
        String sql = "insert into course values(?,?,?)";
        Object[] params = {c.getCid(),c.getCname(),c.getQt_type()};
        qr.update(sql,params);
    }

    public List<Qt_Type> findAll() throws SQLException {
        String sql = "select * from qt_type";
        //封装（多行记录）
        return qr.query(sql,new BeanListHandler<Qt_Type>(Qt_Type.class));
    }

    public void add_blanks(Blanks b) throws SQLException {
        String sql = "insert into blanks values(?,?,?,?,?,?)";
        Object[] params = {b.getBlanks_id(),b.getTitle(),b.getAnswer(),b.getParsing(),b.getScore(),b.getSubject()};
        qr.update(sql,params);
    }

    //选择考试课程
    public PageBean<Course> choosesubject(int pc, int ps) throws SQLException {
        /*
         * 设置pageBean对象pb
         * 设置pb的pc和ps
         * 得到tr，设置给pb
         * 得到beanlist（数据库对应页面的数据），返回给pb
         * 返回pb
         * */
        PageBean<Course> pb = new PageBean<Course>();
        pb.setPc(pc);//当前页的页码
        pb.setPs(ps);//每页的记录数

        //得到总的记录数tr(单行单列)
        String sql = "select count(*) from course";
        Number num = (Number) qr.query(sql,new ScalarHandler<>());

        //得到tr
        int tr = num.intValue();//转换成int类型
        pb.setTr(tr);

        //得到beanlist(多行多列)
        sql = "select * from course limit ?,?";
        List<Course> beanList = qr.query(sql,new BeanListHandler<Course>(Course.class),(pc-1)*ps,ps);

        pb.setBeanList(beanList);
        return pb;
    }

    //选择考试课程
    public PageBean<Blanks> blankstest(String cname, int pc, int ps) throws SQLException {
        /*
         * 设置pageBean对象pb
         * 设置pb的pc和ps
         * 得到tr，设置给pb
         * 得到beanlist（数据库对应页面的数据），返回给pb
         * 返回pb
         * */
        PageBean<Blanks> pb = new PageBean<Blanks>();
        pb.setPc(pc);//当前页的页码
        pb.setPs(ps);//每页的记录数

        //得到总的记录数tr(单行单列)
        String sql = "select count(*) from blanks where subject = ?";
        Number num = (Number) qr.query(sql,new ScalarHandler<>(),cname);

        //得到tr
        int tr = num.intValue();//转换成int类型
        pb.setTr(tr);

        //得到beanlist(多行多列)
        sql = "select * from blanks where subject = ?";
        List<Blanks> beanList = qr.query(sql,new BeanListHandler<Blanks>(Blanks.class),cname);

        pb.setBeanList(beanList);
        return pb;
    }


    //填空题作答，并计算出成绩
    public void add_blanks_answer(List<AddBlanksAnswer> a) throws SQLException {
        int bs = 0;
        String customer_id = null;
        String cname = null;
        for (int i = 0;i<a.size();i++){
            Object[] params = {a.get(i).getCustomer_id(),a.get(i).getCname(),a.get(i).getNumber(),a.get(i).getTitle(),a.get(i).getYanswer()};
            String sql = "insert into blanks_answer values(?,?,?,?,?)";
            qr.update(sql,params);

            //取出标准的答案
            String answer = "select answer from blanks where subject = ? and title = ?";
            Object[] answer_params = {a.get(i).getCname(),a.get(i).getTitle()};
            String an = qr.query(answer,new ScalarHandler<>(),answer_params);

            //取出对应的分数
            String score = "select score from blanks where subject = ? and title = ?";
            Object[] score_params = {a.get(i).getCname(),a.get(i).getTitle()};
            String so =  qr.query(score,new ScalarHandler<>(),score_params);
            //将成绩转换为int类型
            int s = Integer.parseInt(so);

            if(an.equals(a.get(i).getYanswer())){
                bs = bs + s;
            }
            else {
                bs = bs + 0;
            }

            customer_id = (String) a.get(i).getCustomer_id();
            cname = a.get(i).getCname();
        }
        String blanks_score = "insert into blanks_score values(?,?,?)";
        Object[] params = {customer_id,cname,bs};
        qr.update(blanks_score,params);
    }

    //添加选择题答案并计算成绩
    public void add_selects_answer(List<AddSelectsAnswer> ad) throws SQLException {
        int bs = 0;
        String customer_id = null;
        String cname = null;
        for (int i = 0;i<ad.size();i++) {
            Object[] params = {ad.get(i).getCustomer_id(), ad.get(i).getCname(), ad.get(i).getNumber(), ad.get(i).getTitle(),ad.get(i).getYanswer()};
            String sql = "insert into selects_answer values(?,?,?,?,?)";
            qr.update(sql, params);

            //取出标准的答案
            String answer = "select s_answer from selects where subject = ? and s_title = ?";
            Object[] answer_params = {ad.get(i).getCname(),ad.get(i).getTitle()};
            String an = qr.query(answer,new ScalarHandler<>(),answer_params);

            //取出对应的分数
            String score = "select s_score from selects where subject = ? and s_title = ?";
            Object[] score_params = {ad.get(i).getCname(),ad.get(i).getTitle()};
            String so =  qr.query(score,new ScalarHandler<>(),score_params);
            //将成绩转换为int类型
            int s = Integer.parseInt(so);

            if(an.equals(ad.get(i).getYanswer())){
                bs = bs + s;
            }
            else {
                bs = bs + 0;
            }

            customer_id = (String) ad.get(i).getCustomer_id();
            cname = ad.get(i).getCname();
        }
        String blanks_score = "insert into blanks_score values(?,?,?)";
        Object[] params = {customer_id,cname,bs};
        qr.update(blanks_score,params);
    }
    public PageBean<BlankScore> show_score(String customer_id, int pc, int ps) throws SQLException {
        /*
         * 设置pageBean对象pb
         * 设置pb的pc和ps
         * 得到tr，设置给pb
         * 得到beanlist（数据库对应页面的数据），返回给pb
         * 返回pb
         * */
        PageBean<BlankScore> pb = new PageBean<BlankScore>();
        pb.setPc(pc);//当前页的页码
        pb.setPs(ps);//每页的记录数

        //得到总的记录数tr(单行单列)
        String sql = "select count(*) from blanks_score where customer_id = ?";
        Number num = (Number) qr.query(sql,new ScalarHandler<>(),customer_id);

        //得到tr
        int tr = num.intValue();//转换成int类型
        pb.setTr(tr);

        //得到beanlist(多行多列)
        sql = "select * from blanks_score where customer_id = ? limit ?,?";
        List<BlankScore> beanList = qr.query(sql,new BeanListHandler<BlankScore>(BlankScore.class),customer_id,(pc-1)*ps,ps);

        pb.setBeanList(beanList);
        return pb;
    }

    public void addselects(List<Selects> se) throws SQLException {
        for (int i = 0;i<se.size();i++){
            //Object[] params = {a.get(i).getCustomer_id(),a.get(i).getCname(),a.get(i).getNumber(),a.get(i).getTitle(),a.get(i).getYanswer()};
            Object[] params = {se.get(i).getSelect_id(),se.get(i).getS_title(),se.get(i).getA(),se.get(i).getB(),se.get(i).getC(),se.get(i).getD(),se.get(i).getS_answer(),se.get(i).getS_score(),se.get(i).getSubject()};
            String sql = "insert into selects values(?,?,?,?,?,?,?,?,?)";
            qr.update(sql,params);
        }
    }

    public PageBean<Selects> selectstest(String cname, int pc, int ps) throws SQLException {
        PageBean<Selects> pb = new PageBean<Selects>();
        pb.setPc(pc);//当前页的页码
        pb.setPs(ps);//每页的记录数

        //得到总的记录数tr(单行单列)
        String sql = "select count(*) from selects where subject = ?";
        Number num = (Number) qr.query(sql,new ScalarHandler<>(),cname);

        //得到tr
        int tr = num.intValue();//转换成int类型
        pb.setTr(tr);

        //得到beanlist(多行多列)
        sql = "select * from selects where subject = ?";
        List<Selects> beanList = qr.query(sql,new BeanListHandler<Selects>(Selects.class),cname);

        pb.setBeanList(beanList);
        return pb;
    }


}
