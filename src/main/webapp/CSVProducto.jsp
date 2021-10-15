<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>Formulario para CSV</title>
</head>
<body>
    <h1 style="text-align:center" >SUBIR EL CSV</h1>
    <form name="form1" method="get" action="Ctrl_productos">
    
    <input type="hidden" name = "instruccion" value="cargarCSVaBBDD">

    
   
        <table>
    
            <tr>
            	<td>Inserte archivo CSV</td>
                <td><label for="CSV"></label>
                <input type="file" name="CSV" id="CSV" ></td>
           </tr>
            <tr>
            
                <td><input type="submit" value="Envíar" name="envio" id="envio" ></td>
                <td><input type="reset" value="Restablecer" name="borrar" id="borrar"></td>
            </tr>

        </table>

    </form>
</body>
</html>