<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel=stylesheet type="text/css" href="css/estilousuarios.css">
<title>Usuarios</title>
</head>
<body>
	<header>
		<h1>Tienda Genérica</h1>
	</header>
	<nav>
		<div id="menu">
			<ul>
				<li id="item"><a href="#">Usuarios</a></li>	
				<li id="item"><a href="#">Clientes</a></li>
				<li id="item"><a href="#"> Proveedores</a></li>
				<li id="item"><a href="#"> Productos</a></li>
				<li id="item"><a href="#"> Ventas</a></li>
				<li id="item"><a href="#"> Resportes</a></li>
			</ul>
		</div>
	</nav>
	<div class="clearfix"></div>
	<div id="container">
		<section id="content">
			<form name= "form1" method ="get" action = "Controlador" >
			<br><br>
				<table>
				<tr>
					<td><label>Cédula</label> </td>
					<td><input name='cedula' type='name' id = "cc"class = "intro" /></td> 
					<td><label>Usuario</label></td>
					<td><input name='usuario' type='name'  id = "user"  class = "intro" /></td> 
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
					<td><label> Nombre Completo</label></td> 
					<td><input name='nombre' type='name'  id = "nombrec" class = "intro"/> </td>
					<td><label>Contraseña</label></td> 
					<td><input name='Contraseña' type='password' id = "pass" class = "intro" /></td>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
					<td><label> Correo Electrónico</label></td> 
					<td><input name='Email' type='email' id = "correo" class ="intro" /></td>
					</tr>
				</table>
				<div class='submit'>
					<button>Consultar</button>
					<input type = "hidden" name="Instruccion" value="search">
					<button>Crear</button>
					<input type = "hidden" name="Instruccion" value="add">
					<button>Actualizar</button>
					<input type = "hidden" name="Instruccion" value="edit">
					<button>Borrar</button>
					<input type = "hidden" name="Instruccion" value="del">
				</div>
			</form>
		</section>
	</div>
</body>
</html>