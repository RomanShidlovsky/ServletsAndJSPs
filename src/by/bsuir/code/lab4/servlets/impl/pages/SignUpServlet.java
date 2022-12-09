package by.bsuir.code.lab4.servlets.impl.pages;

import by.bsuir.code.lab4.presentation.View;
import by.bsuir.code.lab4.presentation.content.Header;
import by.bsuir.code.lab4.presentation.content.SignUp;
import by.bsuir.code.lab4.servlets.impl.ServletSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        if (session.isAuthorized()) {
            resp.sendRedirect("/");
        }

        resp.getWriter().write(new View(new Header(), new SignUp(req.getParameter("err") != null)).get(session));
    }
}
