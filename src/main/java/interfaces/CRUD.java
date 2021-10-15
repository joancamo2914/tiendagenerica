package interfaces;

import modelo.Usuarios;



public interface CRUD {
	public boolean add(Usuarios user);
	public String search(String cc);
	public boolean edit(String cc);
	public boolean del(String cc);
	public boolean verify(String User,String passwrd);
}
