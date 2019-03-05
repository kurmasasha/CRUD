package ru.kurma.servlet;

import ru.kurma.dao.UserDao;
import ru.kurma.dao.UserDaoImpl;
import ru.kurma.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class Users extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = new UserDaoImpl().findAll();


        request.setAttribute("users", users);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/users.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idStr = request.getParameter("id");



//            int id = Integer.parseInt(idStr);
//            System.out.println(id);
//            userDao.delete(id);

//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/users.jsp");
//        requestDispatcher.forward(request, response);
//        response.sendRedirect("/users");
    }
}
