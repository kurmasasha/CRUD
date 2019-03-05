package ru.kurma.servlet;

import ru.kurma.dao.UserDao;
import ru.kurma.dao.UserDaoImplJDBC;
import ru.kurma.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/useradd")
public class UserAdd extends HttpServlet {

    private UserService userService = new UserService(new UserDaoImplJDBC());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/useradd.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");

        userService.createNewUser(firstName, lastName);

        response.sendRedirect("/users");


    }
}
