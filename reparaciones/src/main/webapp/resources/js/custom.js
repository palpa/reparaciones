$.fn.altaCliente = function() {	
	$(this).fadeIn([400],'done',function(){
		$(this).fadeOut();
	});	
};

function modalElimiarCliente(nombre,apellido, idCliente){
	
	$('#S_NombreCliente').html(nombre + " " + apellido );
	$('#myModal').modal();
	$('#I_eliminarCliente').val(idCliente);
}


function modalEditarCliente(idclient){	
	
	$.ajax({url:"/reparaciones/api/client/"+idclient,dataType: "json",success:function(result){		
		$('#S_ME_NClient').html(result.name + " " + result.surName);
		$('#I_ME_Name').val(result.name);
		$('#I_ME_Surname').val(result.surName);
		$('#I_ME_Adress').val(result.adress);
		$('#I_ME_Dni').val(result.dni);
		$('#I_ME_Phone').val(result.phone);
		$('#I_ME_Cel').val(result.cel);
		$('#I_Email').val(result.email);    
		$('#I_ME_Id').val(result.id);
	    }});
	
	
	
	$('#editUserModal').modal();
}


//TODO: Hay que optimizar esto.
$('#addCliente').submit(function() {
	$('#D_Error').html("");
	validation = true;
	
	//Realizamos las validaciones
	
	$('#D_Nombre').removeClass('has-error');
	if(($('#I_Nombre').val()) == "") {
		$('#D_Nombre').addClass('has-error');
		validation = false;	
	}
	
	$('#D_Apellido').removeClass('has-error');
	if(($('#I_Apellido').val()) == "") {
		$('#D_Apellido').addClass('has-error');
		validation = false;	
	}
	
	$('#D_Direccion').removeClass('has-error');
	if(($('#I_Direccion').val()) == "") {
		$('#D_Direccion').addClass('has-error');
		validation = false;
	}
	
	//TODO: hay que validar la longitud del dni y que no se puedan meter letras, hacerlo tambien desde el bckend.
	$('#D_DNI').removeClass('has-error');
	if(($('#I_DNI').val()) == "") {
		$('#D_DNI').addClass('has-error');
		validation = false;	
	}
	
	//Verificamos si hay error
	if (validation == false){
		$('#D_Error').html('<div class="alert alert-danger text-center">Complete los campos obligatorios</div>');
		return false;
	}
	else{
		$("#D_Menssage").altaCliente();
		return true;
	}	
});