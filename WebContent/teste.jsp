<%@include file="WEB-INF/cabecalho.jsp"%>

<style>
.fot{

margin-top: 2%;
padding-bottom: 2.5rem;

}
</style>

<div class="container" >

<div class="row justify-content-around" >



<select id="1" required>
<option disabled selected></option>
<option value="1" >1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>

</select>



<select  id="2">
<option disabled selected></option>
</select>



<select id="3">

<option disabled selected></option>


</select>




</div>


</div>

<script>



    $('#1').change(function(){
    	
    	if($('#1').val()==1)
    		funcao1();
    	else
    		$("#2").empty();
    	
    }); 
    
 	$('#2').change(function(){
    	
    	if($('#2').val()==2)
    		funcao2();
    	else
    		$("#2").empty();
    	
    }); 
    
    function funcao1(){
    	
    	$("#2").append('<option value="2">aaaaaa</option>');
    	
    	
    };
    
function funcao2(){
    	
    	$("#3").append('<option value="2">aaaaaa</option>');
    	
    	
    };


</script>

	<%@include file="WEB-INF/modal.jsp"%>
