package aplicacion;
import java.io.*;
import java.util.*;
import java.awt.*;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public static void export(File f, Desierto d) throws DesiertoExcepcion{
	if (f == null || d == null)
	    throw new DesiertoExcepcion(DesiertoExcepcion.NO_VALOR_PARAMETR);

	StringBuffer guard = new StringBuffer();

	for(int i = 1; i <= d.numeroElementos(); i++) {
	    Elemento e = d.demeElemento(i);
	    guard.append(e.getClass().getName().split("\\.")[1] + " " + e.getPosX() + " " + e.getPosY() + "\n");
	}
	try {
	    PrintWriter out = new PrintWriter(f);
	    out.print(guard);
	    out.close();
	} catch(IOException e) {
	    throw new DesiertoExcepcion(DesiertoExcepcion.ERROR);
	}
  public static Desierto import(File f) throws DesiertoExcepcion{
  	if (f == null)
  	    throw new DesiertoExcepcion(DesiertoExcepcion.NO_VALOR_PARAMETR);

  	BufferedReader in = null;

  	Desierto desiertoOriginal = Desierto.demeDesierto();
  	Desierto.nuevoDesierto();
  	Desierto d = Desierto.demeDesierto();

  	final int cantParametros = 3;
  	int line = 0;
  	boolean error = false;

  	try {
  	    in = new BufferedReader(new FileReader(f));
  	    String actual = null;
  	    do {
  		actual = in.readLine();
  		line++;
  		if (actual == null)
  		    continue;

  		String[] args = actual.split("\\s+");
  		if (args.length != cantParametros) {
  		    error = true;
  		    errorMessage(line, "La cantidad de argumentos no es valida (son " + cantParametros + ", hay " + args.length + ")");
  		    continue;
  		}

  		String nombre = args[0];
  		int posX = -1;
  		int posY = -1;
  		try {
  		    posX = Integer.parseInt(args[1]);
  		    posY = Integer.parseInt(args[2]);
  		} catch(NumberFormatException e) {
  		    error = true;
  		    errorMessage(line, args[1] + " o " + args[2], "Algun argumento no es entero o es invalido");
  		    continue;
  		}

  		Elemento e = validarElemento(nombre, d, posX, posY);
  		if (e == null) {
  		    error = true;
  		    errorMessage(line, nombre, "No es un elemento valido");
  		    continue;
  		}
  		d.algunosElementos(e);
  	    } while(actual != null);
  	} catch(IOException e) {
  	    throw new DesiertoExcepcion(DesiertoExcepcion.ERROR);
  	}

  	if (error) {
  	    throw new DesiertoExcepcion(DesiertoExcepcion.ERROR_IMPORTACION);
  	}

  	return d;
      }
}
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

	public static Desierto abra(File f) throws DesiertoExcepcion{
		try{
			ObjectInputStream in =new ObjectInputStream(new FileInputStream(f));
			Desierto desiertoGuardado=(Desierto) in.readObject();
			in.close();
			return desiertoGuardado;
		}catch(IOException e){
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR);
		}catch(ClassNotFoundException e){
			throw new DesiertoExcepcion(DesiertoExcepcion.ERROR);
		}
	}

	public static void exporte(File f, Desierto d) throws DesiertoExcepcion{
	    throw new DesiertoExcepcion("Exporte: "+DesiertoExcepcion.NO_CONSTRUIDO);
	}

	public static Desierto importe(File f) throws DesiertoExcepcion{
	    if (true) throw new DesiertoExcepcion("Importe: "+DesiertoExcepcion.NO_CONSTRUIDO);
		return null;
	}
}
