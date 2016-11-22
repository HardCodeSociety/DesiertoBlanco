package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MinuciosoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MinuciosoTest
{
    /**
     * Default constructor for test class MinuciosoTest
     */
    public MinuciosoTest()
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
    public void DeberiaPermitirAgregarUnMinucioso(){
        Desierto d= Desierto.demeDesierto();
        Minucioso m= new Minucioso(d, "Minu");
        assertEquals("Se creo",m.getPosX(),0);
        assertEquals("Se creo",m.getPosY(),0);
    }
    @Test
    public void DeberiaPermitirRecorrerMinuciosamente(){
        Desierto d= Desierto.demeDesierto();
        Minucioso m= new Minucioso(d, "Minu");
        int posinix=m.getPosX();
        int posiniy= m.getPosY();
        m.muevase();
        int posx= m.getPosX();
        int posy=m.getPosY();
        if(posinix==500){
            assertEquals("Se mueve minuciosamente",posx,0);
            assertTrue(posy!=posiniy);
        } else{
            assertEquals("Se mueve minuciosamente",posy,posiniy);
            assertTrue(posx!=posinix);            
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
