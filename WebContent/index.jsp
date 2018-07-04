<%@page import="br.edu.ifsuldeminas.mch.model.Usuario"%>

<%@include file="WEB-INF/cabecalho.jsp"%>

<div id="alert"
			style="${not empty message ? 'display: block;' : 'display: none;'}"
			class="alert alert-dismissable ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			${message}
			<%request.getSession().removeAttribute("message");
			  request.removeAttribute("message");%>
 </div>

<article class="fundo1 row text-center">
			<h1 class="titulo3 col-12 text-light">Sistema de Busca do IFSULDEMINAS campus Machado - MG</h1>
		</article>
		<nav class="row pt-3 bg-dark navbar-dark">
			<div class="form-group col-12 text-center">
				<h2 class="titulo2 text-light">Pesquise por Autores, títulos, datas.</h2>
			</div>
			<div class="form-group justify-content-center ml-auto mr-auto">
				<form class="form-inline" method="get" action="${pageContext.request.contextPath}/document/buscar">
					<div class="form-group">
					  <label for="sel1">Select list:</label>
					  <select class="form-control" id="sel1" name="tipo_busca">
					    <option value="autor">Autor</option>
					  </select>
					</div>
					<input class="form-control mr-sm-2" type="text" placeholder="Pesquisar" maxlength="150" name="busca">
					<button class="btn btn-success form-control" type="submit">Search</button>
				</form>
			</div>
		</nav>
		
	
<%@include file="WEB-INF/modal.jsp"%>
<%@include file="WEB-INF/rodape.jsp"%>