package modelo;

public class Usuarios {
	int id;
	String cc;
	String nombre;
	String email;
	String user;
	String pass;
	public Usuarios() {
		
	}
	public Usuarios(String cc, String nombre, String email, String user, String pass) {
		super();
		this.cc = cc;
		this.nombre = nombre;
		this.email = email;
		this.user = user;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
