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
public class UserUpdate extends HttpServlet {

    private Integer findId;
    private UserService userService = UserService.getInstance();
    private User user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter("id");
        try {
            findId = Integer.parseInt(idStr);
            user = userService.findUserById(findId);
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
        userService.updateUser(findId, user);

        response.sendRedirect("/users");
    }
}
