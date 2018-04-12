package com.dev.gae.java.todo;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Com_dev_gae_java_todoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
