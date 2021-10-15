package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import modelo.UsuarioDAO;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO dao = new UsuarioDAO();
	String comando="";

	public Controlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		comando= request.getParameter("Instruccion");
		switch (comando) {
		case "verify":
			verify(request,response);
			break;
		case "search":
			search(request,response);
			break;
		case "edit":
			edit(request,response);
			break;
		case "del":
			del(request,response);
			break;
		default:
			
			break;
		}	
	}

	private void del(HttpServletRequest request, HttpServletResponse response) {
		// 
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// 
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//leer el dato cc y buscarlo en la bd
		PrintWriter out = response.getWriter();
		String cc=request.getParameter("cedula");
		
		String respuesta = dao.search(cc);
		
		if (respuesta != null) {
			//cargar los datos para visualizarlos
			RequestDispatcher dis=request.getRequestDispatcher("vista/menu.jsp");
			dis.forward(request, response);
		} else {
			response.setContentType("text/html");
			out.println("<body>");
			out.println("<script language=\"javascript\">");
			out.println("var resultado = window.confirm('Usuario No Encontrado: Verifique Cedula');");
			out.println("if (resultado === true) {");
			out.println("location.href = \"Index.jsp\";");
			out.println("} else { ");
			out.println("location.href = \"Index.jsp\";");
			out.println("}");
			out.println("</script>");
			out.println("<p>");
			out.println("</p>");
		}
	}

	private void verify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("usuario");
		String passwrd = request.getParameter("pass");
		
		boolean respuesta = dao.verify(user, passwrd);
		if (respuesta == true) {
			RequestDispatcher dis=request.getRequestDispatcher("vista/menu.jsp");
			dis.forward(request, response);
		} else {
			response.setContentType("text/html");
			out.println("<body>");
			out.println("<script language=\"javascript\">");
			out.println("var resultado = window.confirm('Usuario No Registrado');");
			out.println("if (resultado === true) {");
			out.println("location.href = \"Index.jsp\";");
			out.println("} else { ");
			out.println("location.href = \"Index.jsp\";");
			out.println("}");
			out.println("</script>");
			out.println("<p>");
			out.println("</p>");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
	}
}
