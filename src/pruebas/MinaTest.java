package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MinaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MinaTest
{
    /**
     * Default constructor for test class MinaTest
     */
    public MinaTest()
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
    public void DeberiaCrearUnaMina(){
        Desierto d= Desierto.demeDesierto();
        Mina minita= new Mina(d, 20,20);
        assertEquals("Se creo",20,minita.getPosY());
        assertEquals("Se creo",20,minita.getPosX());        
    }
    @Test
    public void DeberiaPermitirEliminar(){
        Desierto d= Desierto.demeDesierto();
        Mina minita= new Mina(d, 20,20);
        minita.muevase();
        int len=(d.getElementos()).size();
        if (minita.getA()==3){
            assertTrue(len!=(d.getElementos()).size());
        }else{
            assertTrue(len==(d.getElementos()).size());
        }    
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
