package aplicacion;
import java.io.*;
import java.util.*;
import java.awt.*;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoArchivos{
	public static void guarde(File f, Desierto d) throws DesiertoExcepcion {
		try{
	    	ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(d);
			out.close();
		}catch(IOException e){
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR_IO);  
		}
	}

public static Desierto abra(File f) throws DesiertoExcepcion{
		try{
			ObjectInputStream in =new ObjectInputStream(new FileInputStream(f));
			Desierto desiertoGuardado=(Desierto) in.readObject();
			in.close();
			return desiertoGuardado;
		}catch(IOException e){
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR_IO); 
		}catch(ClassNotFoundException e){
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR_CLASE); 
		}
	}
public static void exporte(File f, Desierto d) throws DesiertoExcepcion{
		try{
			PrintWriter guard = new PrintWriter(new FileOutputStream(f));
			for(int i = 1; i <= d.numeroElementos(); i++) {
	    		Elemento e = d.demeElemento(i);
	    		guard.println(e.getClass().getName().split("\\.")[1] + " " + e.getPosX() + " " + e.getPosY());
			}
			guard.close();
		} catch(IOException e) {
	    	throw new DesiertoExcepcion(DesiertoExcepcion.ERROR_IO);
		}
	}

	public static Desierto importe(File f) throws DesiertoExcepcion{
		try{
			BufferedReader in = new BufferedReader(new FileReader(f));
			String linea=in.readLine();
			while(linea!=null){
				String[] Estalinea = linea.split(" ");
				if (esClase(Estalinea[0])){
					creeInstancia(Estalinea[0],Integer.parseInt(Estalinea[1]),Integer.parseInt(Estalinea[2]));
				}
				linea=in.readLine();
			}
			return Desierto.demeDesierto();
		}catch(IOException e){
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR_IO); 
		}
	}
	private static Boolean esClase(String nombre){
		ArrayList<String> clases=new ArrayList<String>();
		clases.add("Egiptologo");
		clases.add("Mina");
		clases.add("Exterminador");
		clases.add("Minucioso");
		clases.add("Poblador");
		clases.add("Rebelde");
		clases.add("Oasis");
		return (clases.contains(nombre));	
	}
	private static void creeInstancia(String nombre,int x,int y){
		Desierto desierto;
		try{
			desierto=Desierto.demeDesierto();
			if (nombre.equals("Egiptologo")){
				desierto.agregarElemento(new Egiptologo(desierto,null,x,y));
			}else if (nombre.equals("Mina")){
				desierto.agregarElemento(new Mina(desierto,x,y));
			}else if (nombre.equals("Exterminador")){
				desierto.agregarElemento(new Exterminador(desierto,null,x,y));
			}else if (nombre.equals("Minucioso")){
				desierto.agregarElemento(new Minucioso(desierto,null));
			}else if (nombre.equals("Poblador")){
				desierto.agregarElemento(new Poblador(desierto,null,x,y));
			}else if (nombre.equals("Rebelde")){
				desierto.agregarElemento(new Rebelde(desierto,null,x,y));
			}else if (nombre.equals("Oasis")){
				desierto.agregarElemento(new Oasis(desierto,x,y));
			}
		}catch(Exception e){}
		}	
}
