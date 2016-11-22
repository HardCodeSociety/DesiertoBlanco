package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExterminadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExterminadorTest
{
    /**
     * Default constructor for test class ExterminadorTest
     */
    public ExterminadorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    @Test
    public void DeberiaPermitirCrearUnExterminador(){
        Desierto d= Desierto.demeDesierto();
        Exterminador ex= new Exterminador(d,"Extermin",50,50);
        assertEquals("Se creo", ex.getPosX(),50);
        assertEquals("Se creo", ex.getPosY(), 50);
    }
    @Test
    public void DeberiaExterminarAlgo(){
        Desierto d= Desierto.demeDesierto();
        Exterminador ex= new Exterminador(d,"Extermin",50,50);
        boolean resp=false;
        int ele= ex.getElegido();
        if (((d.getElementos()).contains(ex.getElemento()))){
            resp=true;
        }
        ex.muevase();
        Elemento el=ex.getElemento();
        if (((d.getElementos()).contains(ex.getElemento()))){
            resp=false;
        }else{
            resp=true;
        }
        
        assertTrue(resp);
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
