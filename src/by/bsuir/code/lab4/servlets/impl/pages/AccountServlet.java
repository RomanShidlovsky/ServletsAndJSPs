package by.bsuir.code.lab4.servlets.impl.pages;

import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.service.ServicesAccessPoint;
import by.bsuir.code.lab4.presentation.View;
import by.bsuir.code.lab4.presentation.content.*;
import by.bsuir.code.lab4.servlets.impl.ServletSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();
    private final View userView = new View(new Header(), new Account(servicesAccessPoint));
    private final View adminView = new View(new Header(), new AccountAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        switch (session.getUserRole()) {
            case User.UserRole.user:
                resp.getWriter().write(userView.get(session));
                break;

            case User.UserRole.admin:
                resp.getWriter().write(adminView.get(session));
                break;

            default:
                getServletContext().getRequestDispatcher("/404").forward(req, resp);
        }
    }
}
