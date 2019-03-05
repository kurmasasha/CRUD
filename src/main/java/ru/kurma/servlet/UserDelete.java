package ru.kurma.servlet;

import ru.kurma.dao.UserDao;
import ru.kurma.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserDelete extends HttpServlet {

    UserDao userDao;
    int idDelete;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao = new UserDaoImpl();
        idDelete = Integer.parseInt(request.getParameter("id"));
        userDao.delete(idDelete);
        response.sendRedirect("/users");
    }
}