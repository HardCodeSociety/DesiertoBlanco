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
    @Test
    public void deberiaAbrirUnArchivo(){
        File archivo= new File("archivos/desierto.data");
        Desierto desierto;
        int xInicial=1,yInicial=2,xFinal=3,yFinal=4;
        try {
			desierto=Desierto.demeDesierto(); 
            desierto.seMueven();
            desierto.seMueven();
            desierto.algunosElementos();
            xInicial=desierto.demeElemento(1).getPosX();
            yInicial=desierto.demeElemento(1).getPosY();
            DesiertoArchivos.guarde(archivo,desierto);
            desierto.reiniciar();
            desierto.cambieDesierto(DesiertoArchivos.abra(archivo));
            desierto=Desierto.demeDesierto();
            xFinal=desierto.demeElemento(1).getPosX();
            yFinal=desierto.demeElemento(1).getPosY();  	
		} catch(Exception e) {
			e.printStackTrace();	
        }
        assertEquals("no se abrio ",xInicial,xFinal);
        assertEquals("no se abrio ",yFinal,yInicial);
    }
}