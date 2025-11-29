package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MapRepository;
import util.Validator;

import java.io.IOException;

@WebServlet("/register")
public class RegServlet extends HttpServlet {
    private final Validator validator;

    public RegServlet() {
        this.validator = new Validator();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("reg_username");
        String password = req.getParameter("reg_password");
        String confirmPassword = req.getParameter("confirm_password");

        if (validator.validateLoginPassword(username, password, confirmPassword)) {
            MapRepository.addUserToBase(username, password);
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/todo");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/register.html").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/register.html").forward(req, resp);
    }
}
