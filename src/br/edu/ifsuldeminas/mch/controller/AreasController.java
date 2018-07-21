package br.edu.ifsuldeminas.mch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsuldeminas.mch.model.AreaDoConhecimento;
import br.edu.ifsuldeminas.mch.model.AreaEspecifica;
import br.edu.ifsuldeminas.mch.model.SubArea;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.GrandeAreaDAO;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.ModelException;

@WebServlet(urlPatterns = {"/ac","/ae","/sa"}, asyncSupported = true)
public class AreasController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String action = req.getRequestURI();
		
		
		GrandeAreaDAO ga = new GrandeAreaDAO();
		
		resp.getWriter().println("<option value=\"0\">Selecione Alguma</option>");
		
		switch (action) {
		case "/sbma/ac":
			
		
			try {
				for(AreaDoConhecimento a : ga.areaConhecimentoList(Integer.valueOf(req.getParameter("id")))){
				resp.getWriter().println("<option value=\""+a.getCodigo()+"\">"+a.getDescricao()+"</option>");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			break;
			
		case "/sbma/ae":
			

			try {
				for(AreaEspecifica a : ga.areaEspecificaList(Integer.valueOf(req.getParameter("id")))){
				resp.getWriter().println("<option value=\""+a.getCodigo()+"\">"+a.getDescricao()+"</option>");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "/sbma/sa":

			try {
				for(SubArea a : ga.subAreaList(Integer.valueOf(req.getParameter("id")))){
				resp.getWriter().println("<option value=\""+a.getCodigo()+"\">"+a.getDescricao()+"</option>");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		break;
			
		default:
		resp.getWriter().print("nada");
		break;
		
		}

		
	}
	
	
	

}
