import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie userName=new Cookie("UserName","wangfuming");
        Cookie userAge=new Cookie("Age",22+"");
        resp.addCookie(userName);
        resp.addCookie(userAge);
        resp.setContentType("text/html;charset=utf-8");
        Writer writer= resp.getWriter();
        writer.write("<html>");
        writer.write("返回cookie添加成功");
        writer.write("</html>");
    }
}
