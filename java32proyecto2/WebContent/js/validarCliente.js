function validarCliente(){
	var enviarForm = true;
	
	var nombre = document.getElementsByName("nombre")[0];
	var cnombre =nombre.value;

	var expresionCampoNombre=/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,10}$/i;
	if (expresionCampoNombre.test(cnombre)){
	}else{
		alert("nombre mal");
		enviarform = false;
	}
	
	
	var calle = document.getElementsByName("calle")[0];
	var ccalle =calle.value;

	var expresionCampoCalle=/^[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,20}$/i;
	if (expresionCampoCalle.test(ccalle)){
	}else{
		alert("calle mal");
		enviarform = false;
	}
	
	
	var numeracion = document.getElementsByName("numeracion")[0];
	var cnumeracion =numeracion.value;

	var expresionCampoNumeracion=/^[0-9]{1,11}$/;
	if (expresionCampoNumeracion.test(cnumeracion)){
	}else{
		alert("numeracion mal");
		enviarform = false;
	}
	
	
	var codigoPostal = document.getElementsByName("codigoPostal")[0];
	var ccodigoPostal =codigoPostal.value;

	var expresionCampoCodigoPostal=/^[0-9]{1,11}$/;
	if (expresionCampoCodigoPostal.test(ccodigoPostal)){
	}else{
		alert("codigo postal mal");
		enviarform = false;
	}
	
	
	var poblacion = document.getElementsByName("poblacion")[0];
	var cpoblacion =poblacion.value;

	var expresionCampoPoblacion=/^[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,20}$/i;
	if (expresionCampoPoblacion.test(cpoblacion)){
	}else{
		alert("poblacion mal");
		enviarform = false;
	}
	
	
	var telefono = document.getElementsByName("telefono")[0];
	var ctelefono =telefono.value;

	var expresionCampoTelefono=/^[0-9]{1,11}$/;
	if (expresionCampoTelefono.test(ctelefono)){
	}else{
		alert("telefono mal");
		enviarform = false;
	}
	
	
	var email = document.getElementsByName("email")[0];
	var cemail =email.value;

	var expresionCampoEmail=/^[^@]+@[^@]+\.[a-zA-Z]{2,}/i;
	if (expresionCampoEmail.test(cemail)){
	}else{
		alert("email mal");
		enviarform = false;
	}
	
	
	var particularOEmpresa = document.getElementsByName("particularOEmpresa")[0];
	var cparticularOEmpresa =particularOEmpresa.value;

	var expresionCampoParticularOEmpresa=/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,10}$/i;
	if (expresionCampoParticularOEmpresa.test(cparticularOEmpresa)){
	}else{
		alert("particular o empresa mal");
		enviarform = false;
	}
	
	return enviarForm;
}