package Servlet;

import cn.itcast.commons.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/UploadServlet")

/*
* 需要导读两个以来，commons-io和commons-fileuplaod
* 可以帮助解析我们上传的数据
* 解析的结果是一个表单项数据放到一个item对象中
* */
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /*
        * 上传三步
        * 得到工厂
        * 通过工厂创建解析器
        * */
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);//得到解析器
        //解析request，得到fileItem集合
        try {
            List<FileItem> fileItemList = sfu.parseRequest(request);

            FileItem f2  = fileItemList.get(1);//得到文件表单项


            String filename = f2.getName();
            //String savename = CommonUtils.uuid()+"_"+filename;
            //保存文件
            File dir= new File("E:/测试文件夹");
            File uploadfile = new File(dir,filename);
            f2.write(uploadfile);

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg","添加文件成功");
        request.getRequestDispatcher("/webstudy/msg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
