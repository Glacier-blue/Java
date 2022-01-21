import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo6 extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对页面进行跳转（重定向操作）
        resp.sendRedirect("https://www.baidu.com");
        //也可以写成下面这样
//        resp.setStatus(302);
//        resp.setHeader("Location","https://www.baidu.com");
    }
}
