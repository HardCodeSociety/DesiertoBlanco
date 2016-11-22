package aplicacion;
import java.io.*;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoArchivos{

	public static void guarde(File f, Desierto d) throws DesiertoExcepcion{
	    throw new DesiertoExcepcion("Guarde: "+DesiertoExcepcion.NO_CONSTRUIDO);
	    
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
