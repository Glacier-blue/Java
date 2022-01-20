import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str1=req.getParameter("a");
        String str2=req.getParameter("b");
        int a=Integer.parseInt(str1);
        int b=Integer.parseInt(str2);
        int result=a+b;
        resp.getWriter().write(String.format("<h1>relult=%d</h1>",result));
    }
}
