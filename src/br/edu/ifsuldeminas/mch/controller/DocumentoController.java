package br.edu.ifsuldeminas.mch.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.edu.ifsuldeminas.mch.model.Documento;



@WebServlet(urlPatterns = {"/document/save","/document/update","/document/delete","/document/insert"})
@MultipartConfig
public class DocumentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getRequestURI();
		
		switch (action) {
		case "/Intersect/user/form":
		
		ControllerUtil.sucessMessage(req, "Salvo com sucesso!");
		
		ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
		
		break;
		
		}
		
		
	}
	
	private boolean salva(HttpServletRequest req,HttpServletResponse res) {
		
		String pastaProjeto = getServletContext().getRealPath("");
		
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		
		String salvarDocument = pastaProjeto + File.separator +"WEB-INF" + File.separator +"documentos";
		
		File pasta = new File(salvarDocument);
		
		if(!pasta.exists()){
			pasta.mkdirs();
		} 
		
		
		Part arquivo;
		try {
			arquivo = req.getPart("documento");
			arquivo.write(salvarDocument + File.separator + arquivo.getSubmittedFileName());
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return true;
	}
	
	private Documento geraDocumento(HttpServletRequest req,HttpServletResponse res) {
		Documento doc = new Documento();
		
		doc.setAutores(req.getParameter("autores"));
		doc.setCo_orientador(req.getParameter("co_orientador"));
		doc.setDataDefesa(req.getParameter("data"));
		doc.setOrientador(req.getParameter("orientador"));
		doc.setPalavrasChaves(req.getParameter("palavras"));
		doc.setResumo(req.getParameter("resumo"));
		doc.setSub_titulo(req.getParameter("sub_titulo"));
		doc.setTipo(Integer.valueOf(req.getParameter("tipo")));
		doc.setTitulo(req.getParameter("titulo"));
		doc.setSubArea(Integer.valueOf(req.getParameter("sub_area")));
		
		return doc;
		
	}

}
