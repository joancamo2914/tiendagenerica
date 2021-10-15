<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel=stylesheet type="text/css" href="vista/css/TiendaGenerica.css">
<title>www.tiendagenerica.com</title>
</head>
<body>
<br>
<br>
<h1 >Bienvenidos a la Tienda Genérica</h1><br>
	<form method="post" action="Controlador">
	<input type = "hidden" name="Instruccion" value="verify">
		<table>
			<tr>
				<td><label>Usuario</label></td>
				<td ><input type="text" name="usuario" id="usuario"class="cuadro"></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>	
				<td><label>Contraseña  </label></td>
				<td><input type="password" name="pass" id="pas" class="cuadro"></td>
			</tr>
			<tr>
				<td><br><br><input type="submit" class="boton" value="Aceptar"></td>
				<td><br><br><input type="button" class="boton" value="Cancelar"></td>
			</tr>
		</table>
	</form>
</body>
</html>