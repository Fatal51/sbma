package br.edu.ifsuldeminas.mch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/erro","/404"})
public class ErroController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String action = req.getRequestURI();
		 
		
		switch (action) {
			
		case "/sbma/erro":
			ControllerUtil.errorMessage(req, "erro na solicitação junto a servidor por favor tente novamente mais tarde !");
		break;
		
		case "/sbma/404":
			ControllerUtil.errorMessage(req, "a pagina que você tentou acessar não existe !");
		break;
			
		}
		
		ControllerUtil.redirect(resp, "/sbma");
	}
	
}
