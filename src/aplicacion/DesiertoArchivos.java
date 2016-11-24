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
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR);  
		}
	}

	public static Desierto abra(File f)  throws IOException, ClassNotFoundException{
		ObjectInputStream in =new ObjectInputStream(new FileInputStream(f));
		Desierto desiertoGuardado=(Desierto) in.readObject();
		in.close();
		return desiertoGuardado;
	}
	
	public static void exporte(File f, Desierto d) throws DesiertoExcepcion{
	    throw new DesiertoExcepcion("Exporte: "+DesiertoExcepcion.NO_CONSTRUIDO);
	}
	
	public static Desierto importe(File f) throws DesiertoExcepcion{
	    if (true) throw new DesiertoExcepcion("Importe: "+DesiertoExcepcion.NO_CONSTRUIDO);
		return null;
	}
}
