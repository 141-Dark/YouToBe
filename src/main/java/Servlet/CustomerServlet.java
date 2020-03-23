package Servlet;

import Service.CustomerService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Customer;
import domain.Notice;
import domain.PageBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet" ,urlPatterns = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService = new CustomerService();

    public String addone(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        Customer c = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        c.setCid(CommonUtils.uuid());

        try{
            customerService.add(c);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //保存request
        request.setAttribute("msg","添加客户成功");
        return "f:/webstudy/msg.jsp";
        //return "http://localhost:8080/NewStudy_war_exploded/webstudy/msg.jsp";
    }

    //查询所有用户（无分页）
    /*public String findAll(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        request.setAttribute("cstmList",customerService.findAll());
        return "f:/webstudy/CustomerManage/list.jsp";
    }*/

    //编辑用户
    /*
    * 需要获取用户id
    * 调用service的查询方法。根据cid来查询用户
    * 保存到request
    * 转发到edit.jsp
    *
    * 第一大步需要查找到要修改的内容，将它显示到edit页面
    * 第二大步，根据id修改
    * */

    public String preEdit(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        String cid = request.getParameter("cid");
        //调用service的load方法（按住键查询称为加载）
        Customer cstm = customerService.load(cid);
        //保存到域
        request.setAttribute("cstm",cstm);
        return "f:/webstudy/CustomerManage/edit.jsp";
    }

    /*
    *编辑方法
    **/
    public String Edit(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        /*
        * 封装表单数据到customer对象中
        * 调用service方法
        * 将成功信息保存到request中
        * 转发到msg中显示成功信息
        * */
        Customer c = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        customerService.edit(c);
        request.setAttribute("msg","编辑客户成功");
        return "f:/webstudy/msg.jsp";
    }

    /*
    * 删除客户
    * */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        String cid = request.getParameter("cid");
        customerService.delete(cid);
        request.setAttribute("msg","删除客户成功");
        return "f:/webstudy/msg.jsp";
    }

    /*
    * 查找客户（不考虑分页）
    * */
    /*public String query(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException{
        /*
        * 封装表单数据到customer中
        * 调用service中的方法返回List<Customer>
        * 保存到request域中
        * 转发到request域中
        * criteria（多条件）
        * QBC基于条件的查询
        * */
        /*Customer criteria = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        List<Customer> cstmtList = customerService.query(criteria);*/

      /*  request.setAttribute("cstmList",cstmtList);
        return "f:/webstudy/CustomerManage/list.jsp";
    }*/

    //查询所有用户（利用分页的方法）
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        /*获取页面传递的页码pc
        *给定每页的数据数ps
        *使用pc和ps调用service方法，得到pageBean，保存到request，转发到list.jsp中
        * */
        //如果pc参数不存在，则默认的是第一页，即pc=1，如果参数存在则只要将pc转换成int类型
        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        PageBean<Customer> pb = customerService.findAll(pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));
        request.setAttribute("pb",pb);
        return "f:/webstudy/CustomerManage/list.jsp";
    }

    //搜索用户
    public String query(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        /*获取页面传递的页码pc
         *给定每页的数据数ps
         *使用pc和ps调用service方法，得到pageBean，保存到request，转发到list.jsp中
         * */
        //如果pc参数不存在，则默认的是第一页，即pc=1，如果参数存在则只要将pc转换成int类型
        Customer criteria = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        PageBean<Customer> pb = customerService.query(criteria,pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));
        request.setAttribute("pb",pb);
        return "f:/webstudy/CustomerManage/list.jsp";
    }


    /*
    * 获取参数（页码）
    * */
    public int getPic(HttpServletRequest request){
        String value = request.getParameter("pc");
        if(value == null||value.trim().isEmpty()){
            return 1;
        }
        else {
            return Integer.parseInt(value);
        }
    }

    /*
    * 处理编码
    * */
    private Customer encoding(Customer criteria) throws UnsupportedEncodingException {
        String name = criteria.getCname();
        String cellphone = criteria.getCellphone();
        if(name!=null && !name.trim().isEmpty()){
            name = new String(name.getBytes("ISO-8859-1"),"utf-8");
            criteria.setCname(name);
        }

        if(cellphone!=null && !cellphone.trim().isEmpty()){
            cellphone = new String(cellphone.getBytes("ISO-8859-1"),"utf-8");
            criteria.setCname(cellphone);
        }
        return criteria;
    }
    /*
    * 截取url
    * 解决路径指定问题（页码跳转）
     */
    private String getUrl(HttpServletRequest request){
        //项目名
        String contextPath = request.getContextPath();
        //servlet路径
        String servletPath = request.getServletPath();
        //得到参数
        String queryString = request.getQueryString();

        //判断参数部分是否包含&pc=这一部分，如果包含则截取，不需要这一部分
        if(queryString.contains("&pc=")){
            //获取位置
            int index = queryString.lastIndexOf("&pc=");
            //重新修剪
            queryString = queryString.substring(0,index);
        }
        return contextPath+servletPath+"?"+queryString;
    }

    //发布公告
    public String notice(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        Notice n = CommonUtils.toBean(request.getParameterMap(),Notice.class);
        n.setNid(CommonUtils.uuid());

        try{
            customerService.notice(n);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //保存request
        request.setAttribute("msg","公告发布成功");
        return "f:/webstudy/msg.jsp";
        //return "http://localhost:8080/NewStudy_war_exploded/webstudy/msg.jsp";
    }
    //显示所有公告
    //查询所有用户（利用分页的方法）
    public String view_notice(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        /*获取页面传递的页码pc
         *给定每页的数据数ps
         *使用pc和ps调用service方法，得到pageBean，保存到request，转发到list.jsp中
         * */
        //如果pc参数不存在，则默认的是第一页，即pc=1，如果参数存在则只要将pc转换成int类型
        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        PageBean<Notice> pb = customerService.view_notice(pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));
        request.setAttribute("pb",pb);
        return "f:/webstudy/CustomerManage/ViewNotice.jsp";
    }


}
