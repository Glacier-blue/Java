import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        Integer count = 1;
        if (httpSession.isNew()) {
            httpSession.setAttribute("count", count);
        } else {
            count = (Integer) httpSession.getAttribute("count");
            count = count + 1;
            httpSession.setAttribute("count", count);
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("访问次数->" + count);
    }
}
