
<%@include file="WEB-INF/cabecalho.jsp"%>

<style>
.fot{

margin-top: 2%;
padding-bottom: 2.5rem;

}
</style>

<div id="alert"
	style="${not empty message ? 'display: block;' : 'display: none;'}"
	class="alert alert-dismissable ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	${message}
	<%request.getSession().removeAttribute("message");
			  request.removeAttribute("message");%>
</div>

<h2 class="titulo2 row pt-2">Resultados: ${resultados}</h2>
<div class="row justify-content-around">

	<c:forEach var="t" items="${documentos}">
		<div class=" col-md-4 col-sm-6 mt-4">
				<div class="blocos rounded" style="background-color: #fff;">
					<h3 id="${t.getCodigo()}" class="col-sm-12">${t.getTitulo()}</h3>
					<p class="col-sm-12 text-justify">${t.getResumo().length() < 250 ? t.getResumo() : t.getResumo().substring(0,250).concat("...")} </p>
					<hr/>
					<p class="px-2">${t.referencia()}</p>
					<c:if test="${not empty usu}">
						<a target="_blanck" class="btn btn-success btn-block" href="${pageContext.request.contextPath}/documentos/${t.getCaminho()}">Ver</a>
					</c:if>
					<c:if test="${usu.isAdm()}">
						<a  class="btn btn-warning btn-block" href="${pageContext.request.contextPath}/document/update?id=${t.getCodigo()}">Auterar</a>
						<a  class="btn btn-danger btn-block modal-remove" codigo="${t.getCodigo()}" data-toggle="modal" 
            data-target="#deletaDocumento"  href="#">Remove</a>
					</c:if>
					<c:if test="${empty usu}">
						<a class="btn btn-danger btn-block" href="${pageContext.request.contextPath}/index.jsp#login">É necesario estar logado para visualizar o documento</a>
					</c:if>
				</div>
			</div>
	</c:forEach>
	
	
	
</div>
<c:if test="${paginas != 0 and paginas != null }">
		<ul class="pagination mt-5">
			<li class="page-item ${paginaAtual eq 1 ? 'disabled' :''}"><a class="page-link" href="${pageContext.request.contextPath}/document/anterior?tipo_busca=${tipo_busca}">Anterior</a></li>
		  <c:forEach var = "i" begin = "1" end = "${paginas}">
		 	 <li class="page-item ${paginaAtual eq i ? 'disabled' :''}"><a class="page-link" href="${pageContext.request.contextPath}/document/pagina?pagina=${i}">${i}</a></li>
		  </c:forEach>
			 <li class="page-item ${paginaAtual eq paginas  ?'disabled' :''}" ><a class="page-link" href="${pageContext.request.contextPath}/document/proximo?tipo_busca=${tipo_busca}">Proximo</a></li>
		</ul>
	</c:if>
	<%@include file="WEB-INF/modal.jsp"%>
	<%@include file="WEB-INF/rodape.jsp"%>