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
import br.edu.ifsuldeminas.mch.model.bancoDeDados.DocumentDAO;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.ModelException;



@WebServlet(urlPatterns = {"/document/save","/document/update","/document/remove","/document/insert","/document/form","/document/list",
		"/document/buscar","/document/proximo","/document/anterior","/document/pagina","/document/cancelar"})
@MultipartConfig
public class DocumentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getRequestURI();
		
		
		
		switch (action) {
		case "/sbma/document/save":
			if(salva(req, res)) {
			
				ControllerUtil.sucessMessage(req, "Salvo com sucesso!");
				
				ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
			}else {
				ControllerUtil.errorMessage(req, "Erro ao salvar!");
				
				ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
			}
		break;
		
		case "/sbma/document/update":
			
			if(update(req, res)) {
			
				ControllerUtil.sucessMessage(req, "Alterado com sucesso!");
				
				ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
			}else {
				ControllerUtil.errorMessage(req, "Erro ao alterar!");
				
				ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
			}
		break;
		
		
		}
		
		
	}
	
	private boolean update(HttpServletRequest req, HttpServletResponse res) {
		
		String pastaProjeto = getServletContext().getRealPath("");
		
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		
		String salvarDocument = pastaProjeto  + File.separator +"documentos";
	
		
		
		try {
			
			Part arquivo= req.getPart("documeto");
			
			
			if(!arquivo.getSubmittedFileName().isEmpty()) {
		
				Documento doc = geraDocumento(req);
				doc.setCaminho(myRandom+".pdf");
				DocumentDAO docDao = new DocumentDAO(); 
				
				if(docDao.update(doc)) {
					
					arquivo = req.getPart("documeto");
					arquivo.write(salvarDocument + File.separator + doc.getCaminho());
					
					Documento antigo = (Documento) req.getSession().getAttribute("documento");
					File pasta = new File(salvarDocument,antigo.getCaminho());
					pasta.delete();
					
				
					return true;
				}
						
			}else {
				
				Documento doc = geraDocumento(req);
				Documento antigo = (Documento) req.getSession().getAttribute("documento");
				doc.setCaminho(antigo.getCaminho());
				DocumentDAO docDao = new DocumentDAO(); 
				
				if(docDao.update(doc)) {
					
					return true;
			
				}
			}
				
	
		} catch (IOException | ServletException | ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
		
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getRequestURI();
		
		switch (action) {
		case "/sbma/document/form":
			req.getSession().setAttribute("action", "save");
			req.getSession().removeAttribute("documento");
			ControllerUtil.forward(req, res, "/form_documento.jsp");
		break;
		
		case "/sbma/document/list":
			DocumentDAO docs = new DocumentDAO();
			try {
				req.getSession().setAttribute("documentos",docs.documentos(0));
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ControllerUtil.redirect(res, req.getContextPath() + "/list.jsp");
		break;
		
		case "/sbma/document/buscar":
			
			removePaginacao(req);
			BuscaToRequest(0,req,req.getParameter("tipo_busca"),req.getParameter("busca"));
			
	
			ControllerUtil.redirect(res, req.getContextPath() + "/list.jsp");
		break;
		
		case "/sbma/document/proximo":
			
			proximo(req);
			
	
			ControllerUtil.redirect(res, req.getContextPath() + "/list.jsp");
		break;
		
		case "/sbma/document/anterior":
			
			
			anterior(req);
	
			ControllerUtil.redirect(res, req.getContextPath() + "/list.jsp");
		break;
		
		case "/sbma/document/pagina":
			
			
			pagina(req);
	
			ControllerUtil.redirect(res, req.getContextPath() + "/list.jsp");
		break;
		
		case "/sbma/document/update":
			
			preparaUpdate(req);
	
			ControllerUtil.redirect(res, req.getContextPath() + "/form_documento.jsp");
		break;
		
		case "/sbma/document/cancelar":
			
			req.getSession().removeAttribute("documento");
			req.getSession().removeAttribute("action");
	
			ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
		break;
		
		case "/sbma/document/remove":
			
			removeDocumento(req);
	
			ControllerUtil.redirect(res, req.getContextPath() + "/index.jsp");
		break;
		
		default:
			
			ControllerUtil.errorMessage(req, "não e possivel realizar essa acao");
			ControllerUtil.redirect(res,req.getContextPath() +  "/index.jsp");
		break;
		
		}
		
		
	}
	
	private void removeDocumento(HttpServletRequest req) {
		
			
		String salvarDocument = getServletContext().getRealPath("")  + File.separator +"documentos";
		
		
		DocumentDAO d = new DocumentDAO();
		
		Documento antigo;
		try {
			antigo = d.documento(Integer.valueOf(req.getParameter("codigo")));
			File pasta = new File(salvarDocument,antigo.getCaminho());
			
			if(d.delete(antigo)) {
			pasta.delete();
			
			ControllerUtil.sucessMessage(req, "documento escluido com sucesso !");
			
			}else
				ControllerUtil.errorMessage(req, "não foi possivel efetuar a exclusão do documento !");
			
			
		} catch (NumberFormatException | ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void preparaUpdate(HttpServletRequest req) {
		
		Documento doc=null;
		DocumentDAO docd = new DocumentDAO();
		
		try {
			doc = docd.documento(Integer.valueOf(req.getParameter("id")));
		} catch (NumberFormatException | ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("documento", doc);
		req.getSession().setAttribute("action", "update");
		
		
	}

	private boolean salva(HttpServletRequest req,HttpServletResponse res) {
		
		String pastaProjeto = getServletContext().getRealPath("");
		
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		
		String salvarDocument = pastaProjeto  + File.separator +"documentos";
		
		File pasta = new File(salvarDocument);
		
		if(!pasta.exists()){
			pasta.mkdirs();
		} 
		
		Documento doc = geraDocumento(req);
		doc.setCaminho(myRandom+".pdf");
		DocumentDAO docDao = new DocumentDAO();
		
		
		try {
			if(docDao.save(doc)) {
			Part arquivo;
			try {
				arquivo = req.getPart("documeto");
				arquivo.write(salvarDocument + File.separator + doc.getCaminho());
				
				return true;
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}  
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}
	
	private Documento geraDocumento(HttpServletRequest req) {
		Documento doc = new Documento();
		
		doc.setAutores(req.getParameter("autores"));
		doc.setCoOrientador(req.getParameter("co_orientador"));
		doc.setDataDefesa(req.getParameter("data_defesa"));
		doc.setOrientador(req.getParameter("orientador"));
		doc.setPalavrasChaves(req.getParameter("palavras_chaves"));
		doc.setResumo(req.getParameter("resumo"));
		doc.setSubTitulo(req.getParameter("sub_titulo"));
		doc.setTipo(Integer.valueOf(req.getParameter("tipo")));
		doc.setTitulo(req.getParameter("titulo"));
		doc.getGrandeArea().getArea().getAreaEspecifica().getSubArea().setCodigo(Integer.valueOf(req.getParameter("sub_area")));
		doc.setCodigo(Integer.valueOf(req.getParameter("codigo")));
		
		return doc;
		
	}
	
	private void adicionaBuscaToRequest(int index,HttpServletRequest req,String tipo,String busca) {
		
		DocumentDAO docs = new DocumentDAO();
		
		switch (tipo) {
	
		case "autor":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosAutor(index, busca));
				
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		
		case "titulo":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosTitulo(index, busca));
				
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "sub_titulo":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosSubTitulo(index, busca));
				
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "orientadores":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosOrientadores(index, busca));
				
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "avancada":
			
			try {
				
				Documento d = (Documento)req.getSession().getAttribute("buscar");
				
				req.getSession().setAttribute("documentos",docs.buscaAvancada(d, index));
				
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		default:
			
			
			break;
		}

		
	
	}
	
private void BuscaToRequest(int index,HttpServletRequest req,String tipo,String busca) {
		
		DocumentDAO docs = new DocumentDAO();
		
		switch (tipo) {
	
		case "autor":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosAutor(index, busca));
			
					preparaPaginacao(req, docs);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "titulo":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosTitulo(index, busca));
				preparaPaginacao(req, docs);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "sub_titulo":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosSubTitulo(index, busca));
				preparaPaginacao(req, docs);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "orientadores":
			
			try {
				
				req.getSession().setAttribute("documentos",docs.documentosOrientadores(index, busca));
				preparaPaginacao(req, docs);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "avancada":
			
			try {
				
				Documento d = geraDocumento(req);
				
				req.getSession().setAttribute("documentos",docs.buscaAvancada(d, index));
				preparaPaginacaoAvancada(req, docs, d);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;


		default:
			
			
			break;
		}

		
	
	}
	
	private void proximo(HttpServletRequest req) {
		
		
		int index = (int)req.getSession().getAttribute("paginaAtual");
		
		if(!((String)req.getSession().getAttribute("tipo_busca")).equalsIgnoreCase("avancada"))
			adicionaBuscaToRequest(index * 15,req,(String)req.getSession().getAttribute("tipo_busca"),(String)req.getSession().getAttribute("buscar"));
		else
			adicionaBuscaToRequest(index * 15,req,(String)req.getSession().getAttribute("tipo_busca"),(String)req.getSession().getAttribute("buscar"));
		
		req.getSession().setAttribute("paginaAtual",index+1);
	}
	
	private void anterior(HttpServletRequest req) {
		
		int index = (int)req.getSession().getAttribute("paginaAtual");
		
		if(!((String)req.getSession().getAttribute("tipo_busca")).equalsIgnoreCase("avancada"))
		adicionaBuscaToRequest((index-2) * 15,req,(String)req.getSession().getAttribute("tipo_busca"),(String)req.getSession().getAttribute("buscar"));
		else
		adicionaBuscaToRequest((index-2) * 15,req,(String)req.getSession().getAttribute("tipo_busca"),(String)req.getSession().getAttribute("buscar"));
		
		req.getSession().setAttribute("paginaAtual",index-1);
	}
	
	private void pagina(HttpServletRequest req) {
		
		int index = Integer.valueOf(req.getParameter("pagina"));
		
		if(!((String)req.getSession().getAttribute("tipo_busca")).equalsIgnoreCase("avancada"))
		adicionaBuscaToRequest((index-1) * 15,req,(String)req.getSession().getAttribute("tipo_busca"),(String)req.getSession().getAttribute("buscar"));
		else
		adicionaBuscaToRequest((index-1) * 15,req,(String)req.getSession().getAttribute("tipo_busca"),"");

		req.getSession().setAttribute("paginaAtual",index);
	}
	
	private void preparaPaginacao(HttpServletRequest req,DocumentDAO d) {
		
		
		if(d.getNumeroRegistros()%15==0)
			req.getSession().setAttribute("paginas",d.getNumeroRegistros()/15);
		else
			req.getSession().setAttribute("paginas",d.getNumeroRegistros()/15+1);
		
		req.getSession().setAttribute("resultados",d.getNumeroRegistros());
		req.getSession().setAttribute("paginaAtual",1);
		req.getSession().setAttribute("tipo_busca",req.getParameter("tipo_busca"));
		req.getSession().setAttribute("buscar",req.getParameter("busca"));

		
	
	}
	
private void preparaPaginacaoAvancada(HttpServletRequest req,DocumentDAO d,Documento dd) {
		
		
		if(d.getNumeroRegistros()%15==0)
			req.getSession().setAttribute("paginas",d.getNumeroRegistros()/15);
		else
			req.getSession().setAttribute("paginas",d.getNumeroRegistros()/15+1);
		
		req.getSession().setAttribute("resultados",d.getNumeroRegistros());
		req.getSession().setAttribute("paginaAtual",1);
		req.getSession().setAttribute("tipo_busca",req.getParameter("tipo_busca"));
		req.getSession().setAttribute("buscar",dd);
		

	}
	
	private void removePaginacao(HttpServletRequest req) {
		
		
		req.getSession().removeAttribute("paginas");
		req.getSession().removeAttribute("resultados");
		req.getSession().removeAttribute("paginaAtual");
		req.getSession().removeAttribute("tipo_busca");
		req.getSession().removeAttribute("buscar");
	
		
		}
		
	
	

}
