package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DesiertoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DesiertoTest
{
    /**
     * Default constructor for test class DesiertoTest
     */
    public DesiertoTest()
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
    public void deberiaMoverTodos(){
       Desierto d=Desierto.demeDesierto();
       d.algunosElementos();
       int[][] before=posiciones(d);
       d.seMueven();
       int[][] after=posiciones(d);
       boolean resp=true;
       for (int i=0;i<d.numeroElementos()&& resp;i++){
         if ((before[i][0]==after[i][0])&&(before[i][1]==after[i][1])){
            resp=false;
         }
        }
       assertTrue("No se mueven",resp);
    }
    public int[][] posiciones(Desierto d){
       int[][] pos=new int[d.numeroElementos()][2];
       for (int i=0;i<d.numeroElementos();i++){
        Elemento a=d.demeElemento(i+1);
        pos[i][0]=a.getPosX();
        pos[i][1]=a.getPosY();
        } 
       return pos;
    }
    @Test
    public void deberiaMoverUno(){
        Desierto d =Desierto.demeDesierto();
        d.algunosElementos();
        Elemento a =d.demeElemento(1);
        boolean resp=true;
        int beforeX=a.getPosX();
        int beforeY=a.getPosY();
        d.seMueve(1);
        int afterX=a.getPosX();
        int afterY=a.getPosY();
        if(beforeX==afterX && beforeY==afterY)resp=false;
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
