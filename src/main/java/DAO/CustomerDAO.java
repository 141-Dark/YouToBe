package DAO;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Customer;
import domain.Notice;
import domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private QueryRunner qr = new TxQueryRunner();

    /*添加客户*/
    public void  add(Customer c) throws SQLException, ClassNotFoundException, IOException {
        String sql = "insert into customers values(?,?,?,?)";
        Object[] params = {c.getCid(),c.getCname(),c.getCellphone(),c.getDescription()};
        qr.update(sql,params);

    }
    /*
    * 查询所有用户(不分页)
    * */
    /*public List<Customer> findAll() throws SQLException {
        String sql = "select * from customers";
        //封装（多行记录）
        return qr.query(sql,new BeanListHandler<Customer>(Customer.class));

    }*/

    /*
    * 根据id加载用户
    * */
    public Customer load(String cid) throws SQLException {
        String sql = "select * from customers where cid = ?";
        //封装（根据cid打印单行记录）
        return qr.query(sql,new BeanHandler<Customer>(Customer.class),cid);
    }

    /*
    * 编辑客户
    * */
    public void edit(Customer c) throws SQLException {
        String sql = "update customers set cname = ?,cellphone=?,description=? where cid =?";
        Object[] params = {c.getCname(),c.getCellphone(),c.getDescription(),c.getCid()};
        qr.update(sql,params);
    }

    /*
     * 删除客户
     * */
    public void delete(String cid) throws SQLException {
        String sql = "delete from customers where cid = ?";
        /*Connection con = JdbcUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,cid);
        pstmt.executeUpdate();
        con.close();*/
        Object[] params = {cid};
        qr.update(sql,params);
    }

    /*
    * 多条件组合查询(不分页)
    * 给出sql模板
    * 给出参数
    * 调用query,使用结果集处理器，多行处理器：BeanListHander
    * */
    /*public List<Customer> query(Customer criteria) throws SQLException {
        //给出sql的前半部分，然后追加
        StringBuilder sql = new StringBuilder("select * from customers where 1=1");

        //创建一个AArrayList来装载参数(由于给出的参数有可能为空)
        List<Object> params = new ArrayList<Object>();

        //判断条件，完成追加where子句、
        String cname =  criteria.getCname();
        if(cname!=null && !cname.trim().isEmpty()){
            sql.append(" and cname like ?");
            params.add("%"+cname+"%");

        }

        String cellphone =  criteria.getCellphone();
        if(cellphone !=null && !cellphone.trim().isEmpty()){
            sql.append(" and cellphone like ?");
            params.add("%"+ cellphone +"%");
        }

        //执行query,需要将集合转成数组,还需要讲sql转换成String、
        return qr.query(sql.toString(),new BeanListHandler<Customer>(Customer.class),params);

    }*/

    public PageBean<Customer> findAll(int pc, int ps) throws SQLException {
        /*
        * 设置pageBean对象pb
        * 设置pb的pc和ps
        * 得到tr，设置给pb
        * 得到beanlist（数据库对应页面的数据），返回给pb
        * 返回pb
        * */
        PageBean<Customer> pb = new PageBean<Customer>();
        pb.setPc(pc);//当前页的页码
        pb.setPs(ps);//每页的记录数

        //得到总的记录数tr(单行单列)
        String sql = "select count(*) from customers";
        Number num = (Number) qr.query(sql,new ScalarHandler<>());

        //得到tr
        int tr = num.intValue();//转换成int类型
        pb.setTr(tr);

        //得到beanlist(多行多列)
        sql = "select * from customers order by cname limit ?,?";
        List<Customer> beanList = qr.query(sql,new BeanListHandler<Customer>(Customer.class),(pc-1)*ps,ps);

       pb.setBeanList(beanList);
       return pb;
    }

    public PageBean<Customer> query(Customer criteria, int pc, int ps) throws SQLException {
        /*
        * 创建pageBean对象
        * 设置已有属性ps、pc
        * 得到tr(总记录数)
        * 得到beanlist
        * */
        PageBean<Customer> pb = new PageBean<Customer>();
        pb.setPc(pc);
        pb.setPs(ps);

        //得到总记录数
        StringBuilder cnt_sql = new StringBuilder("select count(*) from customers ");
        StringBuilder where_sql = new StringBuilder(" where 1=1");

        //创建一个AArrayList来装载参数(由于给出的参数有可能为空)
        List<Object> params = new ArrayList<Object>();

        //判断条件，完成追加where子句、
        String cname =  criteria.getCname();
        if(cname!=null && !cname.trim().isEmpty()){
            where_sql.append(" and cname like ?");
            params.add("%"+cname+"%");

        }

        String cellphone =  criteria.getCellphone();
        if(cellphone !=null && !cellphone.trim().isEmpty()){
            where_sql.append(" and cellphone like ?");
            params.add("%"+ cellphone +"%");
        }

        String s = cnt_sql.append(where_sql).toString();
        //执行query,需要将集合转成数组,还需要讲sql转换成String、
         Number num = (Number) qr.query(s,new ScalarHandler(),params.toArray());
        int tr = num.intValue();
        pb.setTr(tr);

        //得到beanlist对象
        StringBuilder sql = new StringBuilder("select * from customers");
        //还要给出limit子句
        StringBuilder limit_sql = new StringBuilder(" limit ?,?");
        //给？赋值
        params.add((pc-1)*ps);
        params.add(ps);

        List<Customer> beanlist = qr.query(sql.append(where_sql).append(limit_sql).toString(),new BeanListHandler<Customer>(Customer.class),params.toArray());
        pb.setBeanList(beanlist);

        return pb;
    }

    //发布公告
    public void notice(Notice n) throws SQLException {
        String sql = "insert into notice values(?,?)";
        Object[] params = {n.getNid(),n.getDescription()};
        qr.update(sql,params);
    }

    //查看公告
    public PageBean<Notice> view_notice(int pc, int ps) throws SQLException {
        /*
         * 设置pageBean对象pb
         * 设置pb的pc和ps
         * 得到tr，设置给pb
         * 得到beanlist（数据库对应页面的数据），返回给pb
         * 返回pb
         * */
        PageBean<Notice> pb = new PageBean<Notice>();
        pb.setPc(pc);//当前页的页码
        pb.setPs(ps);//每页的记录数

        //得到总的记录数tr(单行单列)
        String sql = "select count(*) from notice";
        Number num = (Number) qr.query(sql,new ScalarHandler<>());

        //得到tr
        int tr = num.intValue();//转换成int类型
        pb.setTr(tr);

        //得到beanlist(多行多列)
        sql = "select * from notice limit ?,?";
        List<Notice> beanList = qr.query(sql,new BeanListHandler<Notice>(Notice.class),(pc-1)*ps,ps);

        pb.setBeanList(beanList);
        return pb;
    }

}
