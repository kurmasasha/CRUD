package ru.kurma.servlet;

import ru.kurma.model.User;
import ru.kurma.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null) {
            response.sendRedirect("/home");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/signin.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.findUserByLogin(login);
        if ((user != null)) {
            if ((user.getLogin().equals(login)) & (user.getPassword().equals(password))) {
            } else {
                response.sendRedirect("/signin");
            }
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            session.setAttribute("role", user.getRole());
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/signin");
        }
    }
}
