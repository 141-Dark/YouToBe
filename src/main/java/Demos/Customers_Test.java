package Demos;

import DAO.CustomerDAO;
import cn.itcast.commons.CommonUtils;
import domain.Customer;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/*
* 向Customer中插入300行数据，用于数据搜索
* */
public class Customers_Test {
    @Test
    public void Add_Customers() throws SQLException, IOException, ClassNotFoundException {
        CustomerDAO dao = new CustomerDAO();
        for(int i = 0;i<300;i++){
            Customer c = new Customer();
            c.setCid(CommonUtils.uuid());
            c.setCname("刁玉宽_"+i);
            c.setCellphone("151881187"+i);
            c.setDescription("描述："+i);
            dao.add(c);
        }
    }
}
