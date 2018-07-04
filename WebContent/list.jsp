
<%@include file="WEB-INF/cabecalho.jsp"%>

<div id="alert"
	style="${not empty message ? 'display: block;' : 'display: none;'}"
	class="alert alert-dismissable ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	${message}
	<%request.getSession().removeAttribute("message");
			  request.removeAttribute("message");%>
</div>

<h2 class="titulo2 row pt-2">Resultados: ${resultados} - p: ${paginaAtual}</h2>
<div class="row justify-content-around">

	<c:forEach var="t" items="${documentos}">
		<div class=" col-md-4 col-sm-6 mt-5">
				<div class="blocos rounded" style="background-color: #fff;">
					<h3 class="col-sm-12">${t.getTitulo()}</h3>
					<p class="col-sm-12 text-justify">${t.getResumo().substring(0,6)} ... ${t.getCodigo() }</p>
					<hr/>
					<p class="px-2">${t.getAutores()} - ${t.dataSerta()}</p>
					<c:if test="${not empty usu}">
						<a target="_blanck" class="btn btn-sucssess btn-block" href="${pageContext.request.contextPath}/documentos/${t.getCaminho()}">Ver</a>
					</c:if>
					<c:if test="${empty usu}">
						<a class="btn btn-danger btn-block" href="${pageContext.request.contextPath}/documentos/${t.getCaminho()}">É necesario estar logado para visualizar o documento</a>
					</c:if>
				</div>
			</div>
	</c:forEach>
	
	
	
</div>
<c:if test="${paginas != 0 and paginas != null }">
		<ul class="pagination">
			<li class="page-item ${paginaAtual eq 1 ? 'disabled' :''}"><a class="page-link" href="${pageContext.request.contextPath}/document/anterior?tipo_busca=${tipo_busca}">Previous</a></li>
		  <c:forEach var = "i" begin = "1" end = "${paginas}">
		 	 <li class="page-item"><a class="page-link" href="${i}">${i}</a></li>
		  </c:forEach>
			 <li class="page-item ${paginaAtual eq paginas  ?'disabled' :''}" ><a class="page-link" href="${pageContext.request.contextPath}/document/proximo?tipo_busca=${tipo_busca}">Previous</a></li>
		</ul>
	</c:if>
	<%@include file="WEB-INF/modal.jsp"%>
	<%@include file="WEB-INF/rodape.jsp"%>