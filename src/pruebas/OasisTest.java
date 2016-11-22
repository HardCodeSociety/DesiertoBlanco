package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
/**
 * The test class OasisTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OasisTest
{
    /**
     * Default constructor for test class OasisTest
     */
    public OasisTest()
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
    public void sePuedeCrearUnOasis(){
        Desierto d=Desierto.demeDesierto();
        Oasis o=new Oasis(d,45,50);
        assertEquals("No se creo el objeto",o.getPosX(),45);
        assertEquals("No se creo el objeto",o.getPosY(),50);
    }  
    @Test
    public void seMueveComoOasis(){
        Desierto d =Desierto.demeDesierto();
        Oasis o=new Oasis(d,45,50);
        Color beforeColor=o.getColor();
        o.muevase();
        assertTrue("No cambio su color",beforeColor!=o.getColor());
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
