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

        findId = Integer.parseInt(request.getParameter("id"));
        User user = userService.findUserById(findId);
        request.setAttribute("user", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/useredit.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firsName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        userService.updateUser(findId, firsName, lastName);

        response.sendRedirect("/users");
    }
}
