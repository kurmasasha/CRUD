package ru.kurma.servlet;

import ru.kurma.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signup")
public class SingUpServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/signup.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String role = "user";
        try {
            userService.createNewUser(firstName, lastName, login, password, role);
        } catch (Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/errorsignup.jsp");
            dispatcher.forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        response.sendRedirect("/home");
    }
}
