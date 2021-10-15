<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>Formulario para insertar un producto</title>
</head>
<body>
    <h1 style="text-align:center" >Inserta registros</h1>
    <form name="form1" method="get" action="Ctrl_productos">
    
    <!-- esta instruccion esta hidden para que el metodo get muestre todos los productos  -->
    
    <input type="hidden" name = "instruccion" value="insertarBBDD">
        <table>
            <tr>
                <td>Código Producto</td>
                <td><label for="codP"></label>
                <input type="text" name="codP" id="codP"></td>
            </tr>
            <tr>
                <td>Nombre Producto</td>
                <td><label for="nomP"></label>
                <input type="text" name="nomP" id="nomP"></td>
           </tr>
            <tr>
            	<td>NIT Proveedor</td>
                <td><label for="NIT"></label>
                <input type="text" name="NIT" id="NIT"></td>
           </tr>
            <tr>
                <td>Precio de compra</td>
                <td><label for="Pcom"></label>
                <input type="text" name="Pcom" id="Pcom"></td>
            </tr>
            <tr>
            	<td>IVA de la compra</td>
                <td><label for="IVA"></label>
                <input type="text" name="IVA" id="IVA"></td>
           </tr>
            <tr>
            	<td>Precio de venta</td>
                <td><label for="Pven"></label>
                <input type="text" name="Pven" id="Pven"></td>
           </tr>
            <tr>
            	<td>Inserte archivo CSV</td>
                <td><label for="CSV"></label>
                <input type="file" name="CSV" id="CSV"></td>
           </tr>
            <tr>
            
                <td><input type="submit" value="Envíar" name="envio" id="envio" ></td>
                <td><input type="reset" value="Restablecer" name="borrar" id="borrar"></td>
            </tr>

        </table>

    </form>
</body>
</html>