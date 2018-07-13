<%@page import="br.edu.ifsuldeminas.mch.model.Usuario"%>

<%@include file="WEB-INF/cabecalho.jsp"%>

<style>
.fot{

margin-top: 15%;
padding-bottom: 2.5rem;

}
</style>

<div class="row justify-content-around mt-5">
<div id="alert"
			style="${not empty message ? 'display: block;' : 'display: none;'}"
			class="alert alert-dismissable col-5 ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			${message}
			<%request.getSession().removeAttribute("message");
			  request.removeAttribute("message");%>
 </div>
 </div>

<article class="fundo1 row text-center mt-5">
			<h1 class="titulo3 col-12 text-dark">Sistema de Busca do IFSULDEMINAS campus Machado - MG</h1>
		</article>
		<nav class="row pt-3 bg-dark fundo1">
			<div class="form-group col-12 text-center">
				
			</div>
			<div class="form-group form-inline justify-content-center ml-auto mr-auto pt-5">
				<form class="form-inline" method="get" action="${pageContext.request.contextPath}/document/buscar">
					<div class="form-group">
					  <label for="sel1">Pesquisar por: </label>
					  <select class="form-control ml-1 col-sm-6" id="sel1" name="tipo_busca">
					    <option value="autor">Autor</option>
					    <option value="titulo" selected>Titulo</option>
					    <option value="sub_titulo">Sub-titulo</option>
					    <option value="orientadores">Orientadores</option>
					    
					  </select>
					</div>
					<input class="form-control mr-sm-2" type="text" placeholder="Pesquisar" size="50" maxlength="150" name="busca">
					<button class="btn btn-success form-control" type="submit"><span class="fa fa-search "></span></button>
					<a href="#" data-toggle="modal"
						data-target="#avancada"
						class="btn btn-warning mx-1 ">Busca
							Avancada</a>
				</form>
			</div>
		</nav>
		
	
<%@include file="WEB-INF/modal.jsp"%>
<%@include file="WEB-INF/rodape.jsp"%>