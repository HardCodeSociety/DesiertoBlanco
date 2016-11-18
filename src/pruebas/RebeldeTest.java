package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RebeldeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RebeldeTest
{
    /**
     * Default constructor for test class RebeldeTest
     */
    public RebeldeTest()
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
    public void DeberiaCrearUnRebelde(){
        Desierto d =Desierto.demeDesierto();
        Elemento reb=new Rebelde(d,"rebel",25,25);
        assertEquals("No se creo",reb.getPosX(),25);
        assertEquals("No se creo",reb.getPosY(),25);
    }
    @Test
    public void DebeMoverseRebeldemente(){
        int cont=0;
        boolean resp=true;
        Desierto d=Desierto.demeDesierto();
        Elemento reb=new Rebelde(d,"rebel",10,10);
        int beforeX=reb.getPosX();
        int beforeY=reb.getPosY();
        for (int i=1;i<=3 && resp;i++){
            ((Rebelde)reb).muevase();
            if (i<3){
                resp=(reb.getPosX()==beforeX)&&(reb.getPosY()==beforeY);
            }else{
                resp=(reb.getPosX()!=beforeX)||(reb.getPosY()!=beforeY);
            }
        }
        assertTrue("No se mueve",resp);
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
