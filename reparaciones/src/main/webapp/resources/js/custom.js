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