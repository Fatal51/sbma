<%@include file="WEB-INF/cabecalho.jsp"%>


<form action="${pageContext.request.contextPath}/document/${action}"
					method="post" enctype="multipart/form-data">
					<div class="container conteudo">
					
<h3 class="titulo1" >${not empty documento ? 'Alterar':'Cadastro de'} Documento</h3>
						<div class="form-group">
							<div class="row justify-content-around">
							<input hidden name="codigo" value="${not empty documento? documento.getCodigo() : 0}">
								<div class="col-md-6 my-1">
									<label for="autor">Autor</label> <input class="form-control"
										type="text" value="${documento.getAutores()}" name="autores" id="autor">
								</div>

								<div class="col-md-6  my-1">
									<label for="orientador">Orientador</label> <input
										class="form-control" type="text" name="orientador"
										id="orientador" value="${documento.getOrientador()}">
								</div>

								<div class="col-md-6  my-1">
									<label for="co_orientador">Co-orientador</label> <input
										class="form-control" type="text" name="co_orientador"
										id="co_orientador" value="${documento.getCoOrientador()}">
								</div>

								<div class="col-md-6  my-1">
									<label for="titulo">Titulo</label> <input class="form-control"
										type="text" name="titulo" id="titulo" value="${documento.getTitulo()}">
								</div>

								<div class="col-md-9  my-1">
									<label for="sub">Subtitulo</label> <input class="form-control"
										type="text" name="sub_titulo" value="${documento.getSubTitulo()}" id="sub">
								</div>

								<div class="col-md-3  my-1">
									<label for="">Data defesa/publicação</label> <input
										class="form-control" type="date" name="data_defesa"
										id="data_cadastro" value="${documento.getDataDefesa()}">
								</div>

								<div class="col-md-9  my-1">
									<label for="palavras_chaves">Palavras chaves</label> <input
										class="form-control" type="text" value="${documento.getPalavrasChaves()}" name="palavras_chaves"
										id="palavras_chaves">
								</div>

								<div class="col-md-3  my-1">
									<label for="tipo">Tipo de documento</label> <select
										class="form-control " name="tipo" id="tipo">
										<option value="1" ${documento.getTipo() eq 1? 'selected' : '' }>Tcc</option>
										<option value="2" ${documento.getTipo() eq 2? 'selected' : '' }>Discertação</option>
										<option value="3" ${documento.getTipo() eq 3? 'selected' : '' }>Tese</option>
										<option value="4" ${documento.getTipo() eq 4? 'selected' : '' }>Artigo</option>
									</select>
								</div>
								<div class="col-md-6  my-1">
									<label for="grande_area">Grande Area</label> <select
										class="form-control" name="grande_area">

									</select>
								</div>

								<div class="col-md-6  my-1">
									<label for="area_conhecimento">Area conhecimento</label> <select
										class="form-control " name="area_conhecimento"
										id="area_conhecimento">

									</select>
								</div>


								<div class="col-md-6 my-1">
									<label for="area_especifica">Area especifica</label> <select
										class="form-control" name="area_especifica"
										id="area_especifica">

									</select>
								</div>


								<div class="col-md-6 my-1">
									<label for="sub_area">Sub-area</label> <select
										class="form-control " name="sub_area" id="sub_area">
										<option value="1" value="1" ${documento.getSubArea() eq 1? 'selected' : '' }>Teste</option>
									</select>
								</div>

								<div class="col-md-6 my-1">
									<label for="file">Documento .pdf</label> <input type="file"
										id="file" name="documeto" class="form-control" accept=".pdf">
									<c:if test="${not empty documento}">
										<a class="btn btn-succsess" target="_blanc"
										 href="${pageContext.request.contextPath}/documentos/${documento.getCaminho()}" >
									Ver Documento atual</a>
									</c:if>
								</div>

								<div class="col-md-12 my-1">
									<label for="resumo">Resumo</label>
									<textarea class="form-control" id="redumo" name="resumo">${documento.getResumo()} </textarea>
								</div>
							</div>
						</div>
						<input type="submit" value="${not empty documento ? 'alterar':'salvar'}"
							class="btn btn-success btn-sm col-md-2 form-control"> 
							<a type="${not empty documento ? '':'rest'}" href="${not empty documento ? '/sbma/document/cancelar':'#'}"
							class="btn btn-danger btn-sm col-md-2 form-control">${not empty documento ? 'Cancelar':'limpar'}</a>
					</div>
				</form>
				
<%@include file="WEB-INF/rodape.jsp"%>