/*INI script de login*/
$(document).ready(function() {
	$('#LogIn').click(function() {
		var user = $("#user").val();
		var pass = $("#pass").val();
		var data = {
			"usuario": user,
			"password": pass
		}

		$.ajax({
			type: 'POST',
			url: 'http://localhost:8084/APIEnSusManos/v1/autenticacion/?usuario=' + user + '&password=' + pass,
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType: 'json',
			success: function(data) {
				if (data.length > 0) {
					$('.greeting-nombre').append(data[0].nombre);
					window.location.href = "../html/inicio.html";
				} else {
					$("#error").html("<span style='color:#cc0000'>Error:</span> Usuario y Contraseña Errados. ");
					$("#user").val('');
					$("#pass").val('');
				}

			},
		}).then(function(data) {
			if (data.length > 0) {
				$('.greeting-nombre').append(data[0].nombre);
				window.location.href = "../html/inicio.html";
			} else {
				$("#error").html("<span style='color:#cc0000'>Error:</span> Usuario y Contraseña Errados. ");
				$("#user").val('');
				$("#pass").val('');

			}
		});
		return false;
	});
});
/*FIN script de login*/


/*INI script de Logout*/
window.history.forward();
function noBack() { 
	window.history.forward(); 
	$('#id_Desconexion').attr('action', '../html/Login.html');
}
/*FIN script de Logout*/


/*INI script Listado Eventos*/
function listadoEventos() {
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8084/APIEnSusManos/v1/eventos/'

	}).then(function(data) {
		for (var i = 0; i < data.length; i++) {
			var nuevafila = "<tr><td>" +
				data[i].id_eventos + "</td><td>" +
				data[i].nombre + "</td><td>" +
				data[i].descripcion + "</td><td>" +
				data[i].fecha + "</td><td>" +
				data[i].hora + "</td><td>";
			$("#tabla_eventos").append(nuevafila);
		}
	});
}
/*FIN script Listado Eventos*/


/*INI script Listado Ciudadanos*/
function listadoCiudadanos() {
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8084/APIEnSusManos/v1/usuarios/'
	}).then(function(data) {
		for (var i = 0; i < data.length; i++) {
			var nuevafilaCiudadano = "<tr><td>" +
				data[i].id_usuarios + "</td><td>" +
				data[i].nombre + "</td><td>" +
				data[i].apellido + "</td><td>" +
				data[i].barrio + "</td><td>";
			$("#tabla_ciudadanos").append(nuevafilaCiudadano);
		}
	});
}
/*FIN script Listado Ciudadanos*/

/*INI script Listado Puntos*/
function listadoPuntos() {
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8084/APIEnSusManos/v1/puntos/'
	}).then(function(data) {
		for (var i = 0; i < data.length; i++) {
			var nuevafilaPuntos = "<tr><td>" +
				data[i].id_puntos + "</td><td>" +
				data[i].descripcion + "</td><td>" +
				data[i].usuarios + "</td><td>" +
				data[i].eventos + "</td><td>";
			$("#tabla_puntos").append(nuevafilaPuntos);
		}
	});
}
/*FIN script Listado Puntos*/


/*INI script ID Eventos*/
$(document).ready(function() {
	$('#buscarEvento').click(function() {
		var busquedaEventoId = $("#busquedaEvento").val();
		
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8084/APIEnSusManos/v1/eventos/'+busquedaEventoId
		
		}).then(function(data) {
			if(data.length == undefined){
				$("#tabla_eventos tbody tr").remove();
				var nuevafila = "<tr><td>" +
				data.id_eventos + "</td><td>" +
				data.nombre + "</td><td>" +
				data.descripcion + "</td><td>" +
				data.fecha + "</td><td>" +
				data.hora + "</td><td>";
				$("#tabla_eventos").append(nuevafila);
			}else{
				$("#tabla_eventos tbody tr").remove();
				for (var i = 0; i < data.length; i++) {
				var nuevafila = "<tr><td>" +
					data[i].id_eventos + "</td><td>" +
					data[i].nombre + "</td><td>" +
					data[i].descripcion + "</td><td>" +
					data[i].fecha + "</td><td>" +
					data[i].hora + "</td><td>";
				$("#tabla_eventos").append(nuevafila);
				}
			}
		});
		return false;
	});
});
/*$(document).ready(function() {
	var busqueda = $("#busquedaEvento").val();

	$("#busquedaEvento").keyup(function() {
			_this = this;
			$.each($("#tabla_eventos tbody tr"), function() {
				if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
					$(this).hide();
				else
					$(this).show();
			});
		});
});*/

