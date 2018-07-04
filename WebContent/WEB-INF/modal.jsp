
	<div class="modal fade" id="modalDocumento">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="titulo1 text-dark">Cadastro de Documento</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <form action="${pageContext.request.contextPath}/document/save" method="post" enctype="multipart/form-data">
		<div class="container conteudo">
			<div class="form-group">
				<div class="row justify-content-around">

					<div class="col-md-6 my-1">
						<label for="autor">Autor</label>
						<input class="form-control" type="text" name="autores" id="autor">
					</div>

					<div class="col-md-6  my-1">
						<label for="orientador">Orientador</label>
						<input class="form-control" type="text" name="orientador" id="orientador">
					</div>
					
					<div class="col-md-6  my-1">
						<label for="co_orientador">Co-orientador</label>
						<input class="form-control" type="text" name="co_orientador" id="co_orientador">
					</div>

					<div class="col-md-6  my-1">
						<label for="titulo">Titulo</label>
						<input class="form-control" type="text" name="titulo" id="titulo">
					</div>

					<div class="col-md-9  my-1">
						<label for="sub">Subtitulo</label>
						<input class="form-control" type="text" name="sub_titulo" id="sub">
					</div>

					<div class="col-md-3  my-1">
						<label for="">Data defesa/publicação</label>
						<input class="form-control" type="date" name="data_defesa" id="data_cadastro" value="2018-01-01">
					</div>

					<div class="col-md-9  my-1">
						<label for="palavras_chaves">Palavras chaves</label>
						<input class="form-control" type="text" name="palavras_chaves" id="palavras_chaves">
					</div>
					
					<div class="col-md-3  my-1">
						<label for="tipo">Tipo de documento</label>
						<select class="form-control " name="tipo" id="tipo">
							<option value="1">Tcc</option>
							<option>DiscertaÃ§Ã£o</option>
							<option>Tese</option>
							<option>Artigo</option>
						</select>
					</div>
					<div class="col-md-6  my-1">
						<label for="grande_area">Grande Area</label>
						<select class="form-control" name="grande_area">

						</select>
					</div>
					
					<div class="col-md-6  my-1">
						<label for="area_conhecimento">Area conhecimento</label>
						<select class="form-control " name="area_conhecimento" id="area_conhecimento">

						</select>
					</div>
					

					<div class="col-md-6 my-1">
						<label for="area_especifica">Area especifica</label>
						<select class="form-control" name="area_especifica" id="area_especifica">

						</select>
					</div>


					<div class="col-md-6 my-1">
						<label for="sub_area">Sub-area</label>
						<select class="form-control " name="sub_area" id="sub_area">
							<option value="1">Teste</option>
						</select>
					</div>
					
					<div class="col-md-6 my-1">
						<label for="file">Documento .pdf</label>
						<input type="file" id="file" name="documeto" class="form-control" accept=".pdf" > 
					</div>

					<div class="col-md-12 my-1">
						<label for="resumo">Resumo</label>
						<textarea class="form-control" id="redumo" name="resumo"></textarea>
					</div>
				</div>
			</div>
			<input type="submit" value="Salvar" class="btn btn-success btn-sm col-md-2 form-control">
			<input type="reset" value="Limpar" class="btn btn-danger btn-sm col-md-2 form-control">
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