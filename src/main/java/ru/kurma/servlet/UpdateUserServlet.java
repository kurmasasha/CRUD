package ru.kurma.servlet;

import ru.kurma.model.User;
import ru.kurma.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class UpdateUserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private User user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter("id");
        try {
            user = userService.findUserById(Integer.parseInt(idStr));
            if (user == null) {
                response.sendRedirect("/users");
            }else {
                request.setAttribute("user", user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/useredit.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            response.sendRedirect("/users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        user.setFirstName(request.getParameter("FirstName"));
        user.setLastName(request.getParameter("LastName"));
        user.setRole(request.getParameter("Role"));
        userService.updateUser(user);

        response.sendRedirect("/users");
    }
}
