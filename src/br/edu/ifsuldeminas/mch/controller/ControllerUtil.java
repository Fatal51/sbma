package br.edu.ifsuldeminas.mch.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUtil {
	
	private static String MESSAGE_KEY = "message";
	private static int ERROR = 0;
	private static int SUCESS = 1;
	
	static void forward(HttpServletRequest req, HttpServletResponse resp, String target) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req
	            .getRequestDispatcher(target);
		
	    dispatcher.forward(req, resp);
	}
	
	static void redirect(HttpServletResponse resp, String target) throws IOException {
		resp.sendRedirect(target);
	}
	
	static void deletMennsage(HttpServletRequest req){
	
		req.getSession().removeAttribute(MESSAGE_KEY);
		
	}
	
	static void sucessMessage(HttpServletRequest req, String message) {
		req.getSession().setAttribute(MESSAGE_KEY, message);
		req.getSession().setAttribute("alertType", SUCESS);
	}
	
	static void errorMessage(HttpServletRequest req, String message) {
		req.getSession().setAttribute(MESSAGE_KEY, message);
		req.getSession().setAttribute("alertType", ERROR);
	}
	
	static void transferSessionMessagesToRequest(HttpServletRequest req) {
		if (req.getSession().getAttribute(MESSAGE_KEY) != null){
			String message = (String) req.getSession().getAttribute(MESSAGE_KEY);
			req.setAttribute(MESSAGE_KEY, message);
			req.getSession().removeAttribute(MESSAGE_KEY);
		}
			
		if (req.getSession().getAttribute("alertType") != null){
			Integer message = (Integer) req.getSession().getAttribute("alertType");
			req.setAttribute("alertType", message);
			req.getSession().removeAttribute("alertType");
		}	
	}
}
