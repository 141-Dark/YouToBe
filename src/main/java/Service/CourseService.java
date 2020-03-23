package Service;

import DAO.CourseDAO;
import domain.*;

import java.sql.SQLException;
import java.util.List;

public class CourseService {
    private CourseDAO courseDAO = new CourseDAO();
    public void addcourse(Course c) throws SQLException {
        courseDAO.addcourse(c);
    }

    public List<Qt_Type> findAll() throws SQLException {
        return courseDAO.findAll();
    }

    public void add_blanks(Blanks b) throws SQLException {
        courseDAO.add_blanks(b);
    }

    //选择科目
    public PageBean<Course> choosesubject(int pc, int ps) throws SQLException {
        return courseDAO.choosesubject(pc,ps);
    }

    //显示填空题考试内容
    public PageBean<Blanks> blankstest(String cname, int pc, int ps) throws SQLException {
        return courseDAO.blankstest(cname,pc,ps);
    }

    public void add_blanks_answer(List<AddBlanksAnswer> a) throws SQLException {
        courseDAO.add_blanks_answer(a);
    }
    //填空题作答
    public PageBean<BlankScore> show_score(String customer_id, int pc, int ps) throws SQLException {
        return courseDAO.show_score(customer_id,pc,ps);
    }

    public void add_selects(List<Selects> se) throws SQLException {
        courseDAO.addselects(se);
    }

    public PageBean<Selects> selectstest(String cname, int pc, int ps) throws SQLException {
        return courseDAO.selectstest(cname,pc,ps);
    }

    public void add_selects_answer(List<AddSelectsAnswer> a) throws SQLException {
        courseDAO.add_selects_answer(a);
    }
}
