
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
          // fecha o alert após 3 segundos
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
      });
     
      
$('#ga').change(function(){
	
	let xhr = new XMLHttpRequest();
    xhr.open('GET', "/sbma/ac?id="+$(this).val(), true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status = 200){
            	$("#ac").empty();
            	$("#ac").append(xhr.responseText);
            }
        }
    }
    xhr.send(); 		
	
}); 

$('#ac').change(function(){
	
	let xhr = new XMLHttpRequest();
    xhr.open('GET', "/sbma/ae?id="+$(this).val(), true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status = 200){
            	$("#ae").empty();
            	$("#ae").append(xhr.responseText);
            }
        }
    }
    xhr.send(); 		
	
}); 

	$('#ae').change(function(){
	
	let xhr = new XMLHttpRequest();
    xhr.open('GET', "/sbma/sa?id="+$(this).val(), true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status = 200){
            	$("#sa").empty();
            	if(xhr.responseText=="nada"){
            		$('#sa').attr("disabled","");
            		$("#sa").append('<option selected value="'+$('#ae').val()+'">Não possui sub-Area</option>');
            	
            	}else
            		$('#sa').removeAttr("disabled","");
            		$("#sa").append(xhr.responseText);
            	
            }
        }
    }
    xhr.send(); 		
	
}); 

       
    </script>

</body>
</head>
</html>