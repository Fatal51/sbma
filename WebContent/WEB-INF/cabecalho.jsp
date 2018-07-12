<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>


<meta charset="utf-8">
<title>SisBF - Sistema de Busca IFSULDEMINAS campus Machado - MG
</title>

<meta name="viewport" content="whidth=device-whidth, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilo.css">


<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/popper.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

</head>
<body>
	<div id="interface" class="container-fluid">
		<nav id="menu" class="navbar navbar-expand-xl row">

			<header>
				<a href="${pageContext.request.contextPath}"
					class="navbar-brand titulo1">SisBF</a>
				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#menubar">
					<span class="fa fa-bars"></span>
				</button>
			</header>

			<div id="menubar" class="navbar-collapse collapse ">
				<ul
					class="navbar-nav nav mx-xl-5 px-xl-5 mx-0 px-0 bareffect justify-content-center">
					<li class="position-relative"><a href="#"
						class="nav-link px-2 mx-2 menulink text-uppercase">ifsuldeminas</a></li>
					<li class="position-relative"><a href="#"
						class="nav-link px-2 mx-2 menulink">Sobre</a></li>

					<c:if test="${empty usu }">
						<li class="position-relative"><a href="#"
							class="nav-link px-2 mx-2 menulink" data-toggle="modal"
							data-target="#cadastroUsuario">Cadastre-se</a></li>
					</c:if>

					<c:if test="${usu.isAdm()}">
						<li class="position-relative"><a href="#"
							class="nav-link px-2 mx-2 menulink" data-toggle="modal"
							data-target="#cadastroAdm">Cadastro de Adm</a></li>
					</c:if>
					<li class="position-relative"><a href="#" data-toggle="modal"
						data-target="#avancada"
						class="nav-link px-2 mx-2 menulink text-uppercase ">Busca
							Avancada</a></li>

					<c:if test="${usu.isAdm()}">

						<li class="nav-item position-relative float-left"><a
							href="${pageContext.request.contextPath}/document/form"
							class="  nav-link nav-link px-2 mx-2 menulink text-uppercase ">Cadastrar
								Documento</a></li>

					</c:if>
					<c:if test="${empty usu}">

						<li class="position-relative"><a href="#" data-toggle="modal"
							data-target="#login"
							class="nav-link px-2 mx-2 menulink text-uppercase ">Login</a></li>

					</c:if>

					<c:if test="${not empty usu}">

						<li class="nav-item position-relative float-left"><a
							href="${pageContext.request.contextPath}/user/logof"
							class="  nav-link nav-link px-2 mx-2 menulink text-uppercase ">${usu.getLogin()}</a></li>

					</c:if>

				</ul>
			</div>

		</nav>
		