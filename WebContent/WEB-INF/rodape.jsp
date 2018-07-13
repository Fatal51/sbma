
</div>

<footer id="rodape" class="container-fluid fot fundo2">
<div class="row justify-content-around ">

<div class="mt-5">
		<p class="text-center col-12">
			Matheus Alisson de Oliveira - &copy; IFSULDEMINAS <i>Campus</i>
			Machado-MG
		</p>
		<c:if test="${not empty usu}">
			<p class="text-center col-12"> Logado com ${usu.getLogin()} <a href="${pageContext.request.contextPath}/user/logof">(sair)</a></p>

		</c:if>
		</div>
</div>

</footer>


    <script type="text/javascript">
      $(document).ready(function() {
          // fecha o alert ap�s 3 segundos
          setTimeout(function() {
              $(".alert").slideUp(500);
          }, 5000);
         
      });
      
      function validaSenha (input){ 
    	    if (input.value != document.getElementById('senha').value) {
    	    input.setCustomValidity('Repita a senha corretamente');
    	    $("#senha, #senha2").addClass("border-danger");
    	  } else {
    	    input.setCustomValidity('');
    	    $("#senha, #senha2").removeClass("border-danger");
    	    $("#senha, #senha2").addClass("border-info");
    	  }
    	}
      
      function validaSenhaA(input){ 
  	    if (input.value != document.getElementById('senhaa').value) {
  	    input.setCustomValidity('Repita a senha corretamente');
  	    $("#senhaa, #senhaa2").addClass("border-danger");
  	  } else {
  	    input.setCustomValidity('');
  	    $("#senhaa, #senhaa2").removeClass("border-danger");
  	    $("#senhaa, #senhaa2").addClass("border-info");
  	  }
  	}
      $(".modal-remove").click(function () {
          
          var codigo = $(this).attr('codigo');
          var titulo = $("#"+codigo).text();
          
          $(".modal-body #menssagem").text("Deseja excluir o documento " + titulo);
           $(".modal-title").text("Deletar Documento");
          $("#deleta").attr( "href","${pageContext.request.contextPath}/document/remove?codigo="+codigo);
      })
     
       
    </script>

</body>
</head>
</html>