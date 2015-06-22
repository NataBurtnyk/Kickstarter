package com.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale.Category;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kickstarter.model.CategoriesDAO;
import com.kickstarter.model.Project;
import com.kickstarter.model.ProjectsDAO;
import com.kickstarter.model.QuotesDAO;
import com.kickstarter.model.Сategory;

public class MainServlet extends HttpServlet {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver is not found.");
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = getAction(req);
		Connection connection = getConnection(req);
		
		if (action.startsWith("/categories")) {
			
			QuotesDAO quotesDAO = new QuotesDAO(connection);
		
			CategoriesDAO categoriesDAO = new CategoriesDAO(connection);
			List<Сategory> categories = categoriesDAO.getCategories();
			
			req.setAttribute("quote", quotesDAO.getRandomQuote());
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
	
		} else if (action.equals("/projects")){
			int categoryId = Integer.valueOf(req.getParameter("category"));
			
			ProjectsDAO projectsDAO = new ProjectsDAO(connection);
			List<Project> projects = projectsDAO.getProjects(new Сategory(categoryId)); 
			
			req.setAttribute("projects", projects);
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
			
		}  else if (action.equals("/project")){
			int projectId = Integer.valueOf(req.getParameter("id"));
			
			ProjectsDAO projectsDAO = new ProjectsDAO(connection);
			Project project = projectsDAO.get(projectId);
			
			req.setAttribute("project", project);
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}
	}

	private Connection getConnection(HttpServletRequest req) {
		Connection result = (Connection)req.getSession().getAttribute("connection");
		if (result == null) {
			try{
				result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DataForKickstarter", "postgres", "Berezhnoi");
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			req.getSession().setAttribute("connection", result);
		}
		return result;
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}
}
