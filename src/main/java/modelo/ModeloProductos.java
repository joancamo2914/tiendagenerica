package modelo;



import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource origenDatos;
	
	public ModeloProductos (DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	//metodo que muestra la lista que se muestra al usuario despues de consultar
	
	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productoslist = new ArrayList<>();
		
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultset = null;
				
		// ---establecer la conexion---
		
		miConexion = origenDatos.getConnection();
		
		//--- crear sentencia sql y statement----
		
		String instruccionSql = "SELECT * FROM PRODUCTOS";
		
		miStatement = miConexion.createStatement();
		
		//--- ejecutar sql y almacenar lo que nos devuelva -----
		
		miResultset = miStatement.executeQuery(instruccionSql);
		
		// ----- recorrer el resultset obtenido-----
		
		while (miResultset.next()) {
			
			//entre comillas va el campo de la tabla como esta en el mysql
			
			long cod = miResultset.getLong("codigo_producto");
			long nitp = miResultset.getLong("nitproveedor");
			String nom = miResultset.getString("nombre_producto");
			Double pcom = miResultset.getDouble("precio_compra");
			Double iva = miResultset.getDouble("ivacompra");
			Double pven = miResultset.getDouble("precio_venta");

			//crear el objeto productos con el resultset
			
			Productos temProd = new Productos(cod, nom, nitp, pcom, iva, pven);
			
			//añadirlos a la lista productoslist
			
			productoslist.add(temProd);
		}
		
		return productoslist;
	}

	public void agregarElNuevoProducto(Productos nuevoProducto) throws Exception {
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		
		PreparedStatement miStatement = null;
		
		//Obtener la conexión
		
		try {
			
			miConexion = origenDatos.getConnection();

		// Crear instrucción SQL. Crear la consulta preparada (statement)
		
		String sql = "INSERT INTO productos (codigo_producto, nitproveedor, nombre_producto, precio_compra, ivacompra, precio_venta) "+
		"VALUES(?,?,?,?,?,?)";
		
		miStatement = miConexion.prepareStatement(sql);
		
		// Establecer parámetros del producto

		miStatement.setLong(1, nuevoProducto.getCodigo_producto());

		miStatement.setLong(2, nuevoProducto.getNitproveedor());
		
		miStatement.setString(3, nuevoProducto.getNombre_producto());

		miStatement.setDouble(4, nuevoProducto.getPrecio_compra()); 
		
		miStatement.setDouble(5, nuevoProducto.getIvacompra());
		
		miStatement.setDouble(6, nuevoProducto.getPrecio_venta());
		
		// eejecutar el sql

		miStatement.execute();
		
		}catch(Exception e) {
			e.printStackTrace();		
				}finally {
					miStatement.close();
					miConexion.close();
				}
	}

	public Productos getProductos(String codigoProducto) {
		// TODO Auto-generated method stub
		
		Productos elProducto  = null;
		
		Connection miConexion = null;
		
		PreparedStatement miStatement = null;
		
		ResultSet miResultset = null;
		
		String cProducto = codigoProducto;
		
		try {
		
		//Establecer la conexión con la BBDD
		
		miConexion = origenDatos.getConnection();
		
		// Crear el sql que busque el producto
		
		String sql = "SELECT * FROM productos WHERE codigo_producto=?";
		
		// Crear la consulta preparada
		
		miStatement = miConexion.prepareStatement(sql);
		
		// Establecer los parametros de esa consulta
		
		miStatement.setString(1, cProducto);
		
		// ejecutar la consulta
		
		miResultset = miStatement.executeQuery();
		
		// Obtener los datos de respuesta
		
		if (miResultset.next()) {
			
//entre comillas va el campo de la tabla como esta en el mysql
			
			long cod = miResultset.getLong("codigo_producto");
			long nitp = miResultset.getLong("nitproveedor");
			String nom = miResultset.getString("nombre_producto");
			Double pcom = miResultset.getDouble("precio_compra");
			Double iva = miResultset.getDouble("ivacompra");
			Double pven = miResultset.getDouble("precio_venta");

			//crear el objeto elproducto con el resultset
			
			elProducto = new Productos(cod, nom, nitp, pcom, iva, pven);
			
		}else {
			
			throw new Exception("No hemos encontrado el producto con codigo de producto = "+cProducto );
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return elProducto;
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion = null;
		
		PreparedStatement miStatement = null;
		
		//Establecer la conexion
		try {
		miConexion = origenDatos.getConnection();
		
		// Crear sentencia sql
		
		String sql = "UPDATE productos SET nombre_producto=?, nitproveedor=?, "
				+ "precio_compra=?, ivacompra=?, precio_venta=? WHERE codigo_producto=?";
		
		// Crear la consulta preparada
		
		miStatement = miConexion.prepareStatement(sql);
		
		//Establecer los parametros
		
		miStatement.setString(1, productoActualizado.getNombre_producto());
		
		miStatement.setLong(2, productoActualizado.getNitproveedor());
		
		miStatement.setDouble(3, productoActualizado.getPrecio_compra());
		
		miStatement.setDouble(4, productoActualizado.getIvacompra());
		
		miStatement.setDouble(5, productoActualizado.getPrecio_venta());
		
		miStatement.setLong(6, productoActualizado.getCodigo_producto());
		
		
		//Ejecutar la instruccion SQL
		
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}

	public void eliminarProducto(Long codProd) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion = null;
		
		PreparedStatement miStatement = null;
		
		//Establecer la conexion
		try {
		miConexion = origenDatos.getConnection();
		
		// Crear la insstruccción SQL de eliminación
		
		String sql="DELETE FROM productos WHERE codigo_producto=?";
				 
		// Preparar la consulta
		
		miStatement = miConexion.prepareStatement(sql);
				
		// Establecer parametros de consulta
		
		miStatement.setLong(1, codProd);
		
		
		// Ejecutar la sentencia SQL
		
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}
}
