package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
    //销毁之前执行（服务器关闭之前），释放飞内存资源
    public void destroy() {
    }

    //每次过滤都会执行
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //讲req强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        //获取请求的url
        String getUrl = request.getRequestURI();
        //根据判断过滤
        if(getUrl.endsWith("/")){
            chain.doFilter(request,resp);
        }

    }

    //创建时（就是服务器启动时）马上执行
    public void init(FilterConfig config) throws ServletException {

    }

}
