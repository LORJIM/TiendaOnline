

	function reiniciarFormulario(){
	document.registro.usuario.value = "";
	document.registro.password.value = "";
	document.registro.password2.value = "";
	document.registro.email.value = "";
	}

	function validarCamposObligatorios(){
	 if (document.registro.usuario.value == ""){alert("Debe indicar su nombre de usuario");return false;}
	 if (document.registro.password.value == ""){alert("Debe indicar su contraseña");return false;}
	 if (document.registro.password2.value == ""){alert("Debe repetir su contraseña");return false;}
	 if (document.registro.email.value == ""){alert("Debe indicar su corre electrónico");return
	     false;}
	 return true;
	}


	function validarFormulario(){
	 if (validarCamposObligatorios()){
	    mensaje = "";
	    mensaje = mensaje + "Usuario: " + document.registro.usuario.value + "\n";
	    mensaje = mensaje + "Contraseña: " + document.registro.password.value + "\n";
	    mensaje = mensaje + "Confirmacion de contraseña: " + document.registro.password2.value + "\n";
	    mensaje = mensaje + "Email: " + document.registro.email.value + "\n";

	 alert(mensaje);
	 return true;
	 // lanzar una pagina
	 //window.open('https://es.wikipedia.org/wiki/Violadores_del_Verso', 'width=330,height=252,scrollbars=NO,statusbar=NO,left=500,top=250');
	 
	 } else {
	   alert("Ha fallado la validación de los datos en el formulario");
	   return false;
	 }
	}