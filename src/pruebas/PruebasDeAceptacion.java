package pruebas;

import aplicacion.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

public class PruebasDeAceptacion{
    @Test
    public void deberiaGuardaryAbrirUnDesierto(){
    File archivo= new File("archivos/desierto.dat");
    Desierto desierto;
    int xInicial=1,yInicial=2,xFinal=3,yFinal=4;
        try {
			desierto=Desierto.demeDesierto();
            desierto.reiniciar(); 
            desierto.algunosElementos();
            desierto.seMueven();
            desierto.seMueven();
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
        assertEquals("no se abrio x",xInicial,xFinal);
        assertEquals("no se abrio y",yFinal,yInicial);
    }
    @Test 
    public void deberiaMostrarmeMensajesDeError(){
      File archivo= new File("archivos/desierto.data");
      archivo.setReadOnly();
      Desierto desierto;
      String mensaje="";
      try {
		desierto=Desierto.demeDesierto(); 
     DesiertoArchivos.guarde(archivo,desierto);  	
	} catch(DesiertoExcepcion e) {
		mensaje=e.getMessage();
    }
    assertEquals("si es el mensaje",mensaje,"Error en la entrada o salida");
   }     
}