
</div>

<footer id="rodape" class="container-fluid ">

	<section class="text-center">

		<p class="text-center">
			Matheus Alisson de Oliveira - &copy; IFSULDEMINAS <i>Campus</i>
			Machado-MG
		</p>

	</section>
</footer>


    <script type="text/javascript">
      $(document).ready(function() {
          // fecha o alert após 3 segundos
          setTimeout(function() {
              $(".alert").slideUp(500);
          }, 2000);
         
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
     
       
    </script>

</body>
</head>
</html>