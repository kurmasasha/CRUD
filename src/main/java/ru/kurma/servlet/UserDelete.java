package ru.kurma.servlet;

import ru.kurma.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserDelete extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        Integer id;

        try {
            id = Integer.parseInt(idStr);
            userService.deleteUser(id);
            response.sendRedirect("/users");

        } catch (IllegalArgumentException e) {
            response.sendRedirect("/users");
        }
    }
}