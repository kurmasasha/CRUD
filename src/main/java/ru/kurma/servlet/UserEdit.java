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
public class UserEdit extends HttpServlet {

    private Integer findId;
    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user;
        String idStr = request.getParameter("id");
        Integer findId;
        try {
            findId = Integer.parseInt(idStr);
            user = userService.findUserById(findId);
            if (user == null) {
                throw new IllegalArgumentException();
            }
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/useredit.jsp");
            requestDispatcher.forward(request, response);
        } catch (IllegalArgumentException e) {
            response.sendRedirect("/users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firsName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        userService.updateUser(findId, firsName, lastName);

        response.sendRedirect("/users");
    }
}
