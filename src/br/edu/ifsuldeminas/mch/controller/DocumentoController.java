package br.edu.ifsuldeminas.mch.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/document/save","/document/update","/document/delete","/document/insert"})
@MultipartConfig
public class DocumentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String pastaProjeto = getServletContext().getRealPath("");
		
		String salvarDocument = pastaProjeto + File.separator +"WEB-INF" + File.separator +"documentos";
		
		File pasta = new File(salvarDocument);
		
		if(!pasta.exists()){
			pasta.mkdirs();
		} 
		
		
		Part arquivo = req.getPart("documento");
		
		
		arquivo.write(salvarDocument + File.separator + arquivo.getSubmittedFileName());
		
		ControllerUtil.sucessMessage(req, "Salvo com sucesso!");
		
		ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
		
		
	}

}
