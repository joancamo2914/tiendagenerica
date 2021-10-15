package controlador;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import modelo.LectorCSV;
import modelo.ModeloProductos;
import modelo.Productos;

/**
 * Servlet implementation class Ctrl_productos
 */
@WebServlet("/Ctrl_productos")
public class Ctrl_productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos; 
	
	@Resource(name="jdbc/Productos")
	private DataSource miPool;

	//init es como el metodo main desde el cual arranca la app
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			modeloProductos = new ModeloProductos(miPool);
				
		}catch(Exception e) {
			
			throw new ServletException(e);
		}
		
		}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		// Leer el parámetro "instruccion" del formulario
		
		String elComando = request.getParameter("instruccion");
		
		// si no viene el parámetro, listar la tabla productos
		
		if(elComando==null) elComando="listar";
		
		// Redirigir el flujo de ejecución al método adecuado
		
		switch (elComando) 
		{
		
		case "listar":
			
			obtenerProductos(request, response);
			
			break;
		
		case "insertarBBDD":
			
			agregarProductos(request, response);
			
			break;
			
		case "cargar":
			
			try {
				cargarProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "actualizarBBDD":
			
			try {
				actualizaProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		case "eliminar":
			
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "cargarCSVaBBDD":
			
			CSVProducto(request, response);
			
		default:
			
			obtenerProductos(request, response);
		}
		
	}

	private void CSVProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// recibir el archivo plano de la vista
		
		String archivo_csv = request.getParameter("CSV");
		
		// leer la información del archivo plano
		// crear una lista de objetos producto con la info del archivo plano
		
		try {
			LectorCSV lector = new LectorCSV(archivo_csv);
			lector.leerArchivo2();
			
			// enviar el objeto al modelo y despues insertar el objeto a la base de datos
			
			for (int i= 0; i < lector.getListaProductos().size(); i++) {
				
				try {
					modeloProductos.agregarElNuevoProducto(lector.getListaProductos().get(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				} 
			}
			// volver a la lista de productos
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obtenerProductos(request, response);
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// Capturar el codigo_producto
		
		Long CodProd = Long.parseLong(request.getParameter("Cod_prod"));
		
		// borrar producto de bbdd
		
		modeloProductos.eliminarProducto(CodProd);
		
		//volver al listado de productos
		
		obtenerProductos(request, response);
		
		
	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// Leer los datos que le vienen del formulario de actualizar
		
		Long CodProd = Long.parseLong(request.getParameter("codP"));
		String NomProd = request.getParameter("nomP");
		Long NIT = Long.parseLong(request.getParameter("NIT"));
		double PreCom = Double.parseDouble(request.getParameter("Pcom"));
		double IVA = Double.parseDouble(request.getParameter("IVA"));
		double PreVen = Double.parseDouble(request.getParameter("Pven"));
		
		// Crear un objeto de tipo producto con la info del formulario
		
		Productos ProductoActualizado = new Productos(CodProd, NomProd, NIT, PreCom, IVA, PreVen);
		
		
		// Actualizar la base de de datos con la info del obj Producto
		
		modeloProductos.actualizarProducto(ProductoActualizado);
		
		// Volver al listado con la info actualizada
		
		obtenerProductos(request, response);
	}

	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// Leer el Codigo producto que viene del listado
		
		String codigoProducto = request.getParameter("Cod_prod");
		
		// Enviar codigo producto a modelo
		
		Productos elProducto = modeloProductos.getProductos(codigoProducto);
		
		// Colocar atributo correspondiente al codigo producto
		
		request.setAttribute("ProductoaActualizar", elProducto);
		
		// Envíar Producto al formulario de actualizar (jsp)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizarProducto.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//leer la información del producto que viene del formulario inserta_producto
		
		Long CodProd = Long.parseLong(request.getParameter("codP"));
		String NomProd = request.getParameter("nomP");
		Long NIT = Long.parseLong(request.getParameter("NIT"));
		double PreCom = Double.parseDouble(request.getParameter("Pcom"));
		double IVA = Double.parseDouble(request.getParameter("IVA"));
		double PreVen = Double.parseDouble(request.getParameter("Pven"));
		
		//Crear un objeto de tipo Producto
		
		Productos NuevoProducto = new Productos(CodProd, NomProd, NIT, PreCom, IVA, PreVen);
				
		//Envíar el objteo al modelo y despues insertar el objeto producto en la bbdd
		
		try {
			modeloProductos.agregarElNuevoProducto(NuevoProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Volver a listar la tabla de productos
			
		obtenerProductos(request, response);
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// obtener la lista de productos desde el modelo
		
		List<Productos> productos;
		
		try {
			
			productos = modeloProductos.getProductos();
		
		
		// agregar la lista de productos al request
		
			request.setAttribute("LISTAPRODUCTOS", productos);
		
		// enviar ese request a la pagina JSP
		
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/Listaproductos.jsp");
			
			miDispatcher.forward(request, response);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
