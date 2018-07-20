<%@include file="WEB-INF/cabecalho.jsp"%>

<style>
.fot{

margin-top: 2%;
padding-bottom: 2.5rem;

}
</style>

<div class="container" >

<div class="row justify-content-around" >



<select id="ga">
<option disabled selected></option>
<option value="1" >1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>

</select>



<select  id="ac">
<option disabled selected></option>
</select>



<select id="ae">

<option disabled selected></option>


</select>


<select id="sa">

<option disabled selected></option>


</select>


</div>


</div>

<script>

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

	<%@include file="WEB-INF/modal.jsp"%>
<%@include file="WEB-INF/rodape.jsp"%>