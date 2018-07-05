package br.edu.ifsuldeminas.mch.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsuldeminas.mch.model.Usuario;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.DAOFactory;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.ModelException;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.UsuarioDAO;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user", "/user/form", "/user/delete", "/user/insert", "/user/update", "/user/validation",
		"/user/logof","/user/acept" })
public class UserController extends HttpServlet {

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		switch (action) {
		case "/Intersect/user/form":
			

			ControllerUtil.forward(req, resp, "/index.jsp");

			break;

		case "/sbma/user/logof":

			req.removeAttribute("usu");
			req.getSession().removeAttribute("usu");

			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");

			break;
			
		case "/Intersect/user":


			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
			
			break;
			
		case "/user/acept":


			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
			
			break;

		default:
			
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();


		if (action == null || action.equals("")) {
			ControllerUtil.forward(req, resp, "/index.jsp");
			return;
		}

		switch (action) {
		case "/sbma/user/validation":

			if (validaUser(req)) {
				
				if(!((Usuario) req.getSession().getAttribute("usu")).isBloqueado()){
					
					ControllerUtil.errorMessage(req, "Usuario ainda bloqueado cheque seu email");
					
					return ;
				}
		
					
				ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");

				return;
			}

			ControllerUtil.errorMessage(req, "Login ou senha invalidos");

			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");

			break;

		default:

			System.out.println("URL invalida " + action);

			break;
		}

	}

	private boolean validaUser(HttpServletRequest req) {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		UsuarioDAO us = (UsuarioDAO) DAOFactory.createDAO(Usuario.class);
		
		Usuario usuario = new Usuario(login, md5(senha));
		

		try {
			if(us.validaUsuario(usuario)){
				req.getSession().setAttribute("usu", usuario);
				return true;
			}
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return false;
	}
	
	private String md5(String entrada) {

		String md5 = null;
 
		try {

			MessageDigest digest = MessageDigest.getInstance("MD5");

			digest.update(entrada.getBytes(), 0, entrada.length());

			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return md5;
	}
	
}
