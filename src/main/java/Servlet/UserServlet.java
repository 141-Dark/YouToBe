package Servlet;

import Service.UserException;
import Service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Customer;
import domain.User;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "registerServlet" ,urlPatterns = "/registerServlet")
public class UserServlet extends BaseServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Service依赖于UserService（记不得的话查一下java三层架构）必须是一层依赖一层
        UserService userService = null;
        try {
            userService = new UserService();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //User user= userService.find();
        //最后保存到User对象中
        request.setAttribute("user","user");
        //转发到jsp页面中
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }*/

    private UserService userService;

    {
        try {
            userService = new UserService();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = CommonUtils.toBean(request.getParameterMap(), User.class);
        try{
            userService.regist(u);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("user","user");
        //转发到jsp页面中
        request.getRequestDispatcher("/webstudy/welcome.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserService userService = null;
        try {
            userService = new UserService();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);

        try{
            User user = userService.login(form);
            //没有异常时，保存到session中
            //request.getSession().setAttribute("sessionUser",user);获取User中的所有属性时User类中必须有toString方法

            request.getSession().setAttribute("UserName",user.getUserName());//获取用户名
            //跳转到网页
            response.sendRedirect(request.getContextPath()+"/webstudy/welcome.jsp");
        }
        catch (UserException | DocumentException | SQLException e){
            //将异常保存到request
            request.setAttribute("msg",e.getMessage());
            //保存form
            request.setAttribute("user",form);
            //异常转发
            request.getRequestDispatcher("/webstudy/Login.jsp").forward(request,response);
        }
    }

    public void stu_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserService userService = null;
        try {
            userService = new UserService();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        Customer form = CommonUtils.toBean(request.getParameterMap(),Customer.class);

        try{
            Customer c = userService.stu_login(form);

            request.getSession().setAttribute("customer_id",c.getCid());//获取学生账号
            request.getSession().setAttribute("customer_name",c.getCname());//获取学生账号
            //跳转到网页
            response.sendRedirect(request.getContextPath()+"/webstudy/TestOnline1/testonline.jsp");
        }
        catch (UserException | DocumentException | SQLException e){
            //将异常保存到request
            request.setAttribute("msg",e.getMessage());
            //保存form
            request.setAttribute("user",form);
            //异常转发
            request.getRequestDispatcher("webstudy/msg.jsp").forward(request,response);
        }
    }
}
