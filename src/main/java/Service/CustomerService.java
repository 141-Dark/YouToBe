package Service;

import DAO.CustomerDAO;
import domain.Customer;
import domain.Notice;
import domain.PageBean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    public void add(Customer c) throws SQLException, ClassNotFoundException, IOException {
        customerDAO.add(c);
    }

    /*
    * 查询所有客户（不分页）
    * */
    /*public List<Customer> findAll() throws SQLException {
        return customerDAO.findAll();
    }*/

    /*
    * 加载客户
    * */
    public Customer load(String cid) throws SQLException {
        return customerDAO.load(cid);
    }

    /*
    * 编辑客户
    * */
    public void edit(Customer c) throws SQLException {
        customerDAO.edit(c);
    }


    /*
     * 删除客户
     * */

    public void delete(String cid) throws SQLException {
       customerDAO.delete(cid);
    }

    /*
    * 多条件组合查询（不分页）
    * */
    /*public List<Customer> query(Customer criteria) throws SQLException {
        return customerDAO.query(criteria);
    }*/

    /*
    * 查询所有，分页管理
    * */
    public PageBean<Customer> findAll(int pc, int ps) throws SQLException {
        return customerDAO.findAll(pc,ps);
    }

    public PageBean<Customer> query(Customer criteria, int pc, int ps) throws SQLException {
        return customerDAO.query(criteria,pc,ps);
    }

    //发布公告
    public void notice(Notice n) throws SQLException {
        customerDAO.notice(n);
    }

    /*
     * 显示所有公告
     * */
    public PageBean<Notice> view_notice(int pc, int ps) throws SQLException {
        return customerDAO.view_notice(pc,ps);
    }

}