/*FIN script ID Eventos*/


/*INI script ID Ciudadanos*/
$(document).ready(function() {
	$('#buscarCiudadano').click(function() {
		var busquedaCiudadanoId = $("#busquedaCiudadano").val();
		
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8084/APIEnSusManos/v1/usuarios/'+busquedaCiudadanoId
		
		}).then(function(data) {
			if(data.length == undefined){
				$("#tabla_ciudadanos tbody tr").remove();
				var nuevafilaCiudadano = "<tr><td>" +
					data.id_usuarios + "</td><td>" +
					data.nombre + "</td><td>" +
					data.apellido + "</td><td>" +
					data.barrio + "</td><td>";
				$("#tabla_ciudadanos").append(nuevafilaCiudadano);
			}else{
				$("#tabla_ciudadanos tbody tr").remove();
				for (var i = 0; i < data.length; i++) {
					var nuevafilaCiudadano = "<tr><td>" +
						data[i].id_usuarios + "</td><td>" +
						data[i].nombre + "</td><td>" +
						data[i].apellido + "</td><td>" +
						data[i].barrio + "</td><td>";
					$("#tabla_ciudadanos").append(nuevafilaCiudadano);
				}
			}
		});
		return false;
	});
});
/*$(document).ready(function() {
	$("#busqueda_ciudadano").keyup(function() {
		_this = this;
		$.each($("#tabla_ciudadanos tbody tr"), function() {
			if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
				$(this).hide();
			else
				$(this).show();
		});
	});
});*/
/*FIN script ID Ciudadanos*/

/*INI script ID Puntos*/
$(document).ready(function() {
	$('#buscarPuntos').click(function() {
		var busquedaPuntosId = $("#busquedaPuntos").val();
		
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8084/APIEnSusManos/v1/puntos/'+busquedaPuntosId
		
		}).then(function(data) {
			if(data.length == undefined){
				$("#tabla_puntos tbody tr").remove();
					var nuevafilaPuntos = "<tr><td>" +
						data.id_puntos + "</td><td>" +
						data.descripcion + "</td><td>" +
						data.usuarios + "</td><td>" +
						data.eventos + "</td><td>";
					$("#tabla_puntos").append(nuevafilaPuntos);
			}else{
				$("#tabla_puntos tbody tr").remove();
				for (var i = 0; i < data.length; i++) {
					var nuevafilaPuntos = "<tr><td>" +
						data[i].id_puntos + "</td><td>" +
						data[i].descripcion + "</td><td>" +
						data[i].usuarios + "</td><td>" +
						data[i].eventos + "</td><td>";
					$("#tabla_puntos").append(nuevafilaPuntos);
				}
			}
		});
		return false;
	});
});
/*$(document).ready(function() {
	$("#busqueda_puntos").keyup(function() {
		_this = this;
		$.each($("#tabla_puntos tbody tr"), function() {
			if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
				$(this).hide();
			else
				$(this).show();
		});
	});
});*/
/*FIN script ID Puntos*/


/*INI script Creacion Ciudadanos*/
$(document).ready(function() {
	$('#crearCiudadano').click(function() {
		var nombre = $("#nombre_ciudadano").val();
		var apellido = $("#apellido_ciudadano").val();
		var barrio = $("#barrio_ciudadano").val();
		var usuario = $("#nick_ciudadano").val();
		var password = $("#pass_ciudadano").val();
		
		var data = {
			"nombre": nombre,
			"apellido": apellido,
			"barrio": barrio,
			"usuario": usuario,
			"password": password
		}

		$.ajax({
			type: 'POST',
			url: 'http://localhost:8084/APIEnSusManos/v1/crecionCiudadanos/',
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType: 'json'
		}).then(function(data) {
			alert("usuario Creado Exitosamente");
			window.location.href='../html/ciudadano.html';

		});
		return false;
	});	
});
/*FIN script Creacion Ciudadanos*/


/*INI script Creacion Eventos*/

/*FIN script Creacion Eventos*/



/*INI script Creacion Puntos*/

/*FIN script Creacion Puntos*/