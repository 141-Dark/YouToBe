package Servlet;

import Service.CourseService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends BaseServlet {
    private CourseService courseService = new CourseService();
    public String addcourse(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        String ty = request.getParameter("qt_type");
        Course c = CommonUtils.toBean(request.getParameterMap(),Course.class);
        c.setCid(CommonUtils.uuid());

        HttpSession session = request.getSession();
        session.setAttribute("cname",c.getCname());
        courseService.addcourse(c);
        if(ty.equals("填空题")){
            request.setAttribute("msg","添加成功,<a href=\"webstudy/TestOnline1/blanks.jsp\">点击添加填空题</a>");
        }else {
            request.setAttribute("msg","添加成功,<a href=\"webstudy/TestOnline1/selects.jsp\">点击添加选择题</a>");
        }
        return "f:/webstudy/msg.jsp";
    }


    //添加填空题内容
    public String add_blanks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Blanks b = CommonUtils.toBean(request.getParameterMap(),Blanks.class);
        HttpSession session = request.getSession();
        String subject = (String) session.getAttribute("cname");
        b.setBlanks_id(CommonUtils.uuid());//设置题目id
        b.setSubject(subject);//设置科目名称

        courseService.add_blanks(b);
        request.setAttribute("msg","添加成功,<a href=\"webstudy/TestOnline1/blanks.jsp\">点击继续添加</a>");
        return "f:/webstudy/msg.jsp";
    }
    //查询所有用户（无分页）
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        request.setAttribute("typeList",courseService.findAll());
        return "f:/webstudy/TestOnline2/system/teacher/subject_add.jsp";
    }


    //选择考试科目
    public String choosesubject(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        /*获取页面传递的页码pc
         *给定每页的数据数ps
         *使用pc和ps调用service方法，得到pageBean，保存到request，转发到list.jsp中
         * */
        //如果pc参数不存在，则默认的是第一页，即pc=1，如果参数存在则只要将pc转换成int类型

        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        PageBean<Course> pb = courseService.choosesubject(pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));

        request.setAttribute("pb",pb);
        return "f:/webstudy/TestOnline1/ChooseSubject.jsp";
    }


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

    //填空题考试(显示试题)
    public String blankstest(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        //获取科目名称
        String cname = request.getParameter("cname");
        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        PageBean<Blanks> pb = courseService.blankstest(cname,pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));
        request.setAttribute("pb",pb);
        request.setAttribute("cname",cname);
        return "f:/webstudy/TestOnline1/blanks_test.jsp";
    }

    //选择题考试(显示试题)
    public String selectstest(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        //获取科目名称
        String cname = request.getParameter("cname");
        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        PageBean<Selects> pb = courseService.selectstest(cname,pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));
        request.setAttribute("pb",pb);
        request.setAttribute("cname",cname);
        return "f:/webstudy/TestOnline1/selects_test.jsp";
    }

    //添加你问题的答案(填空题)
    public String add_blanks_answer(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        String[] cname = request.getParameterValues("cname");
        String[] number = request.getParameterValues("number");
        String[] title = request.getParameterValues("title");
        String[] yanswer = request.getParameterValues("yanswer");
        String[] customer_id = request.getParameterValues("customer_id");

        List<AddBlanksAnswer> a = new ArrayList<AddBlanksAnswer>();
        for (int i = 0;i<title.length;i++){
            AddBlanksAnswer add = new AddBlanksAnswer();
            add.setCname(cname[i]);
            add.setTitle(title[i]);
            add.setNumber(number[i]);
            add.setYanswer(yanswer[i]);
            add.setCustomer_id(customer_id[i]);
            a.add(add);
        }
        courseService.add_blanks_answer(a);
        request.setAttribute("msg","提交成功,请前往查看成绩</a>");

        return "f:/webstudy/msg.jsp";
    }
    //添加你问题的答案(选择题)
    public String add_selects_answer(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        String[] cname = request.getParameterValues("cname");
        String[] number = request.getParameterValues("number");
        String[] s_title = request.getParameterValues("title");
        String[] yanswer = request.getParameterValues("yanswer");
        String[] customer_id = request.getParameterValues("customer_id");

        List<AddSelectsAnswer> a = new ArrayList<AddSelectsAnswer>();
        for (int i = 0;i<cname.length;i++){
            AddSelectsAnswer add = new AddSelectsAnswer();
            add.setCname(cname[i]);
            add.setTitle(s_title[i]);
            add.setNumber(number[i]);
            add.setYanswer(yanswer[i]);
            add.setCustomer_id(customer_id[i]);
            a.add(add);
        }
        courseService.add_selects_answer(a);
        request.setAttribute("msg","提交成功,请前往查看成绩</a>");

        return "f:/webstudy/msg.jsp";
    }
    //查询成绩
    public String show_score(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException, SQLException, ClassNotFoundException {
        int pc = getPic(request);
        int ps = 7;//给定每页数据的数目

        String customer_id = (String) request.getSession().getAttribute("customer_id");
        PageBean<BlankScore> pb = courseService.show_score(customer_id,pc,ps);
        //得到url，保存到pb中
        pb.setUrl(getUrl(request));
        request.setAttribute("pb",pb);
        return "f:/webstudy/TestOnline1/show_score.jsp";
    }

    //设置选择题个数
    public String tes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Tes s = CommonUtils.toBean(request.getParameterMap(),Tes.class);

        //courseService.t_num(n);
        String se = s.getTes();

        int c = Integer.parseInt(se);
        request.setAttribute("tes",se);
        return "f:/webstudy/TestOnline1/selects.jsp";
    }
    //添加选择题内容
    public String add_selects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        Selects s = CommonUtils.toBean(request.getParameterMap(),Selects.class);
        HttpSession session = request.getSession();
        String subject = (String) session.getAttribute("cname");

        String[] s_title = request.getParameterValues("s_title");
        String[] a = request.getParameterValues("a");
        String[] b = request.getParameterValues("b");
        String[] c = request.getParameterValues("c");
        String[] d = request.getParameterValues("d");
        String[] s_answer = request.getParameterValues("s_answer");
        String[] s_score = request.getParameterValues("s_score");

        List<Selects> se = new ArrayList<Selects>();
        for (int i = 0;i<s_title.length;i++){
            Selects selects = new Selects();
            selects.setSelect_id(CommonUtils.uuid());
            selects.setSubject(subject);
            selects.setS_title(s_title[i]);
            selects.setA(a[i]);
            selects.setB(b[i]);
            selects.setC(c[i]);
            selects.setD(d[i]);
            selects.setS_answer(s_answer[i]);
            selects.setS_score(s_score[i]);
            se.add(selects);
        }
        courseService.add_selects(se);
        request.setAttribute("msg","添加成功,<a href=\"webstudy/TestOnline1/selects.jsp\">点击继续添加</a>");
        return "f:/webstudy/msg.jsp";
    }
}
