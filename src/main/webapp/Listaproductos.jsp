<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.cabecera{
text-align:center;
font-size: 1.2em;
font-weight:bold;
color:#FFFFFF;
background-color: #08088A;
}

.filas{
text-align:center;
background-color: #5882FA
}

table{
	float:left;
	}
	
#contenedorBoton{
	margin-left:1000px;
}

</style>
</head>




<body>
	<table>
		<tr>
			<td class="cabecera" >Código Producto</td>
			<td class="cabecera" >Nombre del producto</td>
			<td class="cabecera" >NIT Proveedor</td>
			<td class="cabecera" >Precio de compra</td>
			<td class="cabecera" >IVA de compra</td>
			<td class="cabecera" >Precio de venta</td>
			<td class="cabecera" >Acción</td>
			
		</tr>
		
		<!-- Listaproductos es el nombre de la lista guardada en Ctrl_productos -->
		
		<c:forEach var="tempProd" items="${LISTAPRODUCTOS}" > 
		
		<!-- Link para cada producto con su campo clave -->
		
		<c:url var="linkTemp" value = "Ctrl_productos">
		
			<c:param name="instruccion" value="cargar"></c:param>
			<c:param name="Cod_prod" value="${tempProd.codigo_producto }" ></c:param>
		
		</c:url>
		
		<!-- Link para eliminar cada registro con su campo clase -->
		
		<c:url var="linkTempEliminar" value = "Ctrl_productos">
		
		<c:param name="instruccion" value="eliminar"></c:param>
		<c:param name="Cod_prod" value="${tempProd.codigo_producto }"></c:param>
		
		</c:url>
		
		<tr> 
		<!-- usando jsptags puedo acceder a las variables privadas
		 sin usar los getters, tengo que escribir el nombre tal cual
		 esta en la clase Productos.java -->
			
			<td class="filas"> ${tempProd.codigo_producto }</td>
			<td class="filas"> ${tempProd.nombre_producto }</td>
			<td class="filas"> ${tempProd.nitproveedor }</td>
			<td class="filas"> ${tempProd.precio_compra }</td>
			<td class="filas"> ${tempProd.ivacompra }</td>
			<td class="filas"> ${tempProd.precio_venta }</td>
			<td class="filas"> <a href= "${linkTemp }"> Actualizar</a> &nbsp;&nbsp;&nbsp; 
			<a href= "${linkTempEliminar }">Eliminar</a>  </td>
		
		
		</tr>
		
		</c:forEach>
	
	</table>
	
	<div id="contendorBoton" >
		
		<!-- onclick="window.location.href='inserta_producto.jsp'" /> -->
		<input type="button" value="Insertar Registro" 
		
		onclick="window.location.href='CSVProducto.jsp'" />
	</div>

</body>
</html>