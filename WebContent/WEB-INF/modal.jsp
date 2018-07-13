
<div class="modal fade" id="cadastroUsuario">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="titulo1 text-center">Cadastro de Usuario</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/user/insert"
					method="post" onsubmit="validarSenha()">
					<div class="container mt-2">
						<div class="form-group">
							<div class="row justify-content-around">
						<input hidden value="0" name="tipo_user" >
								<div class="col-md-6 my-1">
									<label for="nome">Nome completo</label> <input
										class="form-control" type="text" name="nome" id="nome" required
										maxlength="150" minlength="10">
								</div>

								<div class="col-md-6  my-1">
									<label for="senha">senha</label> <input class="form-control"
										type="password" name="senha" id="senha" required
										maxlength="20">
								</div>

								<div class="col-md-6  my-1">
									<label for="senha2">repita senha</label> <input
										class="form-control" type="password" name="senha2" id="senha2" required oninput="validaSenha(this)"
										maxlength="20">
								</div>

								<div class="col-md-6  my-1">
									<label for="email">E-mail</label> <input class="form-control"
										type="email" name="email" id="email" required
										 maxlength="150">
								</div>
							</div>
						</div>
						<input type="submit" value="Salvar"
							class="btn btn-success btn-sm col-md-2 form-control"> <input
							type="reset" value="Limpar"
							class="btn btn-danger btn-sm col-md-2 form-control">
					</div>
				</form>

			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>




<div class="modal fade" id="avancada">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header text-center">
				<h4 class="titulo1 ">Busca Avancada</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/document/buscar"
					method="get">
					<input  hidden value="avancada" name="tipo_busca" >
					<input  hidden value="0" name="codigo" >
					<div class="container">
						<div class="form-group">
							<div class="row justify-content-around">

								<div class="col-md-6 my-1">
									<label for="autor">Autor</label> <input class="form-control"
										type="text" name="autores"
										id="autor">
								</div>

								<div class="col-md-6  my-1">
									<label for="orientador">Orientador</label> <input
										class="form-control" type="text" name="orientador"
										id="orientador">
								</div>

								<div class="col-md-6  my-1">
									<label for="co_orientador">Co-orientador</label> <input
										class="form-control" type="text" name="co_orientador"
										id="co_orientador">
								</div>

								<div class="col-md-6  my-1">
									<label for="titulo">Titulo</label> <input class="form-control"
										type="text" name="titulo" id="titulo">
								</div>

								<div class="col-md-8  my-1">
									<label for="sub">Subtitulo</label> <input class="form-control"
										type="text" name="sub_titulo" id="sub">
								</div>

								<div class="col-md-4  my-1">
									<label for="">Data defesa/publicação</label> <input
										class="form-control" type="date" name="data_defesa"
										id="data_cadastro" value="Date(0)">
								</div>

								<div class="col-md-9  my-1">
									<label for="palavras_chaves">Palavras chaves</label> <input
										class="form-control" type="text" name="palavras_chaves"
										id="palavras_chaves">
								</div>

								<div class="col-md-3  my-1">
									<label for="tipo">Tipo de documento</label> <select
										class="form-control " name="tipo" id="tipo">
										<option value="1">Tcc</option>
										<option value="2">Discertações</option>
										<option value="3">Tese</option>
										<option value="4">Artigo</option>
									</select>
								</div>
								<div class="col-md-6  my-1">
									<label for="grande_area"  >Grande Area</label> <select
										class="form-control"  name="grande_area">

									</select>
								</div>

								<div class="col-md-6  my-1">
									<label for="area_conhecimento">Area conhecimento</label> <select
										class="form-control "   name="area_conhecimento"
										id="area_conhecimento">

									</select>
								</div>


								<div class="col-md-6 my-1">
									<label for="area_especifica">Area especifica</label> <select
										class="form-control"  name="area_especifica"
										id="area_especifica">

									</select>
								</div>


								<div class="col-md-6 my-1">
									<label for="sub_area">Sub-area</label> <select
										class="form-control " name="sub_area" id="sub_area">
										<option value="1">Teste</option>
									</select>
								</div>

								<div class="col-md-12 my-1">
									<label for="resumo">Resumo</label>
									<textarea class="form-control" id="redumo" name="resumo"></textarea>
								</div>
							</div>
						</div>
						<input type="submit" value="Buscar"
							class="btn btn-success btn-sm col-md-2 form-control"> <input
							type="reset" value="Limpar"
							class="btn btn-danger btn-sm col-md-2 form-control">
					</div>
				</form>

			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>


<div class="modal fade" id="cadastroAdm">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="titulo1 ">Cadastro de Adiministrador</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/user/insert"
					method="post" >
					<div class="container mt-2">
						<div class="form-group">
							<div class="row justify-content-around">
						<input hidden value="0" name="tipo_user" >
								<div class="col-md-6 my-1">
									<label for="nome">Nome completo</label> <input
										class="form-control" type="text" name="nome" id="nome" required
										maxlength="150" minlength="10">
								</div>

								<div class="col-md-6  my-1">
									<label for="senha">senha</label> <input class="form-control"
										type="password" name="senha" id="senhaa" required
										maxlength="20">
								</div>

								<div class="col-md-6  my-1">
									<label for="senha2">repita a senha</label> <input
										class="form-control" type="password" name="senha2" id="senhaa2"
										oninput="validaSenhaA(this)" required
										maxlength="20">
								</div>

								<div class="col-md-6  my-1">
									<label for="email">E-mail</label> <input class="form-control"
										type="email" name="email" id="email" required
										maxlength="150">
								</div>
							</div>
						</div>
						<input type="submit" value="Salvar"
							class="btn btn-success btn-sm col-md-2 form-control"> <input
							type="reset" value="Limpar"
							class="btn btn-danger btn-sm col-md-2 form-control">
					</div>
				</form>

			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>


<div class="modal fade" id="login">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="titulo1">Login</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<div class="container">
					<div class="form-group">
						<form class="form-inline" method="post"
							action="${pageContext.request.contextPath}/user/validation">
							<div class="input-group">
								<input type="text" placeholder="Login" class="form-control"
									name="login" maxlength="40"> <input type="password"
									placeholder="Senha" class="form-control" name="senha"
									maxlength="20">
							</div>
							<button type="submit" class="btn btn-outline-success ml-1">Login</button>
							<a href="${pageContext.request.contextPath}/alteraSenha.jsp" class="btn btn-warning ml-1">Esqueci a senha</a>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>




<div class="modal" id="deletaDocumento">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <span id="menssagem"></span> ?<br>
        <span id="autor"></span>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
          <a id="deleta" href=""class="btn btn-success">Confirmar</a>
        </div>
        
      </div>
    </div>
  </div>
  
  