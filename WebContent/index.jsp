<%@page import="br.edu.ifsuldeminas.mch.model.Usuario"%>

<%@include file="WEB-INF/cabecalho.jsp"%>

<article class="fundo1 row text-center">
			<h1 class="titulo3 col-12 text-light">Sistema de Busca do IFSULDEMINAS campus Machado - MG</h1>
		</article>
		<nav class="row pt-3 bg-dark navbar-dark">
			<div class="form-group col-12 text-center">
				<h2 class="titulo2 text-light">Pesquise por Autores, títulos, datas.</h2>
			</div>
			<div class="form-group justify-content-center ml-auto mr-auto">
				<form class="form-inline" action="list.html">
					<input class="form-control mr-sm-2" type="text" placeholder="Pesquisar" maxlength="150">
					<button class="btn btn-success form-control" type="submit">Search</button>
				</form>
			</div>
		</nav>

<%@include file="WEB-INF/rodape.jsp"%>