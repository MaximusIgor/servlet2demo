package home.ihorshylov;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    String databaseName;
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HomeServlet Initialize");
        databaseName = config.getInitParameter("databaseName");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet method");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");
        resp.getWriter().print("<h1>Lesson #2</h1>");
        resp.getWriter().print("<h2>databaseName: " + databaseName + "</h2>");
        resp.getWriter().print("<a href='/student'>Go to student</a>");
    }

    @Override
    public void destroy() {
        System.out.println("HomeServlet Destroy");
        super.destroy();
    }
}
