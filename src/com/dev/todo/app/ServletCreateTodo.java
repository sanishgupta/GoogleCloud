package com.dev.todo.app;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dev.todo.app.dao.Dao;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ServletCreateTodo extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("Creating new todoApp......... ");
        User user = (User) req.getAttribute("user");
        if (user == null) {
            UserService userService = UserServiceFactory.getUserService();
            user = userService.getCurrentUser();
        }

        String summary = checkNull(req.getParameter("summary"));
        String longDescription = checkNull(req.getParameter("description"));
        String url = checkNull(req.getParameter("url"));

        Dao.INSTANCE.add(user.getUserId(), summary, longDescription, url, "Pending");

        resp.sendRedirect("/TodoApplication.jsp");
    }

    private String checkNull(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}