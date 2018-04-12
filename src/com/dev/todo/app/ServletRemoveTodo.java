package com.dev.todo.app;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dev.todo.app.dao.Dao;

public class ServletRemoveTodo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        String id = req.getParameter("id");
        String operation = req.getParameter("op");
        
        //Dao.INSTANCE.remove(Long.parseLong(id));
        
        Dao.INSTANCE.remove(Long.parseLong(id), operation);
        resp.sendRedirect("/TodoApplication.jsp");
    }
}