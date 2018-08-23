<%@include file="WEB-INF/cabecalho.jsp"%>

<style>
.fot{

margin-top: 16%;
padding-bottom: 2.5rem;

}
</style>


<div 
			style="${not empty autorizacao ? 'display: block;' : 'display: none;'}"
			class="container conteudo">
			<div class="row">
			<h4 class="titulo1 col-12">Alteracao de senha</h4><br>
			<form class="form-inline" method="post"
							action="${pageContext.request.contextPath}/user/${action}">
							<div class="input-group">
							<input hidden name="c08cbbfd6eefc83ac6d23c4c791277e4" value="272e81b5ac0e7c334b01b5ea9567e44c">
						<input type="password"
									placeholder="Senha" class="form-control" name="senha" id="senha" required
									maxlength="20">
								<input type="password"
									placeholder="digite a senha novamente" class="form-control" name="senha2" id="senha2" required oninput="validaSenha(this)"
									maxlength="20">
							</div>
							<button type="submit" class="btn btn-outline-success ml-1">Confirmar senha</button>
							
			</form>
			
			
			</div>
			
 </div>


<div style="${empty autorizacao ? 'display: block;' : 'display: none;'}"
			class="container conteudo">
			<div class="row">
			<h4 class="titulo1 col-12">Solicitar alteração de senha</h4><br>
			<form class="form-inline" method="post"
							action="${pageContext.request.contextPath}/user/alteraSenha">
							<div class="input-group">
							<input hidden name="c08cbbfd6eefc83ac6d23c4c791277e4" value="272e81b5ac0e7c334b01b5ea9567e44c">
						<input type="email"
									placeholder="Email" class="form-control" name="f8032d5cae3de20fcec887f395ec9a6a" id="email" required
									maxlength="150">
								
							</div>
							<button type="submit" class="btn btn-outline-success ml-1">Enviar</button>
							
			</form>
			
			
			</div>
			
 </div>



<%@include file="WEB-INF/modal.jsp"%>
<%@include file="WEB-INF/rodape.jsp"%>