package pruebas;

import aplicacion.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

public class DesiertoArchivosTest{
    public DesiertoArchivosTest(){}
    @Test 
    public void deberiaCrearUnArchivo(){
        File archivo= new File("archivos/desierto.data");
        Desierto desierto;
        try {
			desierto=Desierto.demeDesierto(); 
            DesiertoArchivos.guarde(archivo,desierto);  	
		} catch(Exception e) {
			e.printStackTrace();	
        }
        assertTrue("NO EXISTE EL ARCHIVO",archivo.exists());
    }
}