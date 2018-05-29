package home.ihorshylov;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {

    String servletName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletName = config.getServletName();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>" + servletName + "</h1>");
        writer.println("<form method='post' action = '/student'>" +
                "<label for= 'first_name'>Name: </label>" +
                "<input type= 'text' id = 'first_name' name='first_name'/></br>" +
                "<label for= 'email'>Email: </label>" +
                "<input type= 'email' id = 'email' name='email'/></br>" +
                "<label for= 'age'> Age: </label>" +
                "<input type= 'number' id = 'age' name='age'/></br>" +
                "<input type='submit'/>" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPost");
        // Получение данных формы
        String first_name = req.getParameter("first_name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        System.out.println("first_name = " + first_name);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
        System.out.println();

        doGet(req, resp);
    }
}
