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
import br.edu.ifsuldeminas.mch.model.sistema.Email;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user", "/user/form", "/user/delete", "/user/insert", "/user/update", "/user/validation",
		"/user/logof","/user/acept","/user/alteraSenha","/user/troca" })
public class UserController extends HttpServlet {
	
	private String endereco="http://localhost:8080/sbma/";

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		if (action == null || action.equals("")) {
			ControllerUtil.forward(req, resp, "/index.jsp");
			return;
		}
		
		switch (action) {
		case "/Intersect/user/form":
			

			ControllerUtil.forward(req, resp, "/index.jsp");

			break;

		case "/sbma/user/logof":

			req.removeAttribute("usu");
			req.getSession().removeAttribute("usu");

			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");

			break;
		
			
		case "/sbma/user/acept":
			
			if(req.getParameter("c08cbbfd6eefc83ac6d23c4c791277e4").equals("272e81b5ac0e7c334b01b5ea9567e44c")) {
				if(confirmaUsuario(req))
					ControllerUtil.sucessMessage(req, "Cadastro confirmado");
				else
					ControllerUtil.errorMessage(req, "erro com a confirmação do seu cadastro");	
			}

			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
			
			break;
			
		case "/sbma/user/delete":
			
			if(req.getParameter("c08cbbfd6eefc83ac6d23c4c791277e4").equals("272e81b5ac0e7c334b01b5ea9567e44c")) {
				if(deletaUsuario(criaUsuario(req)))
					ControllerUtil.sucessMessage(req, "Cadastro confirmado");
				else
					ControllerUtil.errorMessage(req, "erro com a confirmação do seu cadastro");	
			}

			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
			
			break;
			
		case "/sbma/user/alteraSenha":
			
			if(req.getParameter("c08cbbfd6eefc83ac6d23c4c791277e4").equals("272e81b5ac0e7c334b01b5ea9567e44c")) {
				if(confirmaUsuario(req)) {
					
					
					req.getSession().setAttribute("autorizacao", "sim");
					req.getSession().setAttribute("action", "troca");
					req.getSession().setAttribute("email",req.getParameter("f8032d5cae3de20fcec887f395ec9a6a"));
					
					ControllerUtil.redirect(resp, req.getContextPath() + "/alteraSenha.jsp");
				}
				else {
					ControllerUtil.errorMessage(req, "Endereço de email não cadastrado");
					ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
				}
			}

			
			
			break;
			
		
		default:
			
			req.getSession().removeAttribute("autorizacao");
			req.getSession().removeAttribute("email");
			req.getSession().removeAttribute("action");
			
			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
			
			break;
		}
	}

	private boolean checaUsuario(HttpServletRequest req) {
		
		UsuarioDAO us = new UsuarioDAO();
		Usuario u = new Usuario();
		u.setLogin(req.getParameter("f8032d5cae3de20fcec887f395ec9a6a"));
		
		try {
			if (us.confirmaCadastro(u)) {
				
				Email e = new Email();
				
				e.email("acesse o link para alterar sua senha "+endereco+"user/alteraSenha?c08cbbfd6eefc83ac6d23c4c791277e4=272e81b5ac0e7c334b01b5ea9567e44c"
						+ "&f8032d5cae3de20fcec887f395ec9a6a="+u.getLogin(), u.getLogin(), "Alteração de senha");
			
				return true;
			}

				
			
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	private boolean deletaUsuario(Usuario u) {
		
		UsuarioDAO us = new UsuarioDAO();
		
		
		try {
			return us.delete(u);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
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
					
					 req.getSession().removeAttribute("usu");
					ControllerUtil.errorMessage(req, "Usuario ainda bloqueado cheque seu email");
					
					ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
					
					return ;
				}
		
					
				ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");

				return;
			}

			ControllerUtil.errorMessage(req, "Login ou senha invalidos");

			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");

			break;
			
	       case "/sbma/user/insert":
			
			
			if(salvaUsuario(criaUsuario(req)))
				ControllerUtil.sucessMessage(req, "usuario cadastrado, clique no link que foi enviado ao seu email");
			else
				ControllerUtil.errorMessage(req, "erro ao cadastrar usuario");
			
			ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
			
			break;
			
	       case "/sbma/user/update":
				
				
				if(alteraUsuario(criaUsuario(req)))
					ControllerUtil.sucessMessage(req, "senha alterada com sucesso");
				else
					ControllerUtil.errorMessage(req, "erro ao auterar senha");
				
				ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
				
				break;
				
	       case "/sbma/user/alteraSenha":
				
				if(req.getParameter("c08cbbfd6eefc83ac6d23c4c791277e4").equals("272e81b5ac0e7c334b01b5ea9567e44c")) {
					if(checaUsuario(req))
						ControllerUtil.sucessMessage(req, "Um email foi enviado com o link para a alteraçao de sua senha !");
					else
						ControllerUtil.errorMessage(req, "Endereço de email não cadastrado");	
				}

				ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
				
				break;
				
	       case "/sbma/user/troca":
				
				if(req.getParameter("c08cbbfd6eefc83ac6d23c4c791277e4").equals("272e81b5ac0e7c334b01b5ea9567e44c")) {
					if(alteraSenha(req)) {
						ControllerUtil.sucessMessage(req, "Senha alterada com sucesso !");
						
						req.getSession().removeAttribute("autorizacao");
						req.getSession().removeAttribute("email");
						req.getSession().removeAttribute("action");
						
					}
					else
						ControllerUtil.errorMessage(req, "Não foi possival alterar sua senha");	
				}

				ControllerUtil.redirect(resp, req.getContextPath() + "/index.jsp");
				
				break;

		default:

			System.out.println("URL invalida " + action);

			break;
		}

	}

	private boolean alteraSenha(HttpServletRequest req) {
		UsuarioDAO us = new UsuarioDAO();
		
		Usuario u = new Usuario();
		
		u.setLogin((String)req.getSession().getAttribute("email"));
		u.setSenha(md5(req.getParameter("senha")));
		
		try {
			return us.alter(u);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	private boolean alteraUsuario(Usuario criaUsuario) {
		
		UsuarioDAO us = new UsuarioDAO();
		
	
		try {
			return us.alter(criaUsuario);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
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
	
	private boolean salvaUsuario(Usuario u) {
		
		UsuarioDAO us = new UsuarioDAO();
		
		Email e = new Email();
		
		e.email("se cadastro precisa ser aprovado acesse o link "+endereco+"user/acept?c08cbbfd6eefc83ac6d23c4c791277e4=272e81b5ac0e7c334b01b5ea9567e44c"
				+ "&f8032d5cae3de20fcec887f395ec9a6a="+u.getLogin(), u.getLogin(), "validação de conta");
	
		try {
			return us.save(u);
		} catch (ModelException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		
		return false;
	}
	
	private boolean confirmaUsuario(HttpServletRequest req) {
		
		Usuario us = new Usuario();
		
		us.setLogin(req.getParameter("f8032d5cae3de20fcec887f395ec9a6a"));
		
		
		UsuarioDAO d = new UsuarioDAO();
		
		try {
			return d.confirmaCadastro(us);
	
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	private Usuario criaUsuario(HttpServletRequest req) {
		
		Usuario us = new Usuario();
		
		us.setAdm(req.getParameter("tipo_user").equalsIgnoreCase("1"));
		us.setBloqueado(true);
		us.setLogin(req.getParameter("email"));
		us.setSenha(md5(req.getParameter("senha")));
		
		return us;
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
