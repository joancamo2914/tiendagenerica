package interfaces;

import modelo.Productos;

public interface ProductoCRUD {

	public boolean add(Productos prod);
	public String search(long cp);
	public boolean edit (long cp);
	public boolean del (long cp);
}
