package br.edu.ifsuldeminas.mch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ac","/ae","/sa"}, asyncSupported = true)
public class AreasController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String action = req.getRequestURI();
		
		
		switch (action) {
		case "/sbma/ac":
			
			System.out.println("ac");
			
			resp.getWriter().println("<option value=\"3\">3</option>"
					+ "<option value=\"4\">4</option>"
					+ "<option value=\"5\">5</option>");
		
			break;
		case "/sbma/ae":
			
			System.out.println("ae");
			
			resp.getWriter().println("<option value=\"3\">6</option>"
					+ "<option value=\"4\">7</option>"
					+ "<option value=\"5\">8</option>");
		
			
			break;
		case "/sbma/sa":
			
			System.out.println("as");
			
			switch (req.getParameter("id")) {
			case "5":
				resp.getWriter().println("<option value=\"3\">9</option>"
						+ "<option value=\"4\">10</option>"
						+ "<option value=\"5\">11</option>");
				break;

			default:
				resp.getWriter().print("nada");
				break;
			}
			
		
			
		
	
	break;
		default:
			break;
		}
		
		destroy();
		
	}
	
	
	

}
