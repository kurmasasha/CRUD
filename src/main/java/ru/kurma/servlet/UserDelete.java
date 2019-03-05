package ru.kurma.servlet;

import ru.kurma.dao.UserDaoImplJDBC;
import ru.kurma.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserDelete extends HttpServlet {

    private UserService userService = new UserService(new UserDaoImplJDBC());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.deleteUser(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/users");
    }
}