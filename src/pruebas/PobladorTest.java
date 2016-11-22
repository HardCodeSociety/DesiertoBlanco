package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PobladorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PobladorTest
{
    /**
     * Default constructor for test class PobladorTest
     */
    public PobladorTest()
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
    public void DeberiaCrearUnPoblador(){
        Desierto d = Desierto.demeDesierto();
        Poblador p= new Poblador(d,"Poblador",20,20);
        assertEquals("Se creo",p.getPosX(),20);
        assertEquals("Se creo",p.getPosY(),20);
    
    }
    @Test
    public void DeberiaPermitirAdicionarAlMover(){
        Desierto d = Desierto.demeDesierto();
        Poblador p= new Poblador(d,"Poblador",20,20);
        int tam=d.getElementos().size();
        p.muevase();
        int tam2=d.getElementos().size();
        boolean resp=false;
        if(p.getSiConvencio()){
            if (tam==tam2){
                assertTrue(resp);
            }else{
                resp=true;
                assertTrue(resp);
            } 
        }else{
            assertFalse(resp);
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
