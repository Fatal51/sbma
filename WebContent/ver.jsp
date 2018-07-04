

<%@include file="WEB-INF/cabecalho.jsp"%>

<div id="alert"
			style="${not empty message ? 'display: block;' : 'display: none;'}"
			class="alert alert-dismissable ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			${message}
			<%request.getSession().removeAttribute("message");
			  request.removeAttribute("message");%>
 </div>

<iframe src="${pageContext.request.contextPath}/documentos/${doc}" width="600" height="780" style="border: none;"></iframe>


<%@include file="WEB-INF/modal.jsp"%>
<%@include file="WEB-INF/rodape.jsp"%>