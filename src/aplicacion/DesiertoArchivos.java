package aplicacion;
import java.io.*;
import java.util.*;
import java.awt.*;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoArchivos{
	public static void guarde(File f, Desierto d) throws IOException {    	
	    ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("f.dat"));
		out.writeObject(d);
		out.close();
	}

	public static Desierto abra(File f)  throws DesiertoExcepcion{
	    if (true) throw new DesiertoExcepcion("Abra: "+DesiertoExcepcion.NO_CONSTRUIDO);
		return null;
	}
	
	public static void exporte(File f, Desierto d) throws DesiertoExcepcion{
	    throw new DesiertoExcepcion("Exporte: "+DesiertoExcepcion.NO_CONSTRUIDO);
	}
	
	public static Desierto importe(File f) throws DesiertoExcepcion{
	    if (true) throw new DesiertoExcepcion("Importe: "+DesiertoExcepcion.NO_CONSTRUIDO);
		return null;
	}
}
