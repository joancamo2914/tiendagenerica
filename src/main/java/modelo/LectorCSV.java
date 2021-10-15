package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorCSV {
	
    public static final char SEPARATOR = ';';
    public static final char QUOTE = '"';
    private List<Productos> ListaProductos;
    private BufferedReader br;
    private String ruta;
    
    public LectorCSV(String ruta) throws IOException {

        try {
            this.ListaProductos = new ArrayList<>();
            this.br = new BufferedReader(new FileReader(ruta));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //lea todas las lineas y las agregue a un arraylist
    public void leerArchivo2(){
    	String linea = "";
    	List <String> datosDeArchivo = new ArrayList<>();
    	try {
			while ((linea=br.readLine())!= null) {
				
				datosDeArchivo.add(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   //que elimine la primera linea
    	datosDeArchivo.remove(0);
    	
    	for( String i : datosDeArchivo) {
    		procesarCadena(i);
    	}
    }

    public void leerArchivo() throws IOException {
        String linea = "";
        while ((linea = br.readLine()) != null) {
            procesarCadena(linea);
        }
    }
    
    public void procesarCadena(String linea) {
        String datosDeLinea[] = linea.split(";");
        String[] resultado = new String[datosDeLinea.length];

        for (int j = 0; j < datosDeLinea.length; j++) {
            resultado[j] = datosDeLinea[j].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        anexarProducto(resultado);

    }
    
	public void anexarProducto(String[]resultado) {

        Long codigo			= Long.parseLong(resultado[0]) ;
        Long nitproveedor	= Long.parseLong(resultado[1]);
        String nombres		= resultado[2];
        Double preciocompra	= Double.parseDouble(resultado[3]);
        Double ivacompra	= Double.parseDouble(resultado[4]);
        Double precioventa	= Double.parseDouble(resultado[5]);
        
        Productos unProducto = new Productos(codigo, nombres, nitproveedor, preciocompra, ivacompra, precioventa);
        ListaProductos.add(unProducto);
    }
    
    public List<Productos> getListaProductos() {
		return ListaProductos;
	}

	public void setListaProductos(List<Productos> listaProductos) {
		ListaProductos = listaProductos;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public static char getSeparator() {
		return SEPARATOR;
	}

	public static char getQuote() {
		return QUOTE;
	}


 
    
    


}
